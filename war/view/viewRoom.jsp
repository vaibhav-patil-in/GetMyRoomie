<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>${roomList.roomHeadLine} | ${roomList.roomAreaInCity} | ${roomList.monthlyRent} INR | GetmyRoomie.com</title>
	    <meta name="description" content="Available from ${roomList.availableFromDate}. ${roomList.aboutRoom}. ${roomList.roomAmenities}">
	
		<meta name="robots" content="index,follow,noodp,noydir" />
		<meta name="google" value="notranslate" />
	
		<!-- Facebook Open Graph -->
		<meta property="fb:app_id" content="800502593346624"/>
		<meta property="og:site_name" content="GetmyRoomie">
		<meta property="og:title" content="${roomList.roomHeadLine} | ${roomList.roomAreaInCity} | ${roomList.monthlyRent} INR | GetmyRoomie.com">
		<meta property="og:description" content="Available from ${roomList.availableFromDate}. ${roomList.aboutRoom}. ${roomList.roomAmenities}">
		<meta property="og:url" content="http://www.getmyroomie.com/viewRoom?param=${roomList.userEmail}" />
		<meta property="og:image" content="http://www.getmyroomie.com/images/GetMyRoomie.png">
		<meta property="og:image:type" content="image/png">
		<meta property="og:type" content="website" />
		<!-- Facebook Open Graph -->

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

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
		
		<div="mainContainer">
    
      		<!-- Post Ad modal -->
      		<%@ include file="lightbox/postad_lightbox.jsp"%>
      		<!-- Post Ad modal ends -->
      		
      		<!-- Room image see modal -->
      		<%@ include file="lightbox/roomView_lightbox.jsp"%>
      		<!-- Room image see ends -->

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
	                			<a href="/getRegister"><span class="btn btn-success">Register</span></a>
	                			</sec:authorize>
	                			<sec:authorize access="isAuthenticated()">
	                			<a href="/profile"><span class="btn btn-success">My Profile</span></a>
	                			<a href="/logout"><span class="btn btn-success">Log Out</span></a>
	                			</sec:authorize>
	                			<a href="#" data-toggle="modal" data-target="#myModalPostAd"><span class="btn btn-post-ad">POST AD</span></a>
              				</form>
            			</div>
          			</div>
        		</nav>
      		</div>

      		<div id="container">

        		<div class="tab-content">
          			<div class="tab-pane active" id="Inbox" style="border-top: 1px solid #ddd; margin-left: 10.45%; margin-right: 10.75%;">
              			<div class="page-header" style="margin:0px">
                  			<!-- <a href="/shortList?listingType=room&param=${roomList.userEmail}"><span class="btn btn-default">Shortlist <span class="glyphicon glyphicon-heart"></span></span></a>  -->
                  			
                  			<a href="/getMessagePage?param=${roomList.userEmail}&msgSubject=${roomList.roomHeadLine}"><span class="btn btn-success">Message <span class="glyphicon glyphicon-envelope"></span></span></a>
                  			
                  			<div class="fb-like" data-href="http://www.getmyroomie.com/viewRoom?param=${roomList.userEmail}" data-layout="button_count" data-action="like" data-share="true"></div>
                  			
              			</div>
              			<div class="page-header" style="margin:0px">
                  			<h4>${roomList.roomHeadLine}</h4>
                  			<h5>Available from ${roomList.availableFromDate}</h5>
              			</div>
              			
              			<div class="row">
                		
                			<div class="col-sm-6 col-md-4" id="userDetail">
                  				<div class="thumbnail">
                    				<img src="${roomList.userProfileimage}">
                    				<div class="caption">
                      					<p class="post-name text-center"><b>${roomList.userName}</b></p>
                      					<p class="post-budget-normal">Monthly Rent<span class="pull-right text-center"><b>${roomList.monthlyRent} INR</b></span></p>
                      					<p class="post-budget-normal">Gender<span class="pull-right text-center"><b>${roomList.userGender}</b></span></p>
                      					<p class="post-budget-normal">Occupation<span class="pull-right text-center"><b>${roomList.userOccupation}</b></span></p>
                      					<p class="post-budget-normal">I am<span class="pull-right text-center"><b>${roomList.roomRelation}</b></span></p>
                    				</div>
                  				</div>
                			</div>

                			<div class="col-sm-6 col-md-4" id="articleDetail">
                  				<article class="articleroom">
                      				<div class="col-md-12">
                          				<h3 class="description-header">About Room</h3>
                          				<div class="readable-description">
                              				<p style="position: absolute"></p><p>${roomList.aboutRoom}</p><p></p>
                          				</div>
                      				</div>
                      				
                      				<div class="col-md-12">
                          				<h3 class="description-header">City</h3>
                          				<div class="readable-description">
                            				<span>${roomList.roomInCity}</span>
                          				</div>
                      				</div>

                      				<div class="col-md-12">
                          				<h3 class="description-header">Neighbourhoods</h3>
                          				<div class="readable-description">
                            				<span>${roomList.roomAreaInCity}</span>
                          				</div>
                      				</div>

					  				<c:if test="${roomList.showUserMobileNumber eq 'Yes'}">
                      				<div class="col-md-12">
                          				<h3 class="description-header">Mobile number</h3>
                          				<div class="readable-description">
                            				<span>${roomList.userMobileNumber}</span>
                          				</div>
                      				</div>
                      				</c:if>

                      				<div class="col-md-12">
                          				<h3 class="description-header">Room Amenities</h3>
                          				<div class="readable-description">
                            				<span class="label label-info">${roomList.roomAmenities}</span>
                          				</div>
                      				</div>
                      				
                      				<div class="col-md-12">
                          				<h3 class="description-header">Room Pictures</h3>
                  						<div class="thumbnail">
									   		<ul class="row">
									   			<c:if test="${roomList.roomListingImage1 ne ''}">
									       		<li class="col-sm-4"><img src="${roomList.roomListingImage1}"/></li>
									       		</c:if>
									       		<c:if test="${roomList.roomListingImage2 ne ''}">
									       		<li class="col-sm-4"><img src="${roomList.roomListingImage2}"/></li>
									       		</c:if>
									       		<c:if test="${roomList.roomListingImage3 ne ''}">
									       		<li class="col-sm-4"><img src="${roomList.roomListingImage3}"/></li>
									       		</c:if>
									       		<c:if test="${roomList.roomListingImage4 ne ''}">
									       		<li class="col-sm-4"><img src="${roomList.roomListingImage4}"/></li>
									       		</c:if>
									       		<c:if test="${roomList.roomListingImage5 ne ''}">
									       		<li class="col-sm-4"><img src="${roomList.roomListingImage5}"/></li>
									       		</c:if>
									       		<c:if test="${roomList.roomListingImage6 ne ''}">
									       		<li class="col-sm-4"><img src="${roomList.roomListingImage6}"/></li>
									       		</c:if>
									   		</ul>
										</div>
                      				</div>
                      				
                  				</article>

                			</div>

                			<div class="col-sm-6 col-md-4" id="matePreferenceDetail">
                  				<div class="thumbnail">
                    				<div class="caption">
                      					<p class="post-name"><b>Roommate Preference</b></p>
                      					<p class="post-budget-normal">Gender<span class="pull-right text-center"><b>${roomList.mateGender}</b></span></p>
                      					<p class="post-budget-normal">Occupation<span class="pull-right text-center"><b>${roomList.mateOccupation}</b></span></p>
                      					<p class="post-budget-normal">Pets Accepted<span class="pull-right text-center"><b>${roomList.matePetsAllowed}</b></span></p>
                      					<p class="post-budget-normal">Drinkers Accepted<span class="pull-right text-center"><b>${roomList.mateDrinkingAllowed}</b></span></p>
                      					<p class="post-budget-normal">Smokers Accepted<span class="pull-right text-center"><b>${roomList.mateSmokingAllowed}</b></span></p>
                      					<p class="post-budget-normal">Prefer to Live with<span class="pull-right text-center"><b>${roomList.matePreferToLiveWith}</b></span></p>
                    				</div>
                  				</div>
                  				
                  				<div class="thumbnail">
                    				<div class="caption">
                      					<p class="post-name"><b>Room key details</b></p>
                      					<p class="post-budget-normal">Minimum Stay<span class="pull-right text-center"><b>${roomList.minimumStay} Month</b></span></p>
                      					<p class="post-budget-normal"># of Bedrooms<span class="pull-right text-center"><b>${roomList.numberOfRooms}</b></span></p>
                      					<p class="post-budget-normal"># of Housemates<span class="pull-right text-center"><b>${roomList.numberOfRoomMates}</b></span></p>
                      					<p class="post-budget-normal">Property Type<span class="pull-right text-center"><b>${roomList.propertyType}</b></span></p>
                      					<p class="post-budget-normal">Accomodates<span class="pull-right text-center"><b>${roomList.roomAccomodates}</b></span></p>
                      					<p class="post-budget-normal">Furnishing Type<span class="pull-right text-center"><b>${roomList.roomFurnishingType}</b></span></p>
                      					<p class="post-budget-normal">Cooking At home<span class="pull-right text-center"><b>${roomList.cookingAtHome}</b></span></p>
                      					<p class="post-budget-normal">Pets Present<span class="pull-right text-center"><b>${roomList.arePetsInHouse}</b></span></p>
                      					<p class="post-budget-normal">Drinkers Present<span class="pull-right text-center"><b>${roomList.areDrinkersInHouse}</b></span></p>
                      					<p class="post-budget-normal">Smokers Present<span class="pull-right text-center"><b>${roomList.areSmokersInHouse}</b></span></p>
                    				</div>
                  				</div>
                			</div>
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