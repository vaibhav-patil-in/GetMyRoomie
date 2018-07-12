<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>${roomMateList.profileHeadLine} | ${roomMateList.lookingforArea} | ${roomMateList.monthlyBudget} INR | GetmyRoomie.com</title>
	    <meta name="description" content="${roomMateList.userAboutMe}">
	
		<meta name="robots" content="index,follow,noodp,noydir" />
		<meta name="google" value="notranslate" />

		<!-- Facebook Open Graph -->
		<meta property="fb:app_id" content="800502593346624"/>
		<meta property="og:site_name" content="GetmyRoomie">
		<meta property="og:title" content="${roomMateList.profileHeadLine} | ${roomMateList.lookingforArea} | ${roomMateList.monthlyBudget} INR | GetmyRoomie.com">
		<meta property="og:description" content="${roomMateList.userAboutMe}">
		<meta property="og:type" content="website" />
		<meta property="og:url" content="http://www.getmyroomie.com/viewRoommate?param=${roomMateList.userEmail}" />
		<meta property="og:image" content="http://www.getmyroomie.com/images/GetMyRoomie.png">
		<meta property="og:image:type" content="image/png">
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
          			</div><!-- /.container-fluid -->
        		</nav>
      		</div>

      		<div id="container">
        		<div class="tab-content">
          			<div class="tab-pane active" id="Inbox" style="border-top: 1px solid #ddd; margin-left: 10.45%; margin-right: 10.75%;">

              			<div class="page-header" style="margin:0px">
                  			<!-- <a href="/shortList?listingType=roomMate&param=${roomMateList.userEmail}"><span class="btn btn-default">Shortlist <span class="glyphicon glyphicon-heart"></span></span></a>  -->
                  			<a href="/getMessagePage?param=${roomMateList.userEmail}&msgSubject=${roomMateList.profileHeadLine}"><span class="btn btn-success">Message <span class="glyphicon glyphicon-envelope"></span></span></a>
                  			<div class="fb-like" data-href="http://www.getmyroomie.com/viewRoommate?param=${roomMateList.userEmail}" data-layout="button_count" data-action="like" data-share="true"></div>
              			</div>

              			<div class="page-header" style="margin:0px">
                  			<h4>${roomMateList.profileHeadLine}</h4>
                  			<h5>Move in date ${roomMateList.moveInDate}</h5>
              			</div>

              			<div class="row">
                			<div class="col-sm-6 col-md-4" id="userDetail">
	                  			<div class="thumbnail">
	                    			<img src="${roomMateList.profileImage}">
	                    			<div class="caption">
	                      				<p class="post-name text-center"><b>${roomMateList.userName}</b></p>
	                      				<p class="post-budget-normal">Budget<span class="pull-right text-center"><b>${roomMateList.monthlyBudget} INR</b></span></p>
	                      				<p class="post-budget-normal">Gender<span class="pull-right text-center"><b>${roomMateList.userGender}</b></span></p>
	                      				<p class="post-budget-normal">Occupation<span class="pull-right text-center"><b>${roomMateList.userOccupation}</b></span></p>
	                      				<p class="post-budget-normal">Smoking<span class="pull-right text-center"><b>${roomMateList.userSmoke}</b></span></p>
	                      				<p class="post-budget-normal">Pets<span class="pull-right text-center"><b>${roomMateList.userHavePets}</b></span></p>
	                      				<p class="post-budget-normal">Drinking<span class="pull-right text-center"><b>${roomMateList.userDrink}</b></span></p>
	                    			</div>
	                  			</div>
                			</div>

                			<div class="col-sm-6 col-md-4" id="articleDetail">
                  				<article class="articleroom">
                      				<div class="col-md-12">
                          				<h3 class="description-header">About Me</h3>
                          				<div class="readable-description">
                              				<p style="position: absolute"></p><p>${roomMateList.userAboutMe}</p><p></p>
                          				</div>
                      				</div>

                      				<div class="col-md-12">
                          				<h3 class="description-header">City looking for</h3>
                          				<div class="readable-description">
                            				<span>${roomMateList.lookingInCity}</span>
                          				</div>
                      				</div>

                      				<div class="col-md-12">
                          				<h3 class="description-header">Preferred Neighbourhoods</h3>
                          				<div class="readable-description">
                            				<span>${roomMateList.lookingforArea}</span>
                          				</div>
                      				</div>
                      
                      				<c:if test="${roomMateList.showUserMobileNumber eq 'Yes'}">
                      				<div class="col-md-12">
                          				<h3 class="description-header">Mobile number</h3>
                          				<div class="readable-description">
                            				<span>${roomMateList.userMobileNumber}</span>
                          				</div>
                      				</div>
                      				</c:if>
                  				</article>
                			</div>
                			
                			<div class="col-sm-6 col-md-4" id="matePreferenceDetail">
                  				<div class="thumbnail">
                    				<div class="caption">
                      					<p class="post-name"><b>Roommate Preference</b></p>
                      					<p class="post-budget-normal">Gender<span class="pull-right text-center"><b>${roomMateList.mateGender}</b></span></p>
                      					<p class="post-budget-normal">Occupation<span class="pull-right text-center"><b>${roomMateList.mateOccupation}</b></span></p>
				                      	<p class="post-budget-normal">Pets Accepted<span class="pull-right text-center"><b>${roomMateList.matePetsAllowed}</b></span></p>
				                      	<p class="post-budget-normal">Drinkers Accepted<span class="pull-right text-center"><b>${roomMateList.mateDrinkingAllowed}</b></span></p>
				                      	<p class="post-budget-normal">Smokers Accepted<span class="pull-right text-center"><b>${roomMateList.mateSmokingAllowed}</b></span></p>
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