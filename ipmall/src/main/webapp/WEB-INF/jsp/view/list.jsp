<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="web/css/jquery-ui.css" />
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
																		<li><a href="list.do?val=${smallCategory.category_no}">${smallCategory.name}</a></li>
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
								<li><a href="main.do">
										<!-- onclick="window.open('signIn.html','popup','width=300, height=300, menubar=no, status=no, toolbar=no'); "-->
										Sign In/Up
								</a></li>
							</c:if>
							<c:if test="${!empty userSession}">
								<li class="a text-left"><a href="#"><span
										class="glyphicon glyphicon-shopping-cart"></span></a> $0</li>
								<li><a href="main.do">
										<!-- onclick="window.open('signIn.html','popup','width=300, height=300, menubar=no, status=no, toolbar=no'); "-->
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
							name="searchIndex" id="searchIndex" style="width: 60%">
						<input type="submit" class="btn btn-default" value="검색">
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="blog-head">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-left">
					<h2>list</h2>
				</div>
			</div>

		</div>
	</div>
	<!---start-Blog---->
	<div class="container">
		<div class="blog">
			<div class="blog-grids">
				<div class="blog-grids-head"></div>


				<div class="blog-grids-box">
					<c:forEach var="i" begin="1" end="${goodsRowNum}" step="1">
						<div class="row">
							<c:forEach items="${goodsList}" var="goodsList"
								varStatus="status">
								<div class="col-md-6">
									<div class="blog-grid">
										<div class="blog-poast-head">

											<div class="blog-art-pic">
												<a class="post-pic" href="#"> <img
													src="${goodsList.image}" title="poast-name" /></a>
											</div>
											<div class="blog-poast-info">
												<ul>
													<li><span> </span> 생각해보자!!</li>
													<div class="clear"></div>
												</ul>
											</div>
										</div>
										<div class="blog-info">
											<h3>
												<a href="#">${goodsList.name}</a>
											</h3>
											<p>${goodsList.description}</p>
											<a class="btn" href="detail.do?val=${goodsList.goods_no}">구매</a>
										</div>
									</div>
								</div>
								<c:if test="${status.count} == 3">
									<c:set var="doneLoop" value="true" />
								</c:if>
								<div class="clear"></div>
							</c:forEach>
						</div>
					</c:forEach>

					<div class="criuse-grid-load">
						<a href="#">Loading More</a>
					</div>

				</div>
			</div>
			<!----//End-Blog---->
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

