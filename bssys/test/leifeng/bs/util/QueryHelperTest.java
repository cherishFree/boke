package leifeng.bs.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.opensymphony.xwork2.ActionContext;

import leifeng.bs.domain.Forum;
import leifeng.bs.domain.PageBean;
import leifeng.bs.domain.Topic;

public class QueryHelperTest {

	/**
	 * 0表示查看全部主题
	 * 1表示只看精华帖
	 */
	private int viewType=1;
	
	/**
	 * 默认排序，所有的置顶帖 在前面，并按最后更新时间降序排列
	 * 只按最后更新的时间排序
	 * 只按主题发表的时间排序
	 * 只按主题回复的时间排序
	 */
	private int orderBy=1;
	
	/**
	 * ture 表示升序
	 * false 表示降序
	 */
	private boolean asc=false;
	
	Forum forum=new Forum();
	
	@Test
	public void testQueryHelper() {
		
		QueryHelper queryHelper=new QueryHelper(Topic.class, "t")
		.addCondition("t.forum=?", forum)
		.addCondition((viewType==1),"t.type=?", Topic.TYPE_BEST)
		.addOrderProperty((orderBy == 1),"t.lastUpdateTime", asc)
		.addOrderProperty((orderBy == 2),"t.postTime", asc)
		.addOrderProperty((orderBy == 3),"t.replyCount", asc)
		.addOrderProperty((orderBy == 0),"(CASE t.type WHEN 2 THEN 2 ELSE 0 END)",false)
		.addOrderProperty((orderBy == 0),"t.lastUpdateTime", false);
	
		System.out.println(queryHelper.getListQueryHql());
		System.out.println(queryHelper.getCountQueryHql());
		System.out.println(queryHelper.getParameters());
	}

}
