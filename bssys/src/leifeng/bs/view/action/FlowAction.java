package leifeng.bs.view.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import leifeng.bs.base.BaseAction;
import leifeng.bs.domain.Application;
import leifeng.bs.domain.ApplicationTemplate;
import leifeng.bs.domain.ApproveInfo;
import leifeng.bs.domain.TaskView;
import leifeng.bs.util.QueryHelper;

import com.opensymphony.xwork2.ActionContext;


@Controller
@Scope("prototype")
public class FlowAction extends BaseAction {
	
	private File upload; // 上传的文件
	private InputStream inputStream;//下载
	
	private Long applicationTemplateId;
	
	private String taskId;
	private Long applicationId;
	private String comment;
	private boolean approval;

	private String outcome;
	
	private String applicationStatus;
	// ================================== 申请人有关


	/** 起草申请（模板列表） */
	public String applicationTemplateList() throws Exception {
		List<ApplicationTemplate> applicationTemplateList = applicationTemplateService.findAll();
		ActionContext.getContext().put("applicationTemplateList", applicationTemplateList);
		return "applicationTemplateList";
	}

	/** 提交申请页面 */
	public String submitUI() throws Exception {
		//ActionContext.getContext().getValueStack().push(applicationTamplateId);
		return "submitUI";
	}

	/** 提交申请 */
	public String submit() throws Exception {
		// 封装申请信息
		Application application = new Application();

		application.setApplicant(getCurrentUser()); // 申请人，当前用户
		application.setPath(saveUploadFile(upload)); // 保存上传的文件并设置路径
		application.setApplicationTemplate(applicationTemplateService.getById(applicationTemplateId));

		// 调用业务方法（保存申请信息，并启动流程开始流转）
		applicationService.submit(application);

		return "toMyApplicationList"; // 成功后转到"我的申请查询"
	}

	/** 我的申请查询 */
	public String myApplicationList() throws Exception {
		
		//准备分页数据
		new QueryHelper(Application.class, "a")//
			.addCondition("a.applicant=?", getCurrentUser())//
			.addCondition(applicationTemplateId !=null,"a.applicationTemplate.id=?", applicationTemplateId)//
			.addCondition(StringUtils.isNotBlank(applicationStatus),"a.status=?", applicationStatus)//
			.addOrderProperty("a.applyTime", false)//
			.preparePageBean(applicationService, pageNum, pageSize);
		
		//准备数据
		List<ApplicationTemplate> applicationTemplateList = applicationTemplateService.findAll();
		ActionContext.getContext().put("applicationTemplateList", applicationTemplateList);
		return "myApplicationList";
	}

	// ================================== 审批人有关

	/** 待我审批（我的任务列表） */
	public String myTaskList() throws Exception {
		List<TaskView> taskViewList = applicationService.getMyTaskViewList(getCurrentUser());
		ActionContext.getContext().put("taskViewList", taskViewList);
		return "myTaskList";
	}

	/** 审批处理页面 */
	public String approveUI() throws Exception {
		Set<String> outcomes=applicationService.getOutcomesByTaskId(taskId);
		ActionContext.getContext().put("outcomes", outcomes);
		return "approveUI";
	}

	/** 审批处理 */
	public String approve() throws Exception {
		//封装
		ApproveInfo approveInfo=new ApproveInfo();
		
		approveInfo.setComment(comment);
		approveInfo.setApproval(approval);
		approveInfo.setApplication(applicationService.getById(applicationId));
		
		approveInfo.setApprover(getCurrentUser());//审批人当前登录用户
		approveInfo.setApproveTime(new Date());//审批时间，当前时间
		
		//调用业务方法（保存本次审批信息，完成办理完成任务，并维护申请的状态）
		applicationService.approve(approveInfo,taskId,outcome);
		
		return "toMyTaskList"; // 成功后转到待我审批页面
	}

	/** 查看流转记录 */
	public String approveHistory() throws Exception {
		Application application=applicationService.getById(applicationId);
		ActionContext.getContext().put("approveInfos", application.getApproveInfos());
		return "approveHistory";
	}
	
	/** 查看申请信息 */
	public String showApplication() throws Exception{
		
		ActionContext.getContext().getValueStack().push(applicationId);
		return "showApplication";
	}
    
	/** 下载 */
	public String download() throws Exception{
		
		Application application=applicationService.getById(applicationId);
        inputStream=new FileInputStream(application.getPath());
		
		//准备文件名
		//解决文件名中外乱码问题
		String fileName=URLEncoder.encode(application.getTitle(),"utf-8");
		ActionContext.getContext().put("fileName", fileName);
		return "download";
	}
//==========================请求参数封装==================================

	public Long getApplicationTemplateId() {
		return applicationTemplateId;
	}

	public void setApplicationTemplateId(Long applicationTemplateId) {
		this.applicationTemplateId = applicationTemplateId;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
	
}
