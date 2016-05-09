package leifeng.bs.view.action;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.base.ModelDrivenBaseAction;
import leifeng.bs.domain.Department;
import leifeng.bs.domain.Role;
import leifeng.bs.domain.User;
import leifeng.bs.util.DepartmentUtils;
import leifeng.bs.util.QueryHelper;

@Controller
@Scope("prototype")
public class UserAction extends ModelDrivenBaseAction<User>{
	
	private Long departmentId;
	private Long[] roleIds;
	
	/**  登录页面 */
	public String loginUI()throws Exception{
		
		return "loginUI";
	}
	/**  登录页面 */
	public String login()throws Exception{
		User user=userService.findByLoginNameAndPassword(model.getLoginName(),model.getPassword());
		if(user==null){
			addFieldError("login", "用户名或密码不正确！");
			return "loginUI";
		}else{
			//登录用户
			ActionContext.getContext().getSession().put("user", user);
			
		    return "toIndex";
		}
	}
	/**  注销 */
	public String logout()throws Exception{
		ActionContext.getContext().getSession().remove("user");
		return "logout";
	}
	
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		/*List<User> userList=userService.findAll();
		ActionContext.getContext().put("userList", userList);*/
		
		//准备分页信息
		new QueryHelper(User.class, "u")//
		.preparePageBean(userService, pageNum, pageSize);
		
		return "list";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exeception
	 */
	public String delete()throws Exception{
		userService.delete(model.getId());
		return "toList";
	}
	
	/**
	 * 添加页面
	 */
	public String addUI()throws Exception{
		//准备数据
		List<Department> topList=departmentService.findToList();
		List<Department> departmentList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		//
		List<Role> roleList=roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "saveUI";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		//封装到对象，(当model是实体类型时，也可以使用model，但要设置未封装的属性)
		//设置所属部门
		model.setDepartment(departmentService.getById(departmentId));
		//设置关联岗位
		List<Role> roleList=roleService.getByIds(roleIds);
		model.setRoles(new HashSet<Role>(roleList));
		
		String md5Digest=DigestUtils.md5Hex("1234");
		//设置默认密码
		model.setPassword(md5Digest);
		
		//保存到数据库
		userService.save(model);
		return "toList";
	}
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI()throws Exception{
		//准备数据
		List<Department> topList=departmentService.findToList();
		List<Department> departmentList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		//
		List<Role> roleList=roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		
		// 准备回显的数据
		User user=userService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(user);
		if(user.getDepartment() !=null){
			departmentId=user.getDepartment().getId();
		}
		if(user.getRoles()!=null){
			roleIds=new Long[user.getRoles().size()];
			int index=0;
			for(Role role:user.getRoles()){
				roleIds[index++]=role.getId();
			}
		}
		
		return "saveUI";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String edit()throws Exception{
		// 1，从数据库中获取原对象
		User user=userService.getById(model.getId());
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhoneNumber(model.getPhoneNumber());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		
		user.setDepartment(departmentService.getById(departmentId));
		//设置关联岗位
		List<Role> roleList=roleService.getByIds(roleIds);
		user.setRoles(new HashSet<Role>(roleList));
		// 3，更新到数据库
		userService.update(user);
		return "toList";
	}
	/**
	 * 初始化密码
	 * @return
	 * @throws Exception
	 */
	public String initPassword()throws Exception{
		// 1，从数据库中获取原对象
		User user=userService.getById(model.getId());
		
		String md5Digest=DigestUtils.md5Hex("1234");
		user.setPassword(md5Digest);
		
		// 3，更新到数据库
		userService.update(user);
		return "toList";
	}
	
	//==================参数封装====================

	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
