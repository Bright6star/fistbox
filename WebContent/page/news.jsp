<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻中心</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/public.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/news.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/roll.js"></script>
</head>
<body>

	<!--------------------------------------头部------------------------------------------------>
	<div class="header">
		<a href="${pageContext.request.contextPath}/page/page/index.jsp">
			<img src="${pageContext.request.contextPath}/img/logo.jpg" alt=""
			class="logo" />
		</a>
		<div class="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/index">首&nbsp;&nbsp;页</a>
				</li>

				<li><a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a></li>
				<li><a
					href="${pageContext.request.contextPath}/proServlet">产品中心</a>
				</li>
				<li class="current"><a
					href="${pageContext.request.contextPath}/newServlet">新闻中心</a></li>
				<li><a
					href="${pageContext.request.contextPath}/page/contact.jsp">联系我们</a>
				</li>

			</ul>
		</div>
	</div>



	<!-------------------------------------广告图----------------------------------------------->
	<div class="slideBox">
		<div class="slideBox_content">
			<div class="hd">
				<ul>
					<li class="on"><a href="###"></a></li>
					<li><a href="###"></a></li>
					<li><a href="###"></a></li>
				</ul>
			</div>
			<div class="bd">
				<ul>
					<li class="on"><a href="###"> <img
							src="${pageContext.request.contextPath}/img/banner.jpg"
							alt="banner" />
					</a></li>
					<li><a href="###"> <img
							src="${pageContext.request.contextPath}/img/banner1.jpg"
							alt="banner" />
					</a></li>
					<li><a href="###"> <img
							src="${pageContext.request.contextPath}/img/banner2.jpg"
							alt="banner" />
					</a></li>
				</ul>

			</div>
			<a href="###" class="prev"></a> <a href="###" class="next"></a>
		</div>
	</div>


	<!----------------------------------------中间------------------------------------------>
	<div class="content">
		<div class="sidebar">
			<div class="sidebar_title">
				<h2>新闻中心</h2>
				<span>News</span>
			</div>
			<ul>
				<li class="currents"><a href="${pageContext.request.contextPath}/newServlet">最新资讯</a></li>
				<li><a href="###">公司动态</a></li>
				<li><a href="###">公司新闻</a></li>
				<li><a href="###">行业新闻</a></li>
			</ul>
		</div>
		<div class="new_content">
			<div class="location">
				<ul>
					<li><i>当前位置：</i></li>
					<li><a
						href="${pageContext.request.contextPath}/index">首页</a>&gt;
					</li>
					<li class="new_current"><a
						href="${pageContext.request.contextPath}/newServlet">新闻中心</a></li>
				</ul>
			</div>
			<div class="new_list">
				<ol>
					<c:forEach items="${notices}" var="notice" step="1" end="4">
						<li><a
							href="${pageContext.request.contextPath}/new_detailServlet?id=${notice.id}">
								<img src="${pageContext.request.contextPath}/img/news.jpg"
								alt="news" />
						</a>

							<h5>
								<a
									href="${pageContext.request.contextPath}/new_detailServlet?id=${notice.id}">
									${notice.title} </a>
							</h5> <span>${notice.publishDate}</span>

							<p>
								<a
									href="${pageContext.request.contextPath}/new_detailServlet?id=${notice.id}">
									${notice.content} </a>
							</p>
							</li>
					</c:forEach>
				</ol>
			</div>
			<c:if test="${pageModel.getTotalPage() != 1}">
				<div class="page">
					<ul>
					<c:if test="${pageModel.pageIndex == 1}">
							<li><a>首页</a></li>
							<li><a>上一页</a></li>
					</c:if>	
					<c:if test="${pageModel.pageIndex > 1}">
							<li><a href="${pageContext.request.contextPath}/newServlet?pageIndex=1&title=${title}" >首页</a></li>
							<li><a href="${pageContext.request.contextPath}/newServlet?pageIndex=${pageModel.pageIndex-1}&title=${title}">上一页</a></li>
					</c:if>
					<c:if test="${pageModel.pageIndex < pageModel.getTotalPage()}">
							<li><a href="${pageContext.request.contextPath}/newServlet?pageIndex=${pageModel.pageIndex+1}&title=${title}" >下一页</a></li>
							<li><a href="${pageContext.request.contextPath}/newServlet?pageIndex=${pageModel.getTotalPage()}&title=${title}" >尾页</a></li>
					</c:if>
					<c:if test="${pageModel.pageIndex == pageModel.getTotalPage()}">
							<li><a>下一页</a></li>
							<li><a>尾页</a></li>
					</c:if>
						
					</ul>
				</div>	
			</c:if>		
			</div>
			
		</div>

		<div class="clear"></div>
	</div>


	<!--------------------------------------尾部------------------------------------------------>
	<div class="footer">

		<div class="footer_top">
			<div class="left">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/page/index.jsp">网站首页</a>

					</li>
					<li><a
						href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>

					</li>
					<li><a
						href="${pageContext.request.contextPath}/proServlet">产品中心</a>

					</li>
					<li><a href="${pageContext.request.contextPath}/newServlet">新闻中心</a>

					</li>
					<li><a
						href="${pageContext.request.contextPath}/page/contact.jsp">联系我们</a>
					</li>
				</ul>
				<p>&nbsp;服务热线：0760-89872666 地址：中山市港口镇盛德路1号-2</p>
				<p>&nbsp;电话：0760-89872666 0760-89872668 传真：0760-89872667</p>
				<p>&nbsp;邮箱：feiaodianqi@163.com 网址：www.feiaodq.com 技术支持：共鸣品牌策划</p>

			</div>
			<div class="qr">
				<a href="###"><img
					src="${pageContext.request.contextPath}/img/QR1.jpg" class="qr1" /></a>
				<a href="###"><img
					src="${pageContext.request.contextPath}/img/QR2.jpg" class="qr2" /></a>
			</div>
		</div>
		<div class="footer_bottom">
			<p>Copyright © 2015 MICOE Inc. All rights reserved. 中山飞奥电器有限公司
				版权所有.</p>
		</div>

	</div>
</body>
</html>