<%@page import="database.UserAccess"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<% 

if (request.getParameter("postBack") != null) {
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	boolean created = UserAccess.Create(email, password, firstname, lastname);
	
	response.setStatus(response.SC_MOVED_TEMPORARILY);
	if (created) {
		
		response.setHeader("Location", "login.jsp?c"); 
	}
	else {
		
		response.setHeader("Location", "signup.jsp?e");
	}
}


%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>AI Wars - Sign up</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

       /* Custom container */
      .container-narrow {
        margin: 0 auto;
        max-width: 700px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }
      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

          .bg {
      width: 100%;
      height: 100%;
      position: fixed;
      top: 0;
      left: 0;
      z-index: -5000;   
  }

  .centre {
    text-align: center;
  }
    </style>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>

  <body>
  <div class="container-narrow well">

       
<div class="masthead">


        <ul class="nav nav-pills pull-right">
          <li><a href="index.jsp">home</a></li>
          
          <li class="active"><a href="signup.jsp">sign up</a></li>
          <li><a href="login.jsp">login</a></li>
        </ul>
        <h3 class="muted">AI Wars<sub><small>&alpha;</small></sub></h3>
        
        <% if (request.getParameter("e") != null) { %>
<div class="alert alert-danger">
  <button type="button" class="close" data-dismiss="alert">&times;</button>
  <strong>Oops!</strong> Looks like something went wrong.
</div>
<% } %>
      </div>
      <form class="form-signin" method="post" action="signup.jsp">
        <h2 class="form-signin-heading centre">Join the Skirmish.</h2>
        <input type="hidden" name="postBack" value="register">
        <input type="text" class="input-block-level" name="email" placeholder="Email address">
        <input type="password" class="input-block-level" name="password" placeholder="Password">
        <input type="password" class="input-block-level" name="password2" placeholder="Confirm">
         <input type="text" class="input-block-level" name="firstname" placeholder="First Name">
          <input type="text" class="input-block-level" name="lastname" placeholder="Last Name">

      <div class="centre"><button class="btn btn-large btn-primary" type="submit">Sign up</button></div>
        
      </form>

 <div class="footer">
      <p>&copy; AI Wars</p>
      </div>
</div>
	<script src="js/jquery.js"></script>
	 <script src="js/bootstrap.js"></script>

  </body>
</html>
