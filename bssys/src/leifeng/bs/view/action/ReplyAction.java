package leifeng.bs.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.base.ModelDrivenBaseAction;
import leifeng.bs.domain.Reply;
import leifeng.bs.domain.Topic;

@Controller
@Scope("prototype")
public class ReplyAction extends ModelDrivenBaseAction<Reply> {
	
	private Long topicId;
	/** 发表新回复页面  */
	public String addUI() throws Exception{
		//准备数据
		Topic topic=topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		
		return "addUI";
	}
	/** 发表新回复  */
	public String add() throws Exception{
		//封装
		//表单字段，已经封装了
		//model.setContent(content);
		//model.setTitle(title);
		model.setTopic(topicService.getById(topicId));
		//当前信息
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date());
		
		//保存
		replyService.save(model);
		
		return "toTopicShow";//转到新回复所在主题的显示页面
	}

//=======封装回复主帖的Id参数------------------
	public Long getTopicId() {
		return topicId;
	}
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
