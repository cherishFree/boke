<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
	<HEAD>
		<title>${reqeust.info }</title>
		<link rel="stylesheet" href="image/style.css">
	</HEAD>
	<body leftMargin="0" topMargin="0"  bgcolor="#f3f3f3">
		<form id="Form1" method="post">
			<table width="1000" cellpadding="0" cellspacing="0" border="0">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="300"><img src="image/error.gif"></td>
					<td width="20">&nbsp;</td>
					<td vAlign="top"><br>
						<table style="background-color:#FFFFFF;BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; BORDER-LEFT: #cccccc 1px solid; BORDER-BOTTOM: #cccccc 1px solid; BORDER-COLLAPSE: collapse"
							cellSpacing="0" cellPadding="0" width="500" border="1">
							<tr height="30">
								<td align="center" background="image/main/l-bg7.jpg" colSpan="2"><font color="#ffff66"><b>${request.info }</b></font></td>
							</tr>
							<tr height="100">
								<td align="center">
									<table width="500" border="0">
										<tr align="center" height="100">
											<td>${request.info }</td>
											<% 
												String url = (String)request.getAttribute("url");
												response.setHeader("Refresh","3;url=" + url);
											%>
										</tr>
										<tr height="50" align="center">
											<td></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>