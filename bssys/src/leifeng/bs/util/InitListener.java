package leifeng.bs.util;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import leifeng.bs.domain.Privilege;
import leifeng.bs.service.PrivilegeService;

public class InitListener implements ServletContextListener {

	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//获取容器与相关的Service对象
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		
		PrivilegeService privilegeService=(PrivilegeService)ac.getBean("privilegeServiceImpl");
		
		List<Privilege> topPrivilegeList=privilegeService.findTopList();
		sce.getServletContext().setAttribute("topPrivilegeList", topPrivilegeList);
		System.out.println("------------>已准备数据<---------------");
		
		//准备数据
		Collection<String> allPrivilegeUrls=privilegeService.getAllPrivilegeUrls();
		sce.getServletContext().setAttribute("allPrivilegeUrls", allPrivilegeUrls);
		System.out.println("------------>已准备好了所有的Url数据<---------------");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}


}
