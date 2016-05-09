package leifeng.bs.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import leifeng.bs.domain.User;
import leifeng.bs.service.DepartmentService;
import leifeng.bs.service.ForumService;
import leifeng.bs.service.PrivilegeService;
import leifeng.bs.service.ReplyService;
import leifeng.bs.service.RoleService;
import leifeng.bs.service.TopicService;
import leifeng.bs.service.UserService;

public abstract class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T> {

	//==============ModelDriven的支持==================
	protected T model;
	
	public ModelDrivenBaseAction() {
		//通过反射获取model的真实类型
		try {
			ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();
			Class<T> clazz=(Class<T>)pt.getActualTypeArguments()[0];
			//通过反射创建model的实例
			model=clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取当前登录的用户
	 * @return
	 */
	protected User getCurrentUser() {
		return (User)ActionContext.getContext().getSession().get("user");
	}
	
	public T getModel(){
		return model;
	}
	
}
