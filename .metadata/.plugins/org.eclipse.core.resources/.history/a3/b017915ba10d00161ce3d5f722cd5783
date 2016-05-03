<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>我的全部文章</title>
		<link rel="stylesheet" href="image/style.css" />
	</head>

	<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<table width="1000" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" valign="bottom">
				<td class="title">
					&nbsp;&nbsp;我的全部文章
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
					<table cellpadding="4" cellspacing="1">
						<tr>
							<td>
								<table width="1000" cellpadding="6" cellspacing="1"
									bgcolor="#CCCCCC">

									<!-- 循环输出 -->
									<s:iterator value="#request.all" id="art">
										<tr>
											<td bgcolor="#FFFFFF">
												<font class="chinesefont105main"> <!-- 文章标题  --> 
												<a href="showArticle.action?id=<s:property value='#art.id'/>"><s:property value="#art.title"/></a>
													<hr size='1' noshade color='#CCCCCC'> <br>
													<div align='right' class='smalltxt' height='32px'>
														<!-- 发表时间 -->
														发表于:
														<s:date name="#art.date"/>
														<!-- 评论与点击数 -->
														|评论(<s:property value="#request.critiqueCounts[#art.id - 1]"/>)|点击(<s:property value="#art.hasread"/>)
													</div> </font>
											</td>
										</tr>
									</s:iterator>
										<tr>
											<td align="center">
												<s:if test="#request.page.hasPrePage">
													<a href="showUserAllArticle.action?currentPage=1">首页</a>
													<a href="showUserAllArticle.action?currentPage=${page.currentPage -1 }">上一页</a>
												</s:if>
												<s:else>
													首页
													上一页
												</s:else>
												
												<s:if test="#request.page.hasNextPage">
													<a href="showUserAllArticle.action?currentPage=${page.currentPage + 1 }">下一页</a>
													<a href="showUserAllArticle.action?currentPage=${page.totalPage }">尾页</a>			
												</s:if>
												<s:else>
													下一页
													尾页
												</s:else>
											</td>
										</tr>
								</table>
								<table id="noCount" runat="server" width="1000" cellpadding="6"
									cellspacing="1" bgcolor="#cccccc">
									<tr bgcolor="#ffffff" height="50">
										<td align="center">
											${sessionScope.username}的博客
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>