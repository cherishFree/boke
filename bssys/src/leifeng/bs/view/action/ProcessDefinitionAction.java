package leifeng.bs.view.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.base.BaseAction;


@Controller
@Scope("prototype")
public class ProcessDefinitionAction extends BaseAction{
	
	private String id;
	private String key;
	
	private File upload; // 上传的文件
	private InputStream inputStream; // 下载用的
	
	/** 列表页面 */
	public String list()throws Exception{
		
		List<ProcessDefinition> processDefinitionList=processDefinitionService.findAllLatesVersion();
		ActionContext.getContext().put("processDefinitionList", processDefinitionList);
		
		return "list";
	}
	
	/** 删除 */
    public String delete()throws Exception{
    	key = URLDecoder.decode(key, "utf-8"); // 自己再进行一次URL解码
    	processDefinitionService.deleteByKey(key);
		return "toList";
	}
    
    /** 部署页面 */
    public String addUI()throws Exception{
		return "addUI";
	}
    
    /** 部署 */
    public String add()throws Exception{
    	ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(upload));
		try {
			processDefinitionService.deploy(zipInputStream);
		} finally {
			zipInputStream.close();
		}
    	
		return "toList";
	}
    
    /** 查看流程图 */
    public String downloadProcessImage()throws Exception{
		//inputStream=new FileInputStream("c:/a.png");
    	// 自己再进行一次url解码
    	id = URLDecoder.decode(id, "utf-8"); // 自己再进行一次URL解码
    	
    	inputStream = processDefinitionService.getProcessImageResourceAsStream(id);
		return "downloadProcessImage";
	}

//========================输入类型=======================================
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
    

}
