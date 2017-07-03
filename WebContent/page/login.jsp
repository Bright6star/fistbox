<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>

	<!--- CSS --->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

	<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->
	<!--[if (gte IE 6)&(lte IE 8)]>
		<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
		<script type="text/javascript" src="selectivizr.js"></script>
		<noscript><link rel="stylesheet" href="fallback.css" /></noscript>
	<![endif]-->
	
	</head>

	<body>
		<div id="container">
			<form action="${pageContext.request.contextPath}/login" method="POST">
				<div class="login">登录</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="userName" value="admin" />
				</div>
				<div class="password-field">
					<input type="password" name="userPass" value="admin" />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">Remember me</label>
				<div class="forgot-usr-pwd">Forgot <a href="#">username</a> or <a href="#">password</a>?</div>
				<input type="submit" name="submit" value="确定" />
			</form>
		</div>
		<div id="footer">
			<a href="${pageContext.request.contextPath}/page/index.jsp" title="飞粤电器有限公司">飞粤电器有限公司</a>
			欢迎您的登录
		</div>
	</body>
</html>
