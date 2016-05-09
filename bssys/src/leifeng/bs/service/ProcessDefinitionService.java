package leifeng.bs.service;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.jbpm.api.ProcessDefinition;

public interface ProcessDefinitionService {

	/**
	 * 查询所有最新版本的流程定义列表
	 * @return
	 */
	List<ProcessDefinition> findAllLatesVersion();

	/**
	 * 删除指定key的所有版本的流程定义
	 * @param key
	 */
	void deleteByKey(String key);

	/**
	 * 部署流程定义（zip）
	 * @param zipInputStream
	 */
	void deploy(ZipInputStream zipInputStream);

	/**
	 * 获取指定流程定义的流程图片
	 * @param processDeifinitionId
	 * @return
	 */
	InputStream getProcessImageResourceAsStream(String processDeifinitionId);

}
