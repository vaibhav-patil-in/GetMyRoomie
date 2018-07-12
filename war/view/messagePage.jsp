<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>GetmyRoomie.com</title>
	    <meta name="description" content="Awesome roommates, Awesome rooms, great apartments, cool people, room, roommate. The best way to find rooms and roommates in India for free." />
	
		<meta name="robots" content="index,follow,noodp,noydir" />
		<meta name="google" value="notranslate" />
	
	    <!-- Bootstrap -->
	    <link href="css/bootstrap.css" rel="stylesheet">
	    <link href="css/style.css" rel="stylesheet">
	
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->

		<script src="js/GoogleAnalytics.js" type="text/javascript"></script>
  	</head>
  	
  	<body>

    	<div="mainContainer">

      		<div id="header">
        		<nav class="navbar navbar-default" role="navigation">
          			<div class="container-fluid">
            
            			<!-- Brand and toggle get grouped for better mobile display -->
            			<div class="navbar-header">
              				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                				<span class="sr-only">Mobile Navigation</span>
                				<span class="icon-bar"></span>
                				<span class="icon-bar"></span>
                				<span class="icon-bar"></span>
              				</button>
              				<a class="navbar-brand" href="/">GetMyRoomie</a>
            			</div>

            			<!-- Collect the nav links, forms, and other content for toggling -->
            			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
              				<form class="navbar-form navbar-right" role="search" action="/">
                				<a href="/browseRoomMates"><span class="btn btn-success">Browse Roommates <span class="glyphicon glyphicon-user"></span></span></a>
                				<a href="/browseRooms"><span class="btn btn-success">Browse Rooms <span class="glyphicon glyphicon-home"></span></span></a>

                				<sec:authorize access="isAnonymous()">
                				<a href="/profile"><span class="btn btn-success">Login</span></a>
                				</sec:authorize>
                				<sec:authorize access="isAuthenticated()">
                				<a href="/profile"><span class="btn btn-success">My Profile</span></a>
                				<a href="/logout"><span class="btn btn-success">Log Out</span></a>
                				</sec:authorize>
              				</form>
            			</div>
          			</div>
        		</nav>
      		</div>

      		<div id="container">
        		<div class="tab-content">
          			<div class="tab-pane active" id="Inbox" style="border-top: 1px solid #ddd;">
						<c:if test="${message != null}">
            			<div class="alert alert-success alert-dismissable">
              				${message}
            			</div>
            			</c:if>
          			</div>
        		</div>
      		</div>

      		<div id="footer">
      			<footer>
          			<p style="text-align:center;">Copyright © - getmyroomie.com</p>
        		</footer>
      		</div>
    	</div>

    	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    	<script type="text/javascript">window.jQuery || document.write("<script type='text/javascript' src='../js/lib/jquery-1.10.2.js'>\x3C/script>")</script>
    	<script src="js/bootstrap.js"></script>
    	<script src="js/holder.js"></script>
  	
  	</body>
</html>