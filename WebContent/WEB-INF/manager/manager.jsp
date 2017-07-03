
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>飞粤电器有限公司</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/img/favicon.ico" rel="shortcut icon" type="/image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
</head>

<frameset rows="52,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/admin/top.jsp" name="title" scrolling="no" noresize="noresize">
  <frameset cols="180,*" frameborder="no" border="0" framespacing="0">
    <frame src="${pageContext.request.contextPath}/admin/left.jsp" name="tree" scrolling="no" marginheight="0" marginwidth="0">
    <frame src="${pageContext.request.contextPath}/notice?_method=showNotice" name="main">
    
  </frameset>
</frameset>
</html>