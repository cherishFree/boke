<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<HTML>
	<HEAD>
		<title>添加文章</title>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<link rel="stylesheet" href="image/style.css">
	</HEAD>
	<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<form action="addArticle.action" method="post">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
						
						<br>
		
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
							<tr height="30">
								<td background="image/l-bg3.jpg">&nbsp;&nbsp;&nbsp;<font color="#ffff66"><b>添加文章</b></font></td>
							</tr>
							<tr height="20">
								<td>
									&nbsp;&nbsp;&nbsp;标题：
									<div>
										&nbsp;&nbsp;&nbsp;<input type="text" name="title"  Width="600px" Style="inputcss" />
									</div>
								</td>
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;&nbsp;内容：
									<FCK:editor instanceName="content" basePath="/user/fckeditor" toolbarSet="myToolbar" height="200"></FCK:editor>
								</td>
							</tr>
							<tr height="20">
								<td>
									<input type="submit"  value="添加" Style="ButtonCss" />
									<input type="button" name="cancelButton" value="取消" onClick="history.back()" Class="ButtonCss">
								</td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</HTML>

