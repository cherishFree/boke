<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色列表</title>
</head>
<body>
   <s:iterator value="#roleList">
      <s:property value="id"/>
      <s:property value="name"/>
      <s:property value="description"/>
      <s:a action="role_delete?id=%{id}">删除</s:a>
   </s:iterator>
</body>
</html>