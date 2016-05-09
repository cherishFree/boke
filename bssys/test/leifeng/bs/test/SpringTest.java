package leifeng.bs.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.jbpm.api.ProcessEngine;

public class SpringTest {
	
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	public void testBean() throws Exception{
		TestAction testAction=(TestAction)ac.getBean("testAction");
		
		System.out.println(testAction);
	}
	
	//测试SessionFactory
	@Test
	public void testSessionFactory()throws Exception{
		
		SessionFactory sessionFactory=(SessionFactory)ac.getBean("sessionFactory");
		
		System.out.println(sessionFactory);
	}
	
	//测试事务 
	
	public void testTransaction()throws Exception{
		
		TestService testService=(TestService)ac.getBean("testService");
		
		testService.saveTwoUser();
		
	}
	
	
	public void testProcessEngine()throws Exception{
		ProcessEngine processEngine=(ProcessEngine)ac.getBean("processEngine");
		
		System.out.println("-------------> "+processEngine);
	}
	

}
