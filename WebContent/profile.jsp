<%@page import="containers.Bots"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="containers.Medals"%>
<%@page import="database.UserAccess"%>
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
	
	System.out.println(a.toString());

	Medals medal = new Medals();
	ResultSet rs = UserAccess.GrabMedals(a.getID());
	while (rs.next()) {

		medal.addMedal(rs.getString("medalImage"));

	}
	
	Bots bot = new Bots();
	ResultSet rs2 = UserAccess.LoadBots(a.getID());
	while (rs2.next()) {

		bot.addBot("<li>" + rs2.getString("botName") + " - Game: " + rs2.getString("gameName"));

	} 
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>AI Wars - <%=a.getName()%></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="css/bootstrap.css" rel="stylesheet">
<style type="text/css">

/* * {
border: 1px solid red;

} */
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.fLeft {
	width: 20%;
	float: left;
	display: inline;
}

.fRight {
	width: 70%;
	float: right;
	display: inline;
}

.solid {
	background-color: #fff;
}

.padMe {
	padding-left: 10px;
}

.expand {
	min-height: 350px;
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
						<li><a href="upload.jsp">Upload</a></li>
						<li class="active"><a href="profile.jsp">Profile</a></li>
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

	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="well expand">
			<div class="fLeft">
				<img width="256" height="256"
					src="data:image/jpeg;base64,<%=a.getImage()%>" class="img-polaroid">
				<br>


			</div>
			<div class="fRight">
				<h1><%=a.getName()%></h1>
				<h4><%=a.getTagline()%>
					<%=a.getSchool()%></h4>
				<p>
				<hr>
				<%=a.getBiography()%>
				</p>
			</div>




		</div>
		<hr>
		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Owned Bots</h2>
			
					<ul>
					<% for (String s : bot.dumpBots()) { %>
					<%= s %>
					<% }%>
					</ul>
			
			</div>
			<div class="span4">
				<h2>Player Stats</h2>
				<p>
					Won  - 5<br>
					Lost - 20
				</p>
			</div>
			<div class="span4">
				<h2>Medals</h2>
				<p>
				<% if (medal.dumpMedals().size() == 0) { %>
				I have no medals :(
				<% } else { 
				
					for(String s : medal.dumpMedals()) {
				
				%>
				
				<%= s %>
				
				<% } } %>
				</p>
			</div>



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
