<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Find Awesome Roommates | GetmyRoomie.com</title>
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
  </head>
  <body>

    <div="mainContainer">

      <!-- Login modal -->
      <%@ include file="../lightbox/about_lightbox.jsp"%>
      <!-- Login modal ends -->
      
      <!-- Post Ad modal -->
      <%@ include file="../lightbox/postad_lightbox.jsp"%>
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

				<a href="/browseRooms"><span class="btn btn-success">Browse Rooms <span class="glyphicon glyphicon-home"></span></span></a>
                <!-- <a href="/profileNeedARoom"><span class="btn btn-success">Need a Room <span class="glyphicon glyphicon-user"></span></span></a>
                <a href="/profileListARoom"><span class="btn btn-success">List your Room <span class="glyphicon glyphicon-home"></span></span></a>  -->

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
            </div><!-- /.navbar-collapse -->

          </div><!-- /.container-fluid -->
        </nav>
      </div>

      <div id="container">

        <div id="jumbotron">

            <div id="jumbotronLeft">

              <div class="panel-group" id="accordion">

                <div class="panel panel-default">
                  <div class="panel-heading">
                    <h4 class="panel-title">
                      <a data-toggle="collapse" data-parent="#accordion" href="#">
                        Search Room mates
                      </a>
                    </h4>
                  </div>
                  <div id="collapseRoommate" class="panel-collapse collapse in">
                    <div class="panel-body">

                      <form role="Search" action="/searchRoommate" method="POST">
                        
                        <div class="form-group">
                          <label for="city">City</label>
                          <select class="form-control" id="lookingInCity" name="lookingInCity">
			              	<option <c:if test="${roommate.lookingInCity eq ''}">selected</c:if> value="">Select a city</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Pune'}">selected</c:if> value="Pune">Pune</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Mumbai'}">selected</c:if> value="Mumbai">Mumbai</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Delhi'}">selected</c:if> value="Delhi">Delhi</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Gurgaon'}">selected</c:if> value="Gurgaon">Gurgaon</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Hyderabad'}">selected</c:if> value="Hyderabad">Hyderabad</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Banglore'}">selected</c:if> value="Banglore">Banglore</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Noida'}">selected</c:if> value="Noida">Noida</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Ghaziabad'}">selected</c:if> value="Ghaziabad">Ghaziabad</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Chennai'}">selected</c:if> value="Chennai">Chennai</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Feridabad'}">selected</c:if> value="Feridabad">Feridabad</option>
			                <option <c:if test="${roommate.lookingInCity eq 'Nasik'}">selected</c:if> value="Nasik">Nasik</option>
                		</select>
                        </div>

                        <div class="form-group">
                          <label for="neighbourhoods">Neighbourhoods</label>
                          <input type="text" class="form-control form-locality-area" value="${roommate.lookingforArea}" id="lookingforArea" name="lookingforArea" placeholder="Enter area or locality" autocomplete="off">
                        </div>

                        <!-- <div class="form-group">
                          <label for="numberOfHouseMates">Postal Code</label>
                          <input type="number" class="form-control" id="postalCode" placeholder="0">
                        </div> -->

                        <div class="form-group">
                          <label for="gender">Gender</label>
                          <div id="gender" class="btn-group-sm" data-toggle="buttons">
                            <label class="btn btn-default btn-input <c:if test="${roommate.userGender eq 'Male'}">active</c:if>"><input type="radio" name="userGender" id="Male" value="Male" <c:if test="${roommate.userGender eq 'Male'}">checked</c:if>> Male</label>
                  			<label class="btn btn-default btn-input <c:if test="${roommate.userGender eq 'Female'}">active</c:if>"><input type="radio" name="userGender" id="Female" value="Female" <c:if test="${roommate.userGender eq 'Female'}">checked</c:if>> Female</label>
                          </div>
                        </div>
                    
                        <div class="form-group">
                          <label for="occupation">Occupation</label>
                          <div id="occupation" class="btn-group-sm" data-toggle="buttons">
                            <label class="btn btn-default btn-input <c:if test="${roommate.userOccupation eq 'Professional'}">active</c:if>"><input type="radio" name="userOccupation" id="Professional" value="Professional" <c:if test="${roommate.userOccupation eq 'Professional'}">checked</c:if>> Professional</label>
                  			<label class="btn btn-default btn-input <c:if test="${roommate.userOccupation eq 'Student'}">active</c:if>"><input type="radio" name="userOccupation" id="Student" value="Student" <c:if test="${roommate.userOccupation eq 'Student'}">checked</c:if>> Student</label>
                          </div>
                        </div>
                        
                        <div class="form-group">
                          <label for="monthlyBudget">Monthly Budget(In INR)</label>
                          <input type="text" class="form-control" value="${roommate.monthlyBudget}" id="monthlyBudget" name="monthlyBudget" placeholder="Monthly budget">
                        </div>
                        <button type="submit" class="btn btn-primary">Search <span class="glyphicon glyphicon-search"></span></button>

                      </form>
                    </div>
                  </div>
                </div>
              </div>

            </div><!--jumbotronleft ends-->


            <div id="jumbotronRight">

              <div class="row">
		        
				<c:forEach items="${myMateListingList}" var="roomMate">
		          <a href="/viewRoommate?param=${roomMate.userEmail}">
		            <div class="col-sm-6 col-md-4">
		              <div class="thumbnail">
		                <img src="${roomMate.profileImage}">
		                <div class="caption">
		                  <p class="post-name"><b>${roomMate.userName}</b></p>
		                  <p class="post-summary">${roomMate.profileHeadLine}</p>
		                  <p class="post-budget">Monthly Budget : ${roomMate.monthlyBudget} INR</p>
		                  <!-- <p class="post-move-in-date">Move in date : ${roomMate.moveInDate}</p>  -->
		                </div>
		              </div>
		            </div>
		          </a>
		        </c:forEach>

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
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/bootstrapValidator.js"></script>
    <script type="text/javascript" src="../js/scripts.js"></script>  
    <script src="js/ajax.js" type="text/javascript"></script>
	<script type="text/javascript">
		//AJAX bind call for ajax initialization...
		var ajax = new ROOM.AJAX();	
	</script>    
    
  </body>
</html>