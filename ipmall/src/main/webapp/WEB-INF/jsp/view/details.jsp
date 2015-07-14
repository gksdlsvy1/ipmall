
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>The Yolk Website Template :: w3layouts</title>
<link href="web/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="web/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="web/css/theme.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
</script>
<!----webfonts---->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800,300'
	rel='stylesheet' type='text/css'>
<!----//webfonts---->
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<script type="text/javascript" src="web/js/bootstrap.js"></script>
<script type="text/javascript" src="web/js/bootstrap.min.js"></script>
<!--  jquery plguin -->
<script type="text/javascript" src="web/js/jquery.min.js"></script>
<!-- start details -->
<!----details-product-slider--->
<!-- Include the Etalage files -->
<link rel="stylesheet" href="web/css/etalage.css">
<script src="web/js/jquery.etalage.min.js"></script>
<!-- Include the Etalage files -->
<script>
	jQuery(document)
			.ready(
					function($) {

						$('#etalage')
								.etalage(
										{
											thumb_image_width : 300,
											thumb_image_height : 400,

											show_hint : true,
											click_callback : function(
													image_anchor, instance_id) {
												alert('Callback example:\nYou clicked on an image with the anchor: "'
														+ image_anchor
														+ '"\n(in Etalage instance: "'
														+ instance_id + '")');
											}
										});
						// This is for the dropdown list example:
						$('.dropdownlist').change(
								function() {
									etalage_show($(this)
											.find('option:selected').attr(
													'class'));
								});

					});
</script>
<!----//details-product-slider--->
<script type="text/javascript">
var totalPrice = ${goods.price};


	function plus(optionPrice) {
		var printPrice = document.getElementById("price");
		totalPrice = totalPrice + optionPrice;
		printPrice.innerHTML = totalPrice;
	}
	
	window.onload = function(){
		plus(0);
	}
</script>

</head>
<body>
	<!----start-container----->
			<div class="header-bg">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="logo"><a href="index.do"><img src="web/images/logo.png" alt=""/></a></div>
					</div>
					<div class="col-md-8">					
	 					<nav class="navbar navbar-default" role="navigation">
						  <div class="container-fluid">
						    <!-- Brand and toggle get grouped for better mobile display -->
						    <div class="navbar-header"><span class="text-left"><a href="#">MENU</a></span>
						      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						        <span class="sr-only">Toggle navigation</span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						        <span class="icon-bar"></span>
						      </button>						   
						    </div>					
						    <!-- Collect the nav links, forms, and other content for toggling -->
						    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						      <ul class="nav navbar-nav">
						      	 <li>
						         <div class="btn-group show-on-hover">
						         
							          <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							            Categories<span class="caret"></span>
							          </button>
							          
							          <ul class="dropdown-menu" role="menu">
							          <c:forEach items="${bigCategory}" var="bigCategory">
							         	 <li>
							         	 <a href="#">${bigCategory.name}</a>
							         	 	<div>
							         	 		<ul class="child" role="menu">
							         				<c:forEach items="${smallCategory}" var="smallCategory">
							         			 		<c:if test = "${smallCategory.upper_category_no == bigCategory.category_no}" var="testResult"> 
							         			 			<li><a href="#">${smallCategory.name}</a></li>
							         			 		</c:if>
							         			 	</c:forEach>	
							         			</ul>
							         	 	</div>
							         	 </li>
							          </c:forEach>
							          </ul>
							        </div>					          
						        </li>
						        <li><a href="about.html">About</a></li>
						        <li><a href="blog.html">Blog</a></li>
						        <li><a href="contact.html">Contact</a></li>
						      </ul>							     
						      		 		
						    </div><!-- /.navbar-collapse -->
						  </div><!-- /.container-fluid -->
						</nav>
						<div class="right">
							<ul class="list-unstyled">
								<c:if test="${empty userSession}">
								<li><a href="main.do"><!-- onclick="window.open('signIn.html','popup','width=300, height=300, menubar=no, status=no, toolbar=no'); "--> Sign In/Up</a></li>
								</c:if>
								<c:if test="${!empty userSession}">
								<li class="a text-left"><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a> $0</li>
								<li><a href="main.do"><!-- onclick="window.open('signIn.html','popup','width=300, height=300, menubar=no, status=no, toolbar=no'); "--> ${userSession.name}</a></li>
								<li><a href="logout.do">Sing Out</a></li>
								</c:if>
							</ul>							
						</div>	
					</div>
					<!----start-images-slider---->	
				  <!-- Single button -->
            				    <form action="search.do" method="post" class="navbar-form pull-right"  style="width: 90%" >
			       			<div class="form-group" style="width:80%" >
			      				  <input type="text" class="form-control" placeholder="Search" name="searchIndex" id="searchIndex" style="width: 60%" >
			      				  <input type="submit" class="btn btn-default" value="검색">
			        		</div>
			        	</form> 
				</div>
			</div>
        </div>	
				<!----start-images-slider---->
				<!-- Single button -->

			</div>
		</div>
	</div>
	<div class="single">
		<div class="container">
			<div class="rsidebar span_1_of_left">
				<section class="sky-form">
					<h4>Occasion</h4>
					<div class="row row1 scroll-pane"
						style="overflow: hidden; padding: 0px; width: 283px;">


						<div class="web/jspContainer" style="width: 283px; height: 200px;">
							<div class="web/jspPane"
								style="padding: 20px; top: 0px; left: 0px; width: 243px;">
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox"
										name="checkbox" checked=""><i></i>Athletic (20)</label>
								</div>
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Athletic Shoes (48)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Casual (45)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Casual (45)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Other (1)</label>
								</div>
							</div>
						</div>
					</div>
					<h4>Category</h4>
					<div class="row row1 scroll-pane"
						style="overflow: hidden; padding: 0px; width: 283px;">


						<div class="web/jspContainer" style="width: 283px; height: 200px;">
							<div class="web/jspPane"
								style="padding: 20px; top: 0px; left: 0px; width: 243px;">
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox"
										name="checkbox" checked=""><i></i>Flats (70)</label>
								</div>
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Athletic Shoes (48)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Athletic Shoes (48)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Heels (38)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Other (1)</label>
								</div>
							</div>
						</div>
					</div>
					<h4>Styles</h4>
					<div class="row row1 scroll-pane"
						style="overflow: hidden; padding: 0px; width: 283px;">


						<div class="web/jspContainer" style="width: 283px; height: 200px;">
							<div class="web/jspPane"
								style="padding: 20px; top: 0px; left: 0px; width: 243px;">
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox"
										name="checkbox" checked=""><i></i>Athletic (20)</label>
								</div>
								<div class="col col-4">
									<label class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Ballerina (5)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Pumps (7)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>High Tops (2)</label> <label
										class="checkbox"><input type="checkbox"
										name="checkbox"><i></i>Other (1)</label>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
			<div class="cont span_2_of_3">
				<div class="labout span_1_of_a1">
					<!-- start product_slider -->
					<ul id="etalage">
						<li><a href="optionallink.html"> <img
								class="etalage_thumb_image" src="${goods.image}" /> <img
								class="etalage_source_image" src="${goods.image}" />
						</a></li>

						<li><img class="etalage_thumb_image" src="${goods.image}" />
							<img class="etalage_source_image" src="${goods.image}" /></li>
						<!-- <li>
								<img class="etalage_thumb_image" src="web/images/t3.jpg" />
								<img class="etalage_source_image" src="web/images/t3.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="web/images/t4.jpg" />
								<img class="etalage_source_image" src="web/images/t4.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="web/images/t5.jpg" />
								<img class="etalage_source_image" src="web/images/t5.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="web/images/t6.jpg" />
								<img class="etalage_source_image" src="web/images/t6.jpg" />
							</li>
							<li>
								<img class="etalage_thumb_image" src="web/images/t1.jpg" />
								<img class="etalage_source_image" src="web/images/t1.jpg" />
							</li> -->
					</ul>


					<!-- end product_slider -->
				</div>
				<div class="cont1 span_2_of_a1 pull-right">
					<h3 class="m_3">${goods.name}</h3>
					<div class="price_single">
						<span class="reducedfrom"> 생각 </span> <span class="actual">${goods.price}</span>
					</div>
					<ul class="options list-unstyled">
						<h4 class="m_9">Select Options</h4>
						<c:forEach items="${options}" var="options">
							<li><a href="#" onClick=plus(${options.price})> ${options.name} <fmt:formatNumber value="${options.price}" type="number" var="numberType"/></a></li>
						</c:forEach>
						<div class="clearfix"></div>
						<h4 class="m_9">출시 연도 : ${goods.release_year}</h4>
					</ul>
					<div class="btn_form">
						<form>
							<input type="submit" value="buy now" title="">
						</form>
					</div>
					<ul class="add-to-links list-unstyled">
						<li><img src="web/images/wish.png" alt=""><a href="#">장바구니</a></li>
					</ul>
					<p class="m_desc">가격 : <span id="price"></span></p>
					<!-- 총 가격 계산해서 넘겨야됨 -->

					<div class="social_single">
						<ul list-unstyled>
							<li class="fb"><a href="#"><span> </span></a></li>
							<li class="tw"><a href="#"><span> </span></a></li>
							<li class="g_plus"><a href="#"><span> </span></a></li>
							<li class="rss"><a href="#"><span> </span></a></li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>


<!--  카티고리 같은 물품 뿌려줄 계획  
			<div class="nbs-flexisel-container">
				<div class="nbs-flexisel-inner">
					<ul id="flexiselDemo1" class="nbs-flexisel-ul"
						style="left: -195.2px; display: block;">
					<c:forEach items="${goodsList}" var="downGoodsList" varStatus="downStatus">
						<li class="nbs-flexisel-item" style="width: 195.2px;"><img
							src="${downGoodsList.image}">
							<div class="grid-flex">
								<!--  <a href="#">${downGoodsList.name}</a>
								<p>${downGoodsList.name}</p>
							</div></li>
							</c:forEach>	
					</ul>
					<div class="nbs-flexisel-nav-left" style="top: 74px;"></div>
					<div class="nbs-flexisel-nav-right" style="top: 74px;"></div>
				</div>
			</div>
			<script type="text/javascript">
				$(window).load(function() {
					$("#flexiselDemo1").flexisel();
					$("#flexiselDemo2").flexisel({
						enableResponsiveBreakpoints : true,
						responsiveBreakpoints : {
							portrait : {
								changePoint : 480,
								visibleItems : 1
							},
							landscape : {
								changePoint : 640,
								visibleItems : 2
							},
							tablet : {
								changePoint : 768,
								visibleItems : 3
							}
						}
					});

					$("#flexiselDemo3").flexisel({
						visibleItems : 5,
						animationSpeed : 1000,
						autoPlay : true,
						autoPlaySpeed : 3000,
						pauseOnHover : true,
						enableResponsiveBreakpoints : true,
						responsiveBreakpoints : {
							portrait : {
								changePoint : 480,
								visibleItems : 1
							},
							landscape : {
								changePoint : 640,
								visibleItems : 2
							},
							tablet : {
								changePoint : 768,
								visibleItems : 3
							}
						}
					});

				});
			</script>
			
			<script type="text/javascript" src="web/js/jquery.flexisel.js"></script>
			-->
			<div class="toogle">
				<h3 class="m_3">Product Details</h3>
				<p class="m_text">${goods.description}</p>
			</div>
			<!--  나중에 리뷰 게시판 만들 계획 
			<div class="toogle">
				<h3 class="m_3">Product Reviews</h3>
				<p class="m_text">Lorem ipsum dolor sit amet, consectetuer
					adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
					dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,
					quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut
					aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in
					hendrerit in vulputate velit esse molestie consequat, vel illum
					dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto
					odio dignissim qui blandit praesent luptatum zzril delenit augue
					duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta
					nobis eleifend option congue nihil imperdiet doming id quod mazim
					placerat facer possim assum.</p>
			</div>		-->
		</div>

		<div class="clearfix"></div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<ul class="list-inline pull-left">
						<li><a href="#">Terms of Services</a></li>
						<li><a href="#">Refunds</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Contact</a></li>
					</ul>
    				    <form action="search.do" method="post" class="navbar-form pull-right"  style="width: 90%" >
			       			<div class="form-group" style="width:80%" >
			      				  <input type="text" class="form-control" placeholder="Search" name="searchIndex" id="searchIndex" style="width: 90%" >
			      				  <input type="submit" value="검색">
			        		</div>
			        	</form> 
				</div>
			</div>
			<div class="copy-right text-center">
				<p>
					&#169Copyright 2014 All Rights Reserved Template <a
						href="http://w3layouts.com/"> w3layouts.com</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>

