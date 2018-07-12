<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>I need a room | GetmyRoomie.com</title>
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
          			<li class="active"><a href="/profileNeedARoom"><span class="glyphicon glyphicon-user"></span> Need a room</a></li>
          			<li><a href="/profileListARoom"><span class="glyphicon glyphicon-home"></span> List a room</a></li>
          			<li><a href="/profileMyListing"><span class="glyphicon glyphicon-list"></span> My Listings</a></li>
          			<li><a href="/profileMyShortList"><span class="glyphicon glyphicon-heart"></span> My Shortlist</a></li>
          			<li><a href="/profileMessages"><span class="glyphicon glyphicon-inbox"></span> Inbox <span class="badge">${messageCount}</span></a></li>
        		</ul>

        		<div class="tab-content">
          			<div class="tab-pane active" id="NeedARoom">

						<form role="form" action="/${action}" method="POST" id="profileNeedARoomForm">

							<div class="row" id="roomRequiredDetails">

								<div class="wizard-progress-steps">
    								<a class="current"><span class="badge badge-inverse">1</span>Details</a>
    								<a><span class="badge">2</span> Roommate Preferences</a>
								</div>
								<!-- <div class="listing-header">          
									<span>Details</span>
								</div>  -->

								<div class="col-sm-8 col-md-7">

              						<div class="form-group">
                						<label for="profileHeadLine">Profile Headeline</label>
                						<input type="text" class="form-control" value="${roomMate.profileHeadLine}" id="profileHeadLine" name="profileHeadLine" placeholder="Software engineer looking for house hold near Shivaji Nagar">
              						</div>

              						<div class="form-group">
                						<label for="city">City</label>
                						<select class="form-control" id="lookingInCity" name="lookingInCity">
						                	<option <c:if test="${roomMate.lookingInCity eq ''}">selected</c:if> value="">Select city</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Pune'}">selected</c:if> value="Pune">Pune</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Mumbai'}">selected</c:if> value="Mumbai">Mumbai</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Delhi'}">selected</c:if> value="Delhi">Delhi</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Gurgaon'}">selected</c:if> value="Gurgaon">Gurgaon</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Noida'}">selected</c:if> value="Noida">Noida</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Banglore'}">selected</c:if> value="Banglore">Banglore</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Hyderabad'}">selected</c:if> value="Hyderabad">Hyderabad</option>
						                  	<option <c:if test="${roomMate.lookingInCity eq 'Chennai'}">selected</c:if> value="Chennai">Chennai</option>
                						</select>
              						</div>

              						<div class="form-group">
                						<label for="neighbourhoods">Preferred Neighbourhoods</label>
                						<input type="text" class="form-control" id="lookingforArea" name="lookingforArea" value="${roomMate.lookingforArea}" placeholder="Select some options" autocomplete="off">
              						</div>

              						<div class="form-group">
                						<label for="months">Renting for(In Months)</label>
                						<select class="form-control" id="rentingForMonth" name="rentingForMonth">
						                	<option <c:if test="${roomMate.rentingForMonth eq '1'}">selected</c:if> value="1">1 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '2'}">selected</c:if> value="2">2 Month</option>
						              		<option <c:if test="${roomMate.rentingForMonth eq '3'}">selected</c:if> value="3">3 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '4'}">selected</c:if> value="4">4 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '5'}">selected</c:if> value="5">5 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '6'}">selected</c:if> value="6">6 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '7'}">selected</c:if> value="7">7 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '8'}">selected</c:if> value="8">8 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '9'}">selected</c:if> value="9">9 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '10'}">selected</c:if> value="10">10 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '11'}">selected</c:if> value="11">11 Month</option>
						                  	<option <c:if test="${roomMate.rentingForMonth eq '12'}">selected</c:if> value="12">12 Month</option>
                						</select>
              						</div>

              						<div class="form-group">
                						<label for="monthlyBudget">Budget(In INR)</label>
                						<input type="text" class="form-control" value="${roomMate.monthlyBudget}" id="monthlyBudget" name="monthlyBudget" placeholder="Budget">
              						</div>

              						<div class="form-group">
                						<label for="moveInDate">Move in date(dd-MM-yyyy)</label>
                						<input data-format="dd-MM-yyyy" type="date" value="${roomMate.moveInDate}" id="moveInDate" name="moveInDate" class="form-control">
              						</div>
              						
              						<a class="btn btn-primary" style="font-size: 15px;" id="roomRequiredDetailsNext">Next >></a>
              					</div>
            				</div>
            
            				<div class="row display-none" id="roomMatePreferences">
            				
            					<div class="wizard-progress-steps">
    								<a class="current"><span class="badge badge-inverse">1</span>Details</a>
    								<a class="current"><span class="badge badge-inverse">2</span> Roommate Preferences</a>
								</div>
								<!-- <div class="listing-header">          
									<span>Roommate Preferences</span>
								</div>  -->

              					<div class="form-group">
                					<label for="gender">Gender</label>
                					<div id="gender" class="btn-group-sm" data-toggle="buttons">
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateGender eq 'Male'}">active</c:if>"><input type="radio" name="mateGender" id="Male" value="Male" <c:if test="${roomMate.mateGender eq 'Male'}">checked</c:if>> Male</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateGender eq 'Female'}">active</c:if>"><input type="radio" name="mateGender" id="Female" value="Female" <c:if test="${roomMate.mateGender eq 'Female'}">checked</c:if>> Female</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateGender eq 'NoPreference'}">active</c:if>"><input type="radio" name="mateGender" id="NoPreference" value="NoPreference" <c:if test="${roomMate.mateGender eq 'NoPreference'}">checked</c:if>> No Preference</label>
                					</div>
              					</div>
              
              					<div class="form-group">
                					<label for="occupation">Occupation</label>
                					<div id="occupation" class="btn-group-sm" data-toggle="buttons">
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateOccupation eq 'Professional'}">active</c:if>"><input type="radio" name="mateOccupation" id="Professional" value="Professional" <c:if test="${roomMate.mateOccupation eq 'Professional'}">checked</c:if>> Professional</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateOccupation eq 'Student'}">active</c:if>"><input type="radio" name="mateOccupation" id="Student" value="Student" <c:if test="${roomMate.mateOccupation eq 'Student'}">checked</c:if>> Student</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateOccupation eq 'NoPreference'}">active</c:if>"><input type="radio" name="mateOccupation" id="NoPreference" value="NoPreference" <c:if test="${roomMate.mateOccupation eq 'NoPreference'}">checked</c:if>> No Preference</label>
                					</div>
              					</div>

              					<div class="form-group">
                					<label for="petsOkay">Pets Okay?</label>
                					<div id="petsOkay" class="btn-group-sm" data-toggle="buttons">
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.matePetsAllowed eq 'Okay'}">active</c:if>"><input type="radio" name="matePetsAllowed" id="Okay" value="Okay" <c:if test="${roomMate.matePetsAllowed eq 'Okay'}">checked</c:if>> Okay</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.matePetsAllowed eq 'NotOkay'}">active</c:if>"><input type="radio" name="matePetsAllowed" id="NotOkay" value="NotOkay" <c:if test="${roomMate.matePetsAllowed eq 'NotOkay'}">checked</c:if>> Not Okay</label>
                					</div>
              					</div>

              					<div class="form-group">
                					<label for="drinkerOkay">Drinker Okay?</label>
                					<div id="drinkerOkay" class="btn-group-sm" data-toggle="buttons">
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateDrinkingAllowed eq 'Okay'}">active</c:if>"><input type="radio" name="mateDrinkingAllowed" id="Okay" value="Okay" <c:if test="${roomMate.mateDrinkingAllowed eq 'Okay'}">checked</c:if>> Okay</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateDrinkingAllowed eq 'NotOkay'}">active</c:if>"><input type="radio" name="mateDrinkingAllowed" id="NotOkay" value="NotOkay" <c:if test="${roomMate.mateDrinkingAllowed eq 'NotOkay'}">checked</c:if>> Not Okay</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateDrinkingAllowed eq 'NotInTheHouse'}">active</c:if>"><input type="radio" name="mateDrinkingAllowed" id="NotInTheHouse" value="NotInTheHouse" <c:if test="${roomMate.mateDrinkingAllowed eq 'NotInTheHouse'}">checked</c:if>> Not In The House</label>
                					</div>
              					</div>

              					<div class="form-group">
                					<label for="smokersOkay">Smokers okay?</label>
                					<div id="smokersOkay" class="btn-group-sm" data-toggle="buttons">
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateSmokingAllowed eq 'Okay'}">active</c:if>"><input type="radio" name="mateSmokingAllowed" id="Okay" value="Okay" <c:if test="${roomMate.mateSmokingAllowed eq 'Okay'}">checked</c:if>> Okay</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateSmokingAllowed eq 'NotOkay'}">active</c:if>"><input type="radio" name="mateSmokingAllowed" id="NotOkay" value="NotOkay" <c:if test="${roomMate.mateSmokingAllowed eq 'NotOkay'}">checked</c:if>> Not Okay</label>
                  						<label class="btn btn-default btn-input <c:if test="${roomMate.mateSmokingAllowed eq 'NotInTheHouse'}">active</c:if>"><input type="radio" name="mateSmokingAllowed" id="NotInTheHouse" value="NotInTheHouse" <c:if test="${roomMate.mateSmokingAllowed eq 'NotInTheHouse'}">checked</c:if>> Not In The House</label>
                					</div>
              					</div>

              					<div class="form-group">
                					<label for="preferToLiveWith">Prefer to Live With</label>
                					<div id="smokersOkay" class="btn-group-sm" data-toggle="buttons">
                  						<label class="btn btn-default btn-input <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Maharashtrian')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Gujrati" value="Maharashtrian" <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Maharashtrian')}">checked</c:if>> Maharashtrian</label>
                  						<label class="btn btn-default btn-input <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Gujrati')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Gujrati" value="Gujrati" <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Gujrati')}">checked</c:if>> Gujrati</label>
                  						<label class="btn btn-default btn-input <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Punjabi')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Punjabi" value="Punjabi" <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Punjabi')}">checked</c:if>> Punjabi</label>
                  						<label class="btn btn-default btn-input <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'SouthIndian')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="SouthIndian" value="SouthIndian" <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'SouthIndian')}">checked</c:if>> South Indian</label>
                  						<label class="btn btn-default btn-input <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Bengali')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Bengali" value="Bengali" <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'Bengali')}">checked</c:if>> Bengali</label>
                  						<label class="btn btn-default btn-input <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'NoPreference')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="NoPreference" value="NoPreference" <c:if test="${fn:contains(roomMate.matePreferToLiveWith, 'NoPreference')}">checked</c:if>> No Preference</label>
                					</div>
              					</div>

								<a class="btn btn-primary" style="font-size: 15px;" id="backToRoomRequiredDetails"><< Back</a>
              					<button type="submit" class="btn btn-primary" style="font-size: 15px;">Save and activate</button>
              				</div>
            			</form>
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
    	<script src="js/ajax.js" type="text/javascript"></script>
		<script type="text/javascript">
			//AJAX bind call for ajax initialization...
			var ajax = new ROOM.AJAX();	
		</script>

		<script src="https://maps.googleapis.com/maps/api/js?sensor=false&libraries=places"></script>

		<script type="text/javascript">
			function initialize() {
    			var input = document.getElementById('lookingforArea');
    			var options = {componentRestrictions: {country: 'in'}};     
    			new google.maps.places.Autocomplete(input, options);
			}
        	google.maps.event.addDomListener(window, 'load', initialize);
		</script>
  	</body>
</html>