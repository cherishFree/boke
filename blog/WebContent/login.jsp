<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户登陆</title>
<link rel="stylesheet" href="image/style.css">
<style type="text/css">
<!--
.STYLE1 {
	color: #0066FF;
	font-weight: bold;
}
-->
</style>
</head>

<body onLoad="document.forms[0]['username'].focus()" topmargin="0" leftmargin="0" bgcolor="#f3f3f3">
<jsp:include page="include/MainHeader.jsp"></jsp:include>
<form id="Form1" action="login.action" method="post">
  <table width="1000" cellpadding="0" cellspacing="0" border="0">
    <tr height="100">
      <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
      <td width="200">&nbsp;</td>
      <td width="420" align="center" valign="bottom"><table width="360" border="1" cellpadding="0" cellspacing="0" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#ffffff">
          <tr height="30">
            <td colspan="2" align="center" background="image/main/l-bg1.jpg"><span class="STYLE1">博客登录</span></td>
          </tr>
          <tr height="30">
            <td width="60" rowspan="5">&nbsp;</td>
            <td width="300">用户名</td>
          </tr>
          <tr height="30">
            <td><input type="text" name="username" Width="120" />
            </td>
          </tr>
          <tr height="30">
            <td>密码</td>
          </tr>
          <tr height="30">
            <td><input type="password"  name="password"  Width="120" />
            </td>
          </tr>
          <tr height="40">
            <td><input type="submit" id="loginButton" value="登录" style="buttoncss"></td>
          </tr>
        </table>
      </td>
      <td><img src="image/login.gif"></td>
    </tr>
  </table>
</form>
</body>
</html>
