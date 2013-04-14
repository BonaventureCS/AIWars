<%@page import="tictactoe.GameTicTacToe"%>
<%@page import="game.fourinarow.GameFourInARow"%>
<%@page import="gamerunner.GameRunner"%>
<%@page import="game.chips.GameChips"%>
<%@page import="ai.player.Player"%>
<%@page import="gamerunner.GameRunnerRoundRobbin"%>
<%@page import="ai.game.Game"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gamemanager.AIWars"%>
<%@page import="containers.Account"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%

boolean verbosity = false;
GameRunner runner = null;

if (request.getParameter("postBack") != null) {
	
	ArrayList<Player> players;
	Class<?> game = null;
	
	
	if(request.getParameter("gameName").equals("Chips")) {
		game = GameChips.class;	
	}
	else if(request.getParameter("gameName").equals("Four in a Row")) {
		game = GameFourInARow.class;
	}
	else if(request.getParameter("gameName").equals("Tic-Tac-Toe")) {
		game = GameTicTacToe.class;
	}
	
	players = AIWars.getBots(game);	
	
	if(request.getParameter("verbosity").equals("on")) {
		verbosity = true;
	}
	
	System.err.println(verbosity);
	
	if (request.getParameter("gameMode").equals("Round Robin")) {
		runner = new GameRunnerRoundRobbin(players, game, verbosity);
	}
	
}

	Account a = null;
	a = (Account) session.getAttribute("playerAccount");

	if (a == null) {
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "login.jsp");
		return;
	}
	
	ArrayList<Game> games = AIWars.getGames();
	
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>AI Wars - Versus</title>
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
						<li class="active"><a href="versus.jsp">Versus</a></li>
						<li><a href="upload.jsp">Upload</a></li>
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
			<h1>Versus Results</h1>
			<hr>
			<div class="well">

				<% if(runner.getWinners().size() == 0) { %>

				There is no winner. You all suck.<br>

				<% } else if (runner.getWinners().size() == 1) { %>

				The winner is
				<%= runner.getWinners().get(0).getName() + "!" %>

				<% } 
			
			else if (runner.getWinners().size() > 1) { %>

				The winners are
				<% for (int i = 0; i < runner.getWinners().size(); i++) { Player p = runner.getWinners().get(i); %>
				
				<%= p.getName() %>
				
				<%= i < runner.getWinners().size() - 1 ? " &amp; " : "!" %>

				<% }  }
			
			runner.getGames();
			runner.getGames().get(0);
			
			if(runner.getGames().get(0).isVerbose()) {  %>

				<h3>Verbose output</h3>

				<%
				for (Game g : runner.getGames()) {
				for (String s : g.getOutput()) {
			
			%>

				<%= s + "<br>" %>
				<% } 
				Player player = g.getWinner();
				%>
				<%= "<strong>" + (player==null?"Nobody ":player.getName()) + " won!</strong><hr>" %>
				<%  } } %>


			</div>

			<%
				} else {
			%>
			<h1>Versus</h1>
			<hr>

			<form class="form-inline" method="post" action="versus.jsp">
				<input type="hidden" name="postBack" value="versus"> <select
					name="gameName">

					<% for (Game g : games) { %>

					<%= "<option value=\"" + g.getTitle() + "\">" + g.getTitle() + "</option>" %>

					<% } %>

				</select> <select name="gameMode">
					<option value="Round Robin">Round Robin</option>
					<option>Exhibition</option>
					<option>Human</option>

				</select> <select name="verbosity">
					<option value="off">Off</option>
					<option value="on">On</option>
				</select> |
				<button type="submit" class="btn btn-danger">Fight!</button>
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
