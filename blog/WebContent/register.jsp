<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>����ע��</title>
<link rel="stylesheet" href="image/style.css">
</head>

<body topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<form id="Form1" action="register.action" method="post">
			<table width="1000" cellpadding="0" cellspacing="0" border="0">
				<tr height="100">
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td align="right" width="300" valign="top"><img src="image/register.gif"></td>
					<td width="20">&nbsp;</td>
					<td valign="top">
						<table width="600" border="1" cellpadding="0" cellspacing="0" style="background-color:#FFFFFF;BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse">
							<tr height="30">
								<td colspan="3" align="center" background="image/main/l-bg1.jpg"><font color="#ffff66"><b>�²���ע��</b></font></td>
							</tr>
							<tr height="30">
								<td align="right" width="160">�ʺ�&nbsp;</td>
								<td><input type="text" name="username"/>*</td>
								<td><s:fielderror><s:param>username</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td align="right">����&nbsp;</td>
								<td><input type="password" name="password"/>*</td>
								<td><s:fielderror><s:param>password</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td align="right">ȷ������&nbsp;</td>
								<td><input type="password" name="repassword"/>*</td>
								<td><s:fielderror><s:param>repassword</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td align="right">�ǳ�&nbsp;</td>
								<td><input type="text" name="nickname"/>*</td>
								<td><s:fielderror><s:param>nickname</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td align="right">���뱣������&nbsp;</td>
								<td>
									<select name="question">
										<option value="�������">�������</option>
										<option value="��ļ���">��ļ���</option>
										<option value="����ϲ����ʳ��">����ϲ����ʳ��</option>
									</select>*
								</td>
								<td><s:fielderror><s:param>question</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td align="right">���뱣���Ĵ�&nbsp;</td>
								<td><input type="text" name="answer"/>*</td>
								<td><s:fielderror><s:param>answer</s:param></s:fielderror></td>
							</tr>
							<tr height="30">
								<td colspan="3" align="center"><input type="submit" value="�ύ"/>
								<input type="reset" value="����"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

