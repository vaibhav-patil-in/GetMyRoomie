<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Manage active listing | GetmyRoomie.com</title>
	    <meta name="description" content="Awesome roommates, Awesome rooms, great apartments, cool people, room, roommate. The best way to find rooms and roommates in India for free." />
	
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
	                			<a href="/browseRoomMates"><span class="btn btn-success">Roommates <span class="glyphicon glyphicon-user"></span></span></a>
	                			<a href="/browseRooms"><span class="btn btn-success">Rooms <span class="glyphicon glyphicon-home"></span></span></a>
	                			<a href="/profile"><span class="btn btn-success">My Profile</span></a>
	                			<a href="/logout"><span class="btn btn-success">Log Out</span></a>
	              			</form>
	            		</div>
          			</div><!-- /.container-fluid -->
        		</nav>
      		</div>

      		<div id="container">
        		<ul class="nav nav-tabs">
          			<li><a href="/profile"><span class="glyphicon glyphicon-user"></span> About Me</a></li>
          			<li><a href="/profileNeedARoom"><span class="glyphicon glyphicon-user"></span> Need a room</a></li>
          			<li><a href="/profileListARoom"><span class="glyphicon glyphicon-home"></span> List a room</a></li>
          			<li class="active"><a href="/profileMyListing"><span class="glyphicon glyphicon-list"></span> My Listings</a></li>
          			<li><a href="/profileMyShortList"><span class="glyphicon glyphicon-heart"></span> My Shortlist</a></li>
          			<li><a href="/profileMessages"><span class="glyphicon glyphicon-inbox"></span> Inbox <span class="badge">${messageCount}</span></a></li>
        		</ul>

        		<div class="tab-content">
          			<div class="tab-pane active" id="MyListing">
            			
            			<div class="row">
            			
            				<div class="listing-header">          
								<span>Listings</span>
							</div>

							<c:if test="${myMateListing == null && myRoomListing == null}">
            					<h4>You have not listed anything.</h4>
            				</c:if>

              				<c:if test="${myMateListing != null}">
              				<div class="col-sm-6 col-md-4" style="width:50%">
                				<div class="thumbnail">
                  					<img src="${myMateListing.profileImage}">
                  					<div class="caption">
                    					<p class="post-name"><b>${myMateListing.userName}</b></p>
                    					<p class="post-summary">${myMateListing.profileHeadLine}</p>
                    					<p class="post-budget">Monthly Budget : ${myMateListing.monthlyBudget} INR</p>
                    					<p class="post-move-in-date">Move in date: ${myMateListing.moveInDate}</p>
                    
                    					<div class="editSection">
                      						<a href="/viewRoommate?param=${myMateListing.userEmail}" class="label label-info listing-button">View</a>
                      						<a href="/profileNeedARoom" class="label label-info listing-button">Edit</a>
                      						
                      						<c:if test="${myMateListing.mateListStatus eq 'DEACTIVE'}">
                      						<a href="/activateMateListing" class="label label-info listing-button">Activate</a>
                      						</c:if>
                      							
                      						<c:if test="${myMateListing.mateListStatus eq 'ACTIVE'}">
                      						<a href="/deActivateMateListing" class="label label-info listing-button">Deactivate</a>
                      						</c:if>
                      						<a href="#" class="label label-info listing-button">Share</a>
                    					</div>
                  					</div>
                				</div>
              				</div>
              				</c:if>

			  				<c:if test="${myRoomListing != null}">
              				<div class="col-sm-6 col-md-4" style="width:50%">
                				<div class="thumbnail">
                  					<img src="${myRoomListing.roomListingImage1}">
                  					<div class="caption">
                    					<p class="post-name"><b>${myRoomListing.roomHeadLine}</b></p>
                    					<p class="post-summary">${myRoomListing.roomInCity}</p>
                    					<p class="post-budget">Monthly Rent : ${myRoomListing.monthlyRent} INR</p>
                    					<p class="post-move-in-date">Available from: ${myRoomListing.availableFromDate}</p>
                    					
                    					<div class="editSection">
                      						<a href="/viewRoom?param=${myRoomListing.userEmail}" class="label label-info listing-button">View</a>
                      						<a href="/profileListARoom" class="label label-info listing-button">Edit</a>
                      						<c:if test="${myRoomListing.roomListStatus eq 'DEACTIVE'}">
                      						<a href="/activateRoomListing" class="label label-info listing-button">Activate</a>
                      						</c:if>
                      						<c:if test="${myRoomListing.roomListStatus eq 'ACTIVE'}">
                      						<a href="/deActivateRoomListing" class="label label-info listing-button">Deactivate</a>
                      						</c:if>
                      						<a href="#" class="label label-info listing-button">Share</a>
                    					</div>
                  					</div>
                				</div>
              				</div>
              				</c:if>
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
    	<script src="js/bootstrap.js"></script>
    	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
    	<script type="text/javascript" src="../js/scripts.js"></script>
  	</body>
</html>