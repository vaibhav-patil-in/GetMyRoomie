<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Welcome to GetmyRoomie.com | Easy room, roommate, apartment and room rental search | India</title>
	    <meta name="description" content="Awesome roommates, Awesome rooms, great apartments, cool people, room, roommate. The best way to find rooms and roommates in India for free." />
	    <meta name="keywords" content="room, roommates, apartment, rent, roomies" />
	
		<meta name="robots" content="index,follow,noodp,noydir" />
		<meta name="google" value="notranslate" />
	
	    <!-- Bootstrap -->
	    <link href="css/bootstrap.css" rel="stylesheet">
	    <link href="css/bootstrapValidator.css" rel="stylesheet"/>
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

      		<!-- Login modal -->
      		<%@ include file="lightbox/about_lightbox.jsp"%>
      		<!-- Login modal ends -->
      
	      	<!-- Post Ad modal -->
	      	<%@ include file="lightbox/postad_lightbox.jsp"%>
	      	<!-- Post Ad modal ends -->
	
	      	<!-- logoff header -->
	      	<%@ include file="common/logoff_header.jsp"%>
	      	<!-- logoff header ends-->

      		<div id="container" style="height: 100%">
        		<div id="jumbotron" class="jumbotron-home-img">
        			<h2 style="text-align:center;"><b style="color: white;text-shadow:2px 2px 7px #222;">Finding an awesome room or roommate is easy now.</b></h2>
            		<div id="homePageJumbotron">
	            		<div class="searchbox">
	            			<form action="/searchRoomsFromHomePage" method="POST" class="home-page-search-form">
		            			<select id="searchType" class="search-select" name="searchType">
		                    		<option value="room">Room</option>
			                		<option value="roommate">Roommate</option>
		                		</select>
		            			<input id="homeLocation" type="text" name="homeLocation" class="search-input" value="" placeholder="Search by neighborhood, city, zip or address" autocomplete="off">
		            			<button type="submit" class="btn search-button">Search <span class="glyphicon glyphicon-search"></span></button>
	            			</form>
	            		</div>
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
    	<script src="js/lib/jquery.blockUI.js" type="text/javascript"></script>
    	<script src="js/bootstrap.js"></script>
    	<script src="js/bootstrapValidator.js" type="text/javascript"></script>
    	<script src="js/scripts.js" type="text/javascript"></script>
    	<script src="js/ajax.js" type="text/javascript"></script>
		<script type="text/javascript">
			//AJAX bind call for ajax initialization...
			var ajax = new ROOM.AJAX();	
		</script>
	
		<script src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>

		<script type="text/javascript">
			function initialize() {
    			var input = document.getElementById('homeLocation');
    			var options = {componentRestrictions: {country: 'in'}};     
    			new google.maps.places.Autocomplete(input, options);
			}
        	google.maps.event.addDomListener(window, 'load', initialize);
		</script>
	</body>
</html>