package leifeng.bs.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import leifeng.bs.domain.User;

@SuppressWarnings("unused")
public class CheckPrivilegeInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*System.out.println("----------->之前");
		
		return result;
	    String result=invocation.invoke();//放行
		System.out.println("----------->之后");*/
		//获取信息
		User user=(User)ActionContext.getContext().getSession().get("user");//登录的用户 
		String namespace=invocation.getProxy().getNamespace();
		String actionName=invocation.getProxy().getActionName();
		String privUrl=namespace+actionName;//对应的权限url
		//如果未登录，就转到登录页面       
		if(user==null){
			if(privUrl.startsWith("/user_login")){
				//如果是去登录，就放行
				return invocation.invoke();
			}else{
				//如果不是去登录，就转到登录页面
				return "loginUI";
			}
			
		}else{//如果已登录，就判断权限
			if(user.hasPrivilegeByUrl(privUrl)){
				//如果有权限，就放行
				return invocation.invoke();
			}else{
				//如果没有权限，就转到提示页面
				return "noPrivilegeError";
			}
		}
		
	}

}
