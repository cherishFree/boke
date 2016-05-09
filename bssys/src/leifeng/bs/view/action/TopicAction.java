package leifeng.bs.view.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.base.ModelDrivenBaseAction;
import leifeng.bs.domain.Forum;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Reply;
import leifeng.bs.domain.Topic;
import leifeng.bs.domain.User;
import leifeng.bs.util.QueryHelper;

@Controller
@Scope("prototype")
public class TopicAction extends ModelDrivenBaseAction<Topic>{
	
	private Long forumId;
	
	
	/** 显示单个主题 (主贴+回帖列表 ) */
	public String show() throws Exception{
		//准备数据：topic
		Topic topic=topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);
		
		//准备算数据：replyList
		/*List<Reply> replyList=replyService.findByTopic(topic);
		ActionContext.getContext().put("replyList", replyList);*/
		
		//准备分页信息
		//PageBean pageBean=replyService.getPageBeanByTopic(pageNum,pageSize,topic);
		//ActionContext.getContext().getValueStack().push(pageBean);//将分页信息放在栈顶
		
		//准备分页信息 v3
		/*String hql="FROM Reply r WHERE r.topic=? ORDER BY r.postTime ASC";
		List<Object> parameters=new ArrayList<Object>();
		parameters.add(topic);*/
		
		//准备分页信息 v4
		new QueryHelper(Reply.class,"r")//
				.addCondition("r.topic=?", topic)
				.addOrderProperty("r.postTime", true)
				.preparePageBean(replyService, pageNum, pageSize);
		
		return "show";
	}
	/** 发表新主题页面  */
	public String addUI() throws Exception{
		//准备数据，板块的名称，
		Forum forum=forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}
	
	
	
	/** 发表新主题  */
	public String add() throws Exception{
		//封装
		//>>>>>>>>表单中的参数，已经封装了
		//model.setTitle(title);
		//model.setContent(content);
		model.setForum(forumService.getById(forumId));
		
		//>>>>当前直接获取的信息
		model.setAuthor(getCurrentUser());//当前登录的用户
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());//当前请求中的ip
		model.setPostTime(new Date());//当前时间
		
		//>>应该放到业务方法中
	/*	model.setType(type);
		model.setLastReply(lastReply);
		model.setReplyCount(replyCount);
		model.setLastUpdateTime(lastUpdateTime);*/
		
		//保存
		topicService.save(model);
		
		return "toShow";//转到新主题页面
	}
	
	
//========================封装参数===================
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	
	
	

}
