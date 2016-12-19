<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.ai.takeaway.model.User, java.util.List, com.ai.takeaway.model.Restaurant, com.ai.takeaway.model.Order, com.ai.takeaway.model.Dish"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Takeaway</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Strona główna</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu message-dropdown">
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-footer"><a href="#">Read All New
								Messages</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-primary">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-success">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span class="label label-info">Alert
									Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-warning">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Inbox</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li><a href="restauracja_zamow.html"><i
							class="fa fa-fw fa-dashboard"></i> Zamów obiad</a></li>
					<li><a href="dodaj_zamowienie.html"><i
							class="fa fa-fw fa-dashboard"></i> Dodaj nowe zamówienie </a></li>
					<li><a href="dodaj_restauracje.html"><i
							class="fa fa-fw fa-dashboard"></i> Dodaj restaurację</a></li>
					<li><a href="realizowane_zamowienia.html"><i
							class="fa fa-fw fa-dashboard"></i> Realizowane zamówienia</a></li>


					<li><a href="edytuj_konto.html"><i
							class="fa fa-fw fa-wrench"></i> Edytuj konto</a></li>
					<li><a href="javascript:;" data-toggle="collapse"
						data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i>
							Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
						<ul id="demo" class="collapse">
							<li><a href="#">Dropdown Item</a></li>
							<li><a href="#">Dropdown Item</a></li>
						</ul></li>
					<li class="active"><a href="blank-page.html"><i
							class="fa fa-fw fa-file"></i> Blank Page</a></li>
					<li><a href="index-rtl.html"><i
							class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Blank Page <small>Subheading</small>
						</h1>

						<div>
							<%
								User user = (User) request.getSession().getAttribute("user");
								if (user != null) {
							%>
							<tr>
								<td><%=user.getUser_name()%></td>
								<td><%=user.getUser_lastname()%></td>
							</tr>
							<%
								}
							%>
						</div>

						<table>
							<h2>Lista restauracji:</h2>
							<table style="width: 70%" border="1">
								<tr>
									<th>Nazwa</th>
									<th>Link:</th>
									<th>Opis:</th>
								</tr>
								<%
									List<Restaurant> restList = (List<Restaurant>) request.getSession().getAttribute("restaurantList");
									for (Restaurant res : restList) {
								%>

								<tr>
									<td><%= res.getRes_name()%></td>
									<td><%= res.getRes_menu_link()%></td>
									<td><%= res.getRes_info() %></td>
								</tr>
								<%
									}
								%>
							</table>

													<table>
							<h2>Realizowane zamówienia:</h2>
							<table style="width: 70%" border="1">
								<tr>
									<th>ID zamównienia</th>
									<th>ID restauracji:</th>
									<th>ID użytkownika:</th>
								</tr>
								<%
									List<Order> orderList = (List<Order>) request.getSession().getAttribute("orderList");
									for (Order order : orderList) {
								%>
								<tr>
									<td><%= order.getOrder_id()%></td>
									<td><%= order.getOrder_res_id()%></td>
									<td><%= order.getOrder_user_id() %></td>
								</tr>
								<%
									}
								%>
							</table>
							
						
								<h2>Lista zamówionych dań:</h2>
							<table style="width: 70%" border="1">
								<tr>
									<th>Nazwa dania</th>
								<th>Cena (zł):</th>
									<th>Czy zapłacono?:</th>
									<th>Wpłacona kwota:</th>
									<th>ID zamawiającego:</th>
									<th>ID zamówienia:</th>
								</tr>
								<%
									List<Dish> dishList = (List<Dish>) request.getSession().getAttribute("dishList");
									for (Dish dish : dishList) {
								%>

								<tr>
									<td><%= dish.getDish_name()%></td>
									<td><%= dish.getDish_cost()%></td>
									<td><%= dish.getDish_paid() %></td>
									<td><%= dish.getDish_paid_money() %></td>
									<td><%= dish.getDish_user_id() %></td>
									<td><%= dish.getDish_order_id() %></td>
									
									
								</tr>
								<%
									}
								%>
							</table>
							

							<ol class="breadcrumb">
								<li><i class="fa fa-dashboard"></i> <a href="index.html">Dashboard</a>
								</li>
								<li class="active"><i class="fa fa-file"></i> Blank Page</li>
							</ol>
					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
