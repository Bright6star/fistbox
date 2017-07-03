<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻详情页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/new_details.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/roll.js" ></script>
		
	</head>
	<body>
				<!--------------------------------------头部------------------------------------------------>
		<div class="header">
			<a href="${pageContext.request.contextPath}/page/page/index.jsp">
				<img src="${pageContext.request.contextPath}/img/logo.jpg" alt="" class="logo"/>
			</a>
			<div class="nav">
				<ul>
					<li>
						<a href="${pageContext.request.contextPath}/index">首&nbsp;&nbsp;页</a>
					</li>
					
					<li >
						<a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/proServlet">产品中心</a>
					</li>
					<li class="current">
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
		
		
		<!--------------------------------------中间----------------------------------------------->
		<div class="content">
			<div class="contact_title">
				<h3>新闻详情</h3>
				<span>News Details</span>
			</div>
				<ul>
					<li>
						<i>当前位置：</i>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/page/index.jsp">首页</a>&gt;
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/newServlet">新闻中心</a>&gt;
					</li>
					<li class="current_">
						<a href="###">新闻详情</a>
					</li>
				</ul>
				<div class="main">
					<h1>${detail.title}</h1>
					<span>${detail.publishDate}</span>
					<img src="${pageContext.request.contextPath}/img/main.jpg" alt="new"/>
					<p>
						${detail.content}
					</p>
					
					<div class="filp">
						<a href="###">上一篇：飞奥电器官方网站上线</a>
						<a href="###">下一篇：商业银行等金融机构要</a>
					</div>
				</div>
			<div class="clear"></div>
		</div>
		
			<!--------------------------------------尾部------------------------------------------------>
		<div class="footer">
			
			<div class="footer_top">
				<div class="left">
					<ul>
						<li>
							<a href="index.jsp">网站首页</a>
							<!--<span>|</span>-->
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>
							<!--<span>|</span>-->
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/proServlet">产品中心</a>
							<!--<span>|</span>-->
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/page/news.jsp">新闻中心</a>
							<!--<span>|</span>-->
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
