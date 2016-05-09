package leifeng.bs.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.service.ProcessDefinitionService;

@Service
@Transactional
public class ProcessDefinitionServiceImpl  implements ProcessDefinitionService{
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private ProcessEngine processEngine;
	
	/** 查询所有最新版本的流程定义列表 */
	@Override
	public List<ProcessDefinition> findAllLatesVersion() {
		//1.查询所有的的流程定义列表，把最新的版本都排到最后面
		List<ProcessDefinition> list=processEngine.getRepositoryService()//
		.createProcessDefinitionQuery()//
		.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)//
		.list();
		
		//2.过滤出最新的版本
		Map<String,ProcessDefinition> map=new HashMap<String,ProcessDefinition>();
		for (ProcessDefinition pd : list) {
			map.put(pd.getKey(), pd);
		}
		
		return new ArrayList<ProcessDefinition>(map.values());
	}

	/**  删除指定key的所有版本的流程定义 */
	@Override
	public void deleteByKey(String key) {
		//1.查询出指定key的所有版本的流程定义
		List<ProcessDefinition> list=processEngine.getRepositoryService()//
				.createProcessDefinitionQuery()//
				.processDefinitionKey(key)//
				.list();
		
		//2.循环删除
		for (ProcessDefinition pd : list) {
			processEngine.getRepositoryService().deleteDeploymentCascade(pd.getDeploymentId());
		}
		
	}

	/** 部署流程定义（zip） */
	@Override
	public void deploy(ZipInputStream zipInputStream) {
		processEngine.getRepositoryService()//
		.createDeployment()//
		.addResourcesFromZipInputStream(zipInputStream)//
		.deploy();
		
	}

	/** 获取指定流程定义的流程图片 */
	@Override
	public InputStream getProcessImageResourceAsStream(String processDeifinitionId) {
		//根据id取出对应的流程定义对象
		ProcessDefinition pd=processEngine.getRepositoryService()//
				.createProcessDefinitionQuery()//
				.processDefinitionId(processDeifinitionId)//
				.uniqueResult();
		
		//返回图片资源
		return processEngine.getRepositoryService().getResourceAsStream(pd.getDeploymentId(), pd.getImageResourceName());
	}
	
	
	
	
	
}
