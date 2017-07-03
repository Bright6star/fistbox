<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>飞粤电器有限公司</title>
<link href="favicon.ico" rel="shortcut icon" type="../image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
<script>	
</script>
<style>
#header {
	height: 37px;
	background: #f4f1e8;
	border-bottom: #bdbdbd 1px solid;
}

#header h3 {
	height: 37px;
	line-height: 37px;
	color: #c32c33;
	padding-left: 30px;
	position: absolute;
}
#header a{
	position: relative;
	top:12px;
	float: right;
	right:12px
}
</style>
</head>

<body>

	<div id="header">
		<h3>欢迎你：${sessionScope.user.name}</h3>
		<a href="${pageContext.request.contextPath}/index" target="_top">前往首页</a>
	</div>
	
</body>
</html>
