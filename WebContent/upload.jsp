<%@page import="containers.Account"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%
	Account a = null;
	a = (Account) session.getAttribute("playerAccount");

	if (a == null) {
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>AI Wars - Upload</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.solid {
	background-color: #fff;
}

.padMe {
	padding-left: 10px;
}
</style>
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
    <![endif]-->

</head>

<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="home.jsp">AI Wars</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="home.jsp">Home</a></li>
						<li><a href="versus.jsp">Versus</a></li>
						<li class="active"><a href="upload.jsp">Upload</a></li>
								<li><a href="profile.jsp">Profile</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Resources <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">AI Interfaces</a></li>
								<li><a href="#">Code Samples</a></li>
								<li><a href="#">Documentation</a></li>
							</ul></li>
					</ul>
					<p class="navbar-text pull-right">
						Logged in as <a href="profile.jsp" class="navbar-link"><%=a.getName()%></a>
					</p>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container solid">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">

			<%
				if (request.getParameter("postBack") != null) {
			%>
			<h1>Upload Results</h1>
			<hr>

			<%
				} else {
			%>
			<h1>Upload</h1>
			<hr>

			<form class="form-inline" method="post" action="versus.jsp">
				<input type="hidden" name="postBack" value="versus"> <select>
					<option>-Select Game-</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
				<input type="text" name="name" placeholder="AI Name">
				<input type="file" name="file" id="file">
				<button type="submit" class="btn btn-primary">Upload!</button>
			</form>

			<%
				}
			%>

		</div>
		<hr>

		<footer>
			<p>&copy; AI Wars</p>
		</footer>

	</div>
	<!-- /container -->

	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.js"></script>


</body>
</html>
