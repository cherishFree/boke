package leifeng.bs.view.action;

import java.util.HashSet;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import leifeng.bs.base.ModelDrivenBaseAction;
import leifeng.bs.domain.Privilege;
import leifeng.bs.domain.Role;

/**
 * 岗位管理Action
 * @author leifeng
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends ModelDrivenBaseAction<Role> {
	
	private Long[] privilegeIds;
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		List<Role> roleList=roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	/**
	 * 删除
	 * @return
	 * @throws Exeception
	 */
	public String delete()throws Exception{
		roleService.delete(model.getId());
		return "toList";
	}
	
	/**
	 * 添加页面
	 */
	public String addUI()throws Exception{
		return "saveUI";
	}
	
	/**
	 * 添加
	 * @return
	 * @throws Exception
	 */
	public String add()throws Exception{
		//封装到对象
		roleService.save(model);
		return "toList";
	}
	/**
	 * 修改页面
	 * @return
	 * @throws Exception
	 */
	public String editUI()throws Exception{
		// 准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	}
	
	/**
	 * 修改
	 * @return
	 * @throws Exception
	 */
	public String edit()throws Exception{
		// 1，从数据库中获取原对象
		Role role = roleService.getById(model.getId());

		role.setName(model.getName());
		role.setDescription(model.getDescription());

		// 3，更新到数据库
		roleService.update(role);

		return "toList";
	}
	
	//=========================设置权限页面===========================
	/**
	 * 设置权限页面
	 * @return
	 * @throws Exception
	 */
	public String setPrivilegeUI()throws Exception{
		// 准备回显的数据
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		if(role.getPrivileges()!=null){
			privilegeIds=new Long[role.getPrivileges().size()];
			int index=0;
			for(Privilege priv:role.getPrivileges()){
				privilegeIds[index++]=priv.getId();
			}
		}
		//准备数据privilegeList
		List<Privilege> privilegeList=privilegeService.findAll();
		ActionContext.getContext().put("privilegeList", privilegeList);
		
		return "setPrivilegeUI";
	}
	
	/**
	 * 修改提交
	 * @return
	 * @throws Exception
	 */
	public String setPrivilege()throws Exception{
		// 1，从数据库中获取原对象
		Role role = roleService.getById(model.getId());
		
		// 2.设置要修改的属性值
		List<Privilege> privilegeList=privilegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));
		
		// 3，更新到数据库
		roleService.update(role);

		return "toList";
	}
	//========================================================
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	

}
