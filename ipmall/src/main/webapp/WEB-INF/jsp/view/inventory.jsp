
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	var totalPrice = $
	{
		goods.price
	};

	$(document).ready(
			function() {
				// 옵션추가 버튼 클릭시

				$(".options").click(
						function(option) {
							// item 의 최대번호 구하기
							var lastItemNo = $("#example tr:last")
									.attr("class").replace("item", "");

							var newitem = $("#example tr:eq(1)").clone();
							newitem.removeClass();
							newitem.find("td:eq(0)").attr("rowspan", "1");
							newitem.addClass("item"
									+ (parseInt(lastItemNo) + 1));

							$("#example").append(newitem);
						});

				// 삭제버튼 클릭시
				$(".delBtn").live(
						"click",
						function() {
							var clickedRow = $(this).parent().parent();
							var cls = clickedRow.attr("class");

							// 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
							if (clickedRow.find("td:eq(0)").attr("rowspan")) {
								if (clickedRow.next().hasClass(cls)) {
									clickedRow.next().prepend(
											clickedRow.find("td:eq(0)"));
								}
							}

							clickedRow.remove();

							// rowspan 조정
							resizeRowspan(cls);
						});

				// cls : rowspan 을 조정할 class ex) item1, item2, ...
				function resizeRowspan(cls) {
					var rowspan = $("." + cls).length;
					$("." + cls + ":first td:eq(0)").attr("rowspan", rowspan);
				}
			});
</script>

</head>
<body>
	<!----start-container----->
	<div class="header-bg">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="logo">
						<a href="index.do"><img src="web/images/logo.png" alt="" /></a>
					</div>
				</div>
				<div class="col-md-8">
					<nav class="navbar navbar-default" role="navigation">
						<div class="container-fluid">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<span class="text-left"><a href="#">MENU</a></span>
								<button type="button" class="navbar-toggle"
									data-toggle="collapse"
									data-target="#bs-example-navbar-collapse-1">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
							</div>
							<!-- Collect the nav links, forms, and other content for toggling -->
							<div class="collapse navbar-collapse"
								id="bs-example-navbar-collapse-1">
								<ul class="nav navbar-nav">
									<li>
										<div class="btn-group show-on-hover">

											<button type="button" class="btn btn-default dropdown-toggle"
												data-toggle="dropdown">
												Categories<span class="caret"></span>
											</button>

											<ul class="dropdown-menu" role="menu">
												<c:forEach items="${bigCategory}" var="bigCategory">
													<li><a href="#">${bigCategory.name}</a>
														<div>
															<ul class="child" role="menu">
																<c:forEach items="${smallCategory}" var="smallCategory">
																	<c:if
																		test="${smallCategory.upper_category_no == bigCategory.category_no}"
																		var="testResult">
																		<li><a
																			href="list.do?val=${smallCategory.category_no}">${smallCategory.name}</a></li>
																	</c:if>
																</c:forEach>
															</ul>
														</div></li>
												</c:forEach>
											</ul>
										</div>
									</li>
									<li><a href="about.html">About</a></li>
									<li><a href="blog.html">Blog</a></li>
									<li><a href="contact.html">Contact</a></li>
								</ul>

							</div>
							<!-- /.navbar-collapse -->
						</div>
						<!-- /.container-fluid -->
					</nav>
					<div class="right">
						<ul class="list-unstyled">
							<c:if test="${empty userSession}">
								<li><a href="main.do"> <!-- onclick="window.open('signIn.html','popup','width=300, height=300, menubar=no, status=no, toolbar=no'); "-->
										Sign In/Up
								</a></li>
							</c:if>
							<c:if test="${!empty userSession}">
								<li class="a text-left"><a href="#"><span
										class="glyphicon glyphicon-shopping-cart"></span></a> $0</li>
								<li><a href="main.do"> <!-- onclick="window.open('signIn.html','popup','width=300, height=300, menubar=no, status=no, toolbar=no'); "-->
										${userSession.name}
								</a></li>
								<li><a href="logout.do">Sing Out</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<!----start-images-slider---->
				<!-- Single button -->
				<form action="search.do" method="post"
					class="navbar-form pull-right" style="width: 90%">
					<div class="form-group" style="width: 80%">
						<input type="text" class="form-control" placeholder="Search"
							name="searchIndex" id="searchIndex" style="width: 60%"> <input
							type="submit" class="btn btn-default" value="검색">
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
			
			
			<c:forEach items="$inventory" var="inventory">
			<table id="inventoryInfo" border="1px">
			<tr>
				<th>상품/옵셩정보</th>
				<th>수량</th>
				<th>상품금액</th>
				<th>주문</th>
			</tr>
			<tr class="item1">
				<td><input type="text" /></td>
				<td><input type="text"/> </td>
				<td><input type="text"/></td>
				<td><input type="button" value="주문" onclick="location.href='order.do'">
					<input type="button" value="삭제"/>
				</td>
			</tr>
			</table>
			
			</c:forEach>
			
			
			
			
			
		</div>
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
					<form action="search.do" method="post"
						class="navbar-form pull-right" style="width: 90%">
						<div class="form-group" style="width: 80%">
							<input type="text" class="form-control" placeholder="Search"
								name="searchIndex" id="searchIndex" style="width: 90%">
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

