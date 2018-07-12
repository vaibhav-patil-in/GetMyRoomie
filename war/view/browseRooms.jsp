<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
   		<title>Find Awesome Room | GetmyRoomie.com</title>
    	<meta name="description" content="Awesome roommates, Awesome rooms, great apartments, cool people, room, roommate. The best way to find rooms and roommates in India for free.">

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
                	            
                	            <sec:authorize access="isAnonymous()">
                					<a href="/profile"><span class="btn btn-success">Login</span></a>
                					<a href="/getRegister"><span class="btn btn-success">Register</span></a>
                				</sec:authorize>
                				<sec:authorize access="isAuthenticated()">
                					<a href="/profile"><span class="btn btn-success">My Profile</span></a>
                					<a href="/logout"><span class="btn btn-success">Log Out</span></a>
                				</sec:authorize>
              
              					<a href="#" data-toggle="modal" data-target="#myModalPostAd"><span class="btn btn-post-ad">POST AD</span></a>
              				</form>
            			</div>
          			</div><!-- /.container-fluid -->
        		</nav>
      		</div>

      		<div id="container">
				<div id="jumbotron" style="padding-top: 0px;">
					<div class="progress">
			  			<div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
					</div>
			
					<div class="row" id="searchrow">
	          			<div class="col-sm-1 search-panel-city">
                			<div class="form-group">
                        		<select class="form-control" id="browseRoomLookingInCity" name="browseRoomLookingInCity">
			                		<option value="Pune">Pune</option>
					                <option value="Mumbai">Mumbai</option>
					                <option value="Delhi">Delhi</option>
					                <option value="Gurgaon">Gurgaon</option>
					                <option value="Noida">Noida</option>
					                <option value="Banglore">Banglore</option>
					                <option value="Hyderabad">Hyderabad</option>
					                <option value="Chennai">Chennai</option>
              					</select>
                			</div>
	          			</div>
				
						<div class="col-sm-2 search-panel">
		            		<fieldset>
		              			<div class="search-group">
		                			<input type="text" placeholder="Search by area in ur city..." value="${room.roomAreaInCity}" autocomplete="off" class="form-control" id="browseRoomLocation" name="browseRoomLocation">
		              			</div>
		            		</fieldset>
		          		</div>

			          	<div class="col-sm-2 search-panel">
							<div class="form-group">
		                    	<div id="gender" class="btn-group" data-toggle="buttons">
		                      		<label class="btn btn-default btn-input"><input type="radio" name="browseRoomMateGender" id="Male" value="Male"> Male</label>
		                  			<label class="btn btn-default btn-input"><input type="radio" name="browseRoomMateGender" id="Female" value="Female"> Female</label>
		                      	</div>
		                  	</div>
			          	</div>
		
			          	<div class="col-sm-3 search-panel">
							<div class="form-group">
		                    	<div id="gender" class="btn-group" data-toggle="buttons">
		                      		<label class="btn btn-default btn-input"><input type="radio" name="browseRoomPropertyType" id="PG" value="PG"> PG</label>
		                  			<label class="btn btn-default btn-input"><input type="radio" name="browseRoomPropertyType" id="Flat" value="Flat"> Flat</label>
		                  			<label class="btn btn-default btn-input"><input type="radio" name="browseRoomPropertyType" id="Bunglow" value="Bunglow"> Bunglow</label>
		                      	</div>
		                  	</div>
			          	</div>
			          	
			          	<div class="col-sm-2 search-panel">
		                	<div class="form-group">
		                        <select class="form-control" id="browseRoomMonthlyRent" name="browseRoomMonthlyRent">
		                        	<option value="">Monthly Rent</option>
		                        	<option value="0-2000">Less than Rs 2000</option>
					                <option value="2000-3000">Rs 2000-3000</option>
					                <option value="3000-4000">Rs 3000-4000</option>
					                <option value="4000-5000">Rs 4000-5000</option>
					                <option value="5000-6000">Rs 5000-6000</option>
					                <option value="6000-9999999">Greater than Rs 6000</option>
		              			</select>
		                	</div>
			          	</div>
		
			          	<div class="col-sm-2 search-panel" style="float: right;">
							<div class="btn-group">
		  						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-th"></span> Grid</button>
		  						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-map-marker"></span> Map</button>
							</div>
			          	</div>
					</div>

            		<div id="jumbotronRight" style="width: 100%">
              			<div id="gridView" class="row">
              			
	              			<c:if test="${myRoomListingList == null}">
	            				<h5>No rooms found for your search. Would you like to <a href="/browseRooms">Browse all Rooms</a></h5>
	            			</c:if>
              			
							<c:forEach items="${myRoomListingList}" var="room">
		          			<a href="/viewRoom?param=${room.userEmail}">
		            			<div class="col-sm-6 col-md-4">
		              				<div class="thumbnail">
		                				<img src="${room.roomListingImage1}">
		                				<div class="caption">
		                  					<p class="post-name"><b>${room.roomHeadLine}</b></p>
		                  					<p class="post-summary">${room.roomInCity}</p>
		                  					<p class="post-budget">Monthly Rent : ${room.monthlyRent} INR</p>
		                  					<p class="post-move-in-date">Available from: ${room.availableFromDate}</p>
		                				</div>
		              				</div>
		            			</div>
		          			</a>
		        			</c:forEach>
              			</div>

              			<div id="mapView">
              			</div>
            		</div><!--jumbotronRight ends-->
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
    	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
    	<script type="text/javascript" src="../js/scripts.js"></script>
    	<script src="js/ajax.js" type="text/javascript"></script>
		<script type="text/javascript">
			//AJAX bind call for ajax initialization...
			var ajax = new ROOM.AJAX();	
		</script>    

		<script src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>

		<script type="text/javascript">
			function initialize() {
    			var input = document.getElementById('browseRoomLocation');
    			var options = {componentRestrictions: {country: 'in'}};     
    			new google.maps.places.Autocomplete(input, options);
			}
        	google.maps.event.addDomListener(window, 'load', initialize);
		</script>
 	</body>
</html>