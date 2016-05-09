package leifeng.bs.view.action;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import leifeng.bs.base.ModelDrivenBaseAction;
import leifeng.bs.domain.Department;
import leifeng.bs.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction extends ModelDrivenBaseAction<Department> {	
	
	private Long parentId;
	

	/** 列表页面 */
	public String list() throws Exception {
		List<Department> departmentList=null;
		if(parentId==null){
			departmentList=departmentService.findToList();
		}else{
			departmentList=departmentService.findChildren(parentId);
			Department parent=departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}
		
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}
	/** 删除功能页面 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());
		return "toList";
	}
	/** 添加页面 */
	public String addUI() throws Exception {
		//准备数据，准备所有的部门数据
		//List<Department> departmentList=departmentService.findAll();
		List<Department> topList=departmentService.findToList();
		List<Department> departmentList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		return "saveUI";
	}
	/** 列表页面 */
	public String add() throws Exception {
		//查找到上级部门，将上级部门封装到数据模型中
		Department parent=departmentService.getById(parentId);
		model.setParent(parent);
		
		departmentService.save(model);
		return "toList";
	}
	/** 列表页面 */
	public String editUI() throws Exception {
		//准备数据，准备所有的部门数据
		//List<Department> departmentList=departmentService.findAll();
		List<Department> topList=departmentService.findToList();
		List<Department> departmentList=DepartmentUtils.getAllDepartments(topList);
		ActionContext.getContext().put("departmentList", departmentList);
		
		//1.准备数据回显
		Department department=departmentService.getById(model.getId());
		//2.将回显的数据放到栈顶
		ActionContext.getContext().getValueStack().push(department);
		
		if(department.getParent()!=null){
			parentId=department.getParent().getId();
		}
		
		return "saveUI";
	}
	/** 列表页面 */
	public String edit() throws Exception {
		//1.从数据库中获取原对象
		Department department=departmentService.getById(model.getId());
		//2.设置修改的属性
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		//设置所属的上级部门
		department.setParent(departmentService.getById(parentId));
		
		//3.更新到数据库
		departmentService.update(department);
		return "toList";
	}

	
	//-========封装父类部门的id
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	

}
