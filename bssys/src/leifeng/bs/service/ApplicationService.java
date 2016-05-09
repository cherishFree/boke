package leifeng.bs.service;

import java.util.List;
import java.util.Set;

import leifeng.bs.base.DaoSupport;
import leifeng.bs.domain.Application;
import leifeng.bs.domain.ApproveInfo;
import leifeng.bs.domain.TaskView;
import leifeng.bs.domain.User;


public interface ApplicationService extends DaoSupport<Application> {

	/**
	 * 提交申请：
	 * 
	 * 1，保存申请信息
	 * 
	 * 2，启动流程开始流转
	 * 
	 * @param application
	 */
	void submit(Application application);

	/**
	 * 查询我的任务信息列表
	 * 
	 * @param currentUser
	 * @return
	 */
	List<TaskView> getMyTaskViewList(User currentUser);

	/**
	 * 执行审批处理
	 * 1.保存审批信息
	 * 2.办理完任务
	 * 3.维护申请的状态
	 * @param approveInfo
	 * @param taskId 
	 * @param outcome  使用指定的路线离开本活动，如果为null,表示使用唯一的那个路线，
	 */
	void approve(ApproveInfo approveInfo, String taskId, String outcome);

	/**
	 * 获取指定任务活动中所有流出的连线名称
	 * @param taskId
	 * @return
	 */
	Set<String> getOutcomesByTaskId(String taskId);

}
