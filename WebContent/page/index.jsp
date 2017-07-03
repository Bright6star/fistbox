<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/roll.js" ></script>
	</head>
	<body>
		<!--------------------------------------头部------------------------------------------------>
		<div class="header">
		 	<a href="${pageContext.request.contextPath}/page/index.jsp">
		 		<img src="${pageContext.request.contextPath}/img/logo.jpg" alt="" class="logo"/>
		 	</a>
		 	
		 	<p>欢迎
		 	<c:choose>
			 	<c:when test="${empty sessionScope.user.name}"> 	
			 		<a href="${pageContext.request.contextPath}/page/login.jsp">登录</a>
			 	</c:when>
			 	<c:otherwise>
			 		<a href="${pageContext.request.contextPath}/page/login.jsp">${sessionScope.user.name}</a>
			 		<input type="hidden" name="userPass" value="${user.password}">
			 	</c:otherwise>
		 	</c:choose>
		 	</p>
			
			<div class="nav">
				<ul>
					<li class="current">
						<a href="${pageContext.request.contextPath}/index">首&nbsp;&nbsp;页</a>
					</li>
					
					<li >
						<a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/proServlet">产品中心</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/newServlet">新闻中心</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/page/contact.jsp">联系我们</a>
					</li>
					
				</ul>
			</div>
		</div>
		
		<!-------------------------------------广告图----------------------------------------------->
		<div class="slideBox">
			<div class="slideBox_content">
				<div class="hd">
					<ul>
						<li class="on">
							<a href="###"></a>
						</li>
						<li>
							<a href="###"></a>
						</li>
						<li>
							<a href="###"></a>
						</li>
					</ul>
				</div>
				<div class="bd">
					<ul>
						<li class="on">
							<a href="###">
								<img src="${pageContext.request.contextPath}/img/banner.jpg" alt="banner"/>
							</a>
						</li>
						<li>
							<a href="###">
								<img src="${pageContext.request.contextPath}/img/banner1.jpg" alt="banner"/>
							</a>
						</li>
						<li>
							<a href="###">
								<img src="${pageContext.request.contextPath}/img/banner2.jpg" alt="banner"/>
							</a>
						</li>
					</ul>
					
				</div>
				<a href="###" class="prev"></a>
				<a href="###" class="next"></a>
			</div>
		</div>

		<!--------------------------------------内容------------------------------------------------>
		<div class="content">
			<div class="content_all">
				<!--关于我们-->
				<div class="about">
					<div class="title">
						<h2>公司介绍</h2>
						<span>About Us</span>
					</div>
					<a href="${pageContext.request.contextPath}/page/about.jsp">
						<img src="${pageContext.request.contextPath}/img/about.jpg" alt="about" />
					</a>
					<p>
						飞奥电器有限公司是专业的电热水器生产公司，公司成立至今，始终格守“质量是持久生存的基础，创新是发展的关键，
						服务是发展的根本，管理是企业的灵魂”的经营理念，建立了严格的管理制度和完整的管理体系。公司秉承“节能环保”的指导思想，
						坚持“科技领先，追求卓越，忠诚奉献”的经营理念，不断研发出创新型节能环保产品。将最新的科研成果应用于产品中，
						为人类生存环境的改善工作作出一点贡献。 飞奥电器有限公司是专业的电热水器生产公司，公司成立至今，始终格守“质量是持久生存的基础，
						创新是发展的关键，服务是发展的根本，管理是企业的灵魂”的经营理念，建立了严格的管理制度和完整的管理体系。公司秉承“节能环保”的指导思想，
						坚持“科技领先，追求卓越，忠诚奉献”的经营理念，不断研发出创新型节能环保产品。将最新的科研成果应用于产品中，为人类生存环境的改善工作作出一点贡献。
					<a href="${pageContext.request.contextPath}/page/about.jsp" class="more">查看更多&gt;&gt;</a>
					</p>
					<div class="clear"></div>
				</div>
				
				
				
				<!--产品中心-->
				<div class="product">
					<div class="title">
						<h2>产品中心</h2>
						<span>Product Center</span>
					</div>
				<div class="product_list">
					<div class="picScroll">
					
						<ul>
						<c:forEach items="${products}" var="product" end="3">
							<li>
								<a href="${pageContext.request.contextPath}/pro_detailServlet?id=${product.id}">
									<img src="${pageContext.request.contextPath}${product.product_url}" alt="pro"/>
								</a>
								<a href="${pageContext.request.contextPath}/pro_detailServlet?id=${product.id}"><span>${product.product_name}</span></a>
							</li>
							</c:forEach>
						</ul>
					
						<a href="###" class="prev"></a>
						<a href="###" class="next"></a>
				</div>
				</div>
				</div>
				
				
				
				
				<!--新闻中心-->
				<div class="new">
					<div class="title">
						<h2>新闻中心</h2>
						<span>News Center</span>
					</div>
					<div class="new_content">
						<ul> 
							<c:forEach items="${notices}" var="notice" end="6">
								<li>
									<p><a href="${pageContext.request.contextPath}/new_detailServlet?id=${notice.id}">${notice.title}</a></p>
									<span>${notice.publishDate}</span>
								</li>
							</c:forEach>
						</ul>
							
						<a href="${pageContext.request.contextPath}/newServlet">
							<img src="${pageContext.request.contextPath}/img/new.jpg" alt="new"/>
						</a>
						<div class="clear"></div>
					</div>
						
				</div>
			
			</div>
		
		</div>
		
		<!--------------------------------------尾部------------------------------------------------>
		<div class="footer">
			
			<div class="footer_top">
				<div class="left">
					<ul>
						<li>
							<a href="${pageContext.request.contextPath}/index">网站首页</a>
							
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>
							
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/proServlet">产品中心</a>
							
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/newServlet">新闻中心</a>
							
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/page/contact.jsp">联系我们</a>
						</li>
					</ul>
					<p>&nbsp;服务热线：0760-89872666 地址：中山市港口镇盛德路1号-2</p>
					<p>&nbsp;电话：0760-89872666 0760-89872668 传真：0760-89872667</p>
					<p>&nbsp;邮箱：feiaodianqi@163.com 网址：www.feiaodq.com 技术支持：共鸣品牌策划</p>
					
				</div>
				<div class="qr">
					<a href="###"><img src="${pageContext.request.contextPath}/img/QR1.jpg" class="qr1"/></a>
					<a href="###"><img src="${pageContext.request.contextPath}/img/QR2.jpg" class="qr2"/></a>
				</div>
			</div>
				<div class="footer_bottom">
					<p> Copyright  © 2015 MICOE Inc. All rights reserved. 中山飞奥电器有限公司 版权所有.</p>
				</div>
			
		</div>
	</body>
</html>