package leifeng.bs.view.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.base.ModelDrivenBaseAction;
import leifeng.bs.domain.Forum;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Topic;
import leifeng.bs.util.QueryHelper;

@Controller
@Scope("prototype")
public class ForumAction extends ModelDrivenBaseAction<Forum> {
	/**
	 * 0表示查看全部主题
	 * 1表示只看精华帖
	 */
	private int viewType=0;
	
	/**
	 * 默认排序，所有的置顶帖 在前面，并按最后更新时间降序排列
	 * 只按最后更新的时间排序
	 * 只按主题发表的时间排序
	 * 只按主题回复的时间排序
	 */
	private int orderBy=0;
	
	/**
	 * ture 表示升序
	 * false 表示降序
	 */
	private boolean asc=false;
	
	
	
	/** 显示板块列表 */
	public String list() throws Exception{
		List<Forum> forumList=forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		return "list";
	}
	
	/** 显示当个板块的内容(显示主题列表） */
	public String show() throws Exception{
		//准备数据
		Forum forum=forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		
		//准备数据
		/*List<Topic> topicList=topicService.findByForum(forum);
		ActionContext.getContext().put("topicList", topicList);*/
		
		//准备分页信息 v1
		/*PageBean pageBean=topicService.getPageBeanByForm(pageNum,pageSize,forum);
		ActionContext.getContext().getValueStack().push(pageBean);*/
		
	/*	//准备分页信息 v2
		String hql="FROM Topic t WHERE t.forum=? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
		List<Object> parameters=new ArrayList<Object>();
		parameters.add(forum);
		
		PageBean pageBean=replyService.getPageBean(pageNum, pageSize, hql, parameters);
		ActionContext.getContext().getValueStack().push(pageBean);*/
		
	/*	//准备分页信息 v3
		String hql="FROM Topic t WHERE t.forum=? ";
		List<Object> parameters=new ArrayList<Object>();
		parameters.add(forum);
		
		if(viewType==1){
			hql+="AND t.type=?";
			parameters.add(Topic.TYPE_BEST);
		}
		if (orderBy == 1) { // 1 表示只按最后更新时间排序
			 hql += " ORDER BY t.lastUpdateTime " + (asc ? "ASC" : "DESC");
	    } else if (orderBy == 2) { // 2 表示只按主题发表时间排序
			 hql += " ORDER BY t.postTime " + (asc ? "ASC" : "DESC");
		} else if (orderBy == 3) { // 3 表示只按回复数量排序
			hql += " ORDER BY t.replyCount " + (asc ? "ASC" : "DESC");
		} else { // 0 表示默认排序(所有置顶帖在前面，并按最后更新时间降序排列)
			 hql += " ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 0 END) DESC, t.lastUpdateTime DESC";
	    }*/
		
		//准备分页信息 v4
		new QueryHelper(Topic.class, "t")
		.addCondition("t.forum=?", forum)
		.addCondition((viewType==1),"t.type=?", Topic.TYPE_BEST)
		.addOrderProperty((orderBy == 1),"t.lastUpdateTime", asc)
		.addOrderProperty((orderBy == 2),"t.postTime", asc)
		.addOrderProperty((orderBy == 3),"t.replyCount", asc)
		.addOrderProperty((orderBy == 0),"(CASE t.type WHEN 2 THEN 2 ELSE 0 END)",false)
		.addOrderProperty((orderBy == 0),"t.lastUpdateTime", false)
		.preparePageBean(topicService, pageNum, pageSize);
	
		return "show";
	}
	
//=========================================================
	public int getViewType() {
		return viewType;
	}
	
	public void setViewType(int viewType) {
		this.viewType = viewType;
	}
	
	public int getOrderBy() {
		return orderBy;
	}
	
	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}
	
	public boolean isAsc() {
		return asc;
	}
	
	public void setAsc(boolean asc) {
		this.asc = asc;
	}
	

}
