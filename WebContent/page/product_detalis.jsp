<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品详情</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product_details.css" />
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
			<div class="nav">
				<ul>
					<li >
						<a href="${pageContext.request.contextPath}/index">首&nbsp;&nbsp;页</a>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>
					</li>
					<li class="current">
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
		
		
		<!------------------------------------------------------中间------------------------------------------------------------->
		<div class="content">
			<div class="title">
				<h2>产品详情</h2>
				<span>Product Details</span>
			</div>
			<div class="location">
				<ul>
					<li>
						<i>当前位置：</i>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/page/index.jsp">首页</a>&gt;
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/proServlet">产品中心</a>&gt;
					</li>	
					<li class="location_current">
						<a href="${pageContext.request.contextPath}/page/product_details.jsp">产品详情</a>
					</li>
				</ul>
			</div>
			
			<div class="main">
				<div class="picfocus">
					<div class="bd">
						<ul>
							<li>
								<a href="###">
									<img src="${pageContext.request.contextPath}/img/product-details.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="###">
									<img src="${pageContext.request.contextPath}/img/product-details.jpg" alt="" />
								</a>
							</li>
							<li>
								<a href="###">
									<img src="${pageContext.request.contextPath}/img/product-details.jpg" alt="" />
								</a>
							</li>
						</ul>
					</div>
					<div class="hd">
						<ul>
							<li>
								<a href="###">
									<img src="${pageContext.request.contextPath}/img/product-details1.jpg" alt=""/>
								</a>
							</li>
							<li>
								<a href="###">
									<img src="${pageContext.request.contextPath}/img/product-details1.jpg" alt=""/>
								</a>
							</li>
							<li>
								<a href="###">
									<img src="${pageContext.request.contextPath}/img/product-details1.jpg" alt=""/>
								</a>
							</li>
						</ul>
					</div>
					
				</div>
				
				
				<div class="prolist">
					<div class="main_list">
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p> ${detail.product_name}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>额定电压：${detail.product_voltage}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>功率:${detail.product_power}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>放水等级：${detail.product_water}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>额定压力：${detail.product_pressure}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>外壳：${detail.product_shell}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>容量：${detail.product_capacity}</p>
						<img src="${pageContext.request.contextPath}/img/prolist.png">
						<p>${detail.content}</p>

					</div><br />
					
					<span><a href="###">上一个：FAB-SO1P/时尚数显型</a></span>
					<span><a href="###">下一个：FAB-SO1P/时尚数显型</a></span>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		
		
		<!-------------------------------------------------------尾部-------------------------------------------------------->
		
		<div class="footer">
			
			<div class="footer_top">
				<div class="left">
					<ul>
						<li>
							<a href="${pageContext.request.contextPath}/page/index.jsp">网站首页</a>
							
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/page/about.jsp">关于我们</a>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/page/product.jsp">产品中心</a>
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
