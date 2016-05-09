package leifeng.bs.base;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import leifeng.bs.domain.User;
import leifeng.bs.service.ApplicationService;
import leifeng.bs.service.ApplicationTemplateService;
import leifeng.bs.service.DepartmentService;
import leifeng.bs.service.ForumService;
import leifeng.bs.service.PrivilegeService;
import leifeng.bs.service.ProcessDefinitionService;
import leifeng.bs.service.ReplyService;
import leifeng.bs.service.RoleService;
import leifeng.bs.service.TopicService;
import leifeng.bs.service.UserService;

public class BaseAction extends ActionSupport{
	
	//=================获取当前用户===========================
	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}

	//==========分页信息============
	protected int pageNum=1;//当前页
	protected int pageSize=10;//每页显示的条数
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	//================保存文件============================
	/**
	 * 保存上传的文件，并保存文件在服务器端的真实存储路径
	 * @param upload
	 * @return
	 */
	protected String saveUploadFile(File upload) {
		//封装
		SimpleDateFormat sdf=new SimpleDateFormat("/yyyy/MM/dd/");
		String basePath=ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload_files");
		String subPath=sdf.format(new Date());
		
		//如果文件夹不存在，就创建
		File dir=new File(basePath+subPath);
		if(!dir.exists()){
			dir.mkdirs();//递归的调用不存在的文件夹
		}
		//拼接路径
		String path=basePath+subPath+UUID.randomUUID().toString();
		//移动文件
		upload.renameTo(new File(path));//如果目标文件夹不存在，或是目标文件已经存在，就不会成功，返回false,但不报错
		return path;
	}
	
	//=================Service实例的声明=============
	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected UserService userService;
	@Resource
	protected PrivilegeService privilegeService;
	@Resource
	protected ForumService forumService;
	@Resource
	protected TopicService topicService;
	@Resource
	protected ReplyService replyService;
	@Resource
	protected ProcessDefinitionService processDefinitionService;
	@Resource
	protected ApplicationTemplateService applicationTemplateService;
	@Resource
	protected ApplicationService applicationService;

}
