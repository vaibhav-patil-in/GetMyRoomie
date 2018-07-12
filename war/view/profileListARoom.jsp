<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>I have a room | GetmyRoomie.com</title>
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
	          		<li class="active"><a href="/profileListARoom"><span class="glyphicon glyphicon-home"></span> List a room</a></li>
	          		<li><a href="/profileMyListing"><span class="glyphicon glyphicon-list"></span> My Listings</a></li>
	          		<li><a href="/profileMyShortList"><span class="glyphicon glyphicon-heart"></span> My Shortlist</a></li>
	          		<li><a href="/profileMessages"><span class="glyphicon glyphicon-inbox"></span> Inbox <span class="badge">${messageCount}</span></a></li>
	        	</ul>
	
	        	<div class="tab-content">
	          		<div class="tab-pane active" id="ListARoom">
	
	            		<form role="form" action="/${action}" method="POST" id="profileListARoom">
	
							<div class="row" id="roomDescription">
	              				
	              				<div class="wizard-progress-steps">
	    							<a class="current"><span class="badge badge-inverse">1</span>Description</a>
	    							<a><span class="badge">2</span> Address</a>
	    							<a><span class="badge">3</span> Details</a>
	    							<a><span class="badge">4</span> Preferences</a>
	    							<a><span class="badge">5</span> Amenities</a>
								</div>
								<!-- <div class="listing-header">          
										<span>Description</span>
								</div>  -->
	              
	        					<div class="col-sm-8 col-md-7">
	
		              				<div class="form-group">
		                				<label for="listingHeadLine">Listing Headeline</label>
		                				<input type="text" class="form-control" value="${room.roomHeadLine}" id="roomHeadLine" name="roomHeadLine" placeholder="Room available in 2BHK flat">
		              				</div>
		
		              				<div class="form-group">
		                				<label for="aboutRoom">About the Room / Apartment</label>
		                				<textarea class="form-control" id="aboutRoom" name="aboutRoom" rows="3" placeholder="Example: We are chilled, fun loving group. Message us, ig you want to be a part of our group.">${room.aboutRoom}</textarea>
		              				</div>
		
		              				<div class="form-group">
		                				<label for="numberOfBedRooms"># of Bedrooms</label>
		                				<input type="text" class="form-control" value="${room.numberOfRooms}" id="numberOfRooms" name="numberOfRooms" placeholder="0">
		              				</div>
		
		              				<div class="form-group">
		                				<label for="numberOfHouseMates"># of Housemates</label>
		                				<input type="text" class="form-control" value="${room.numberOfRoomMates}" id="numberOfRoomMates" name="numberOfRoomMates" placeholder="0">
		              				</div>
		
		              				<div class="form-group">
		                				<label for="minimumStay">Minimum stay(In Months)</label>
		                				<select class="form-control" id="minimumStay" name="minimumStay">
		                  					<option <c:if test="${room.minimumStay eq '1'}">selected</c:if> value="1">1 Month</option>
							                <option <c:if test="${room.minimumStay eq '2'}">selected</c:if> value="2">2 Months</option>
							                <option <c:if test="${room.minimumStay eq '3'}">selected</c:if> value="3">3 Months</option>
							                <option <c:if test="${room.minimumStay eq '4'}">selected</c:if> value="4">4 Months</option>
							                <option <c:if test="${room.minimumStay eq '5'}">selected</c:if> value="5">5 Months</option>
							                <option <c:if test="${room.minimumStay eq '6'}">selected</c:if> value="6">6 Months</option>
							                <option <c:if test="${room.minimumStay eq '7'}">selected</c:if> value="7">7 Months</option>
							                <option <c:if test="${room.minimumStay eq '8'}">selected</c:if> value="8">8 Months</option>
							                <option <c:if test="${room.minimumStay eq '9'}">selected</c:if> value="9">9 Months</option>
							                <option <c:if test="${room.minimumStay eq '10'}">selected</c:if> value="10">10 Months</option>
							                <option <c:if test="${room.minimumStay eq '11'}">selected</c:if> value="11">11 Months</option>
		                  					<option <c:if test="${room.minimumStay eq '12'}">selected</c:if> value="12">12 Months</option>
		                				</select>
		              				</div>
		
		              				<div class="form-group">
		                				<label for="monthlyBudget">Monthly Rent(In INR)</label>
		                				<input type="text" class="form-control" value="${room.monthlyRent}" id="monthlyRent" name="monthlyRent" placeholder="Monthly rent">
		              				</div>
		
		              				<div class="form-group">
		                				<label for="availableFromDate">Available from date(dd-MM-yyyy)</label>
		                				<input data-format="dd-MM-yyyy" type="date" value="${room.availableFromDate}" id="availableFromDate" name="availableFromDate" class="form-control">
		              				</div>
		              				
		              				<a class="btn btn-primary" style="font-size: 15px;" id="roomAddressNext">Next >></a>
	              				</div>
	              			
	              			</div>
	
							<div class="row display-none" id="roomAddress">
	
	              				<div class="wizard-progress-steps">
	    							<a class="current"><span class="badge badge-inverse">1</span>Description</a>
	    							<a class="current"><span class="badge">2</span> Address</a>
	    							<a><span class="badge">3</span> Details</a>
	    							<a><span class="badge">4</span> Preferences</a>
	    							<a><span class="badge">5</span> Amenities</a>
								</div>
								<!-- <div class="listing-header">          
										<span>Address</span>
								</div>  -->					
	
								<div class="col-sm-8 col-md-7">
									<div class="form-group">
		                				<label for="city">City</label>
		                				<select class="form-control" id="roomInCity" name="roomInCity">
		                  					<option <c:if test="${room.roomInCity eq ''}">selected</c:if> value="">Select a city</option>
		                  					<option <c:if test="${room.roomInCity eq 'Pune'}">selected</c:if> value="Pune">Pune</option>
		                  					<option <c:if test="${room.roomInCity eq 'Mumbai'}">selected</c:if> value="Mumbai">Mumbai</option>
		                  					<option <c:if test="${room.roomInCity eq 'Delhi'}">selected</c:if> value="Delhi">Delhi</option>
		                  					<option <c:if test="${room.roomInCity eq 'Gurgaon'}">selected</c:if> value="Gurgaon">Gurgaon</option>
		                  					<option <c:if test="${room.roomInCity eq 'Noida'}">selected</c:if> value="Noida">Noida</option>
		                  					<option <c:if test="${room.roomInCity eq 'Banglore'}">selected</c:if> value="Banglore">Banglore</option>
		                  					<option <c:if test="${room.roomInCity eq 'Hyderabad'}">selected</c:if> value="Hyderabad">Hyderabad</option>
		                  					<option <c:if test="${room.roomInCity eq 'Chennai'}">selected</c:if> value="Chennai">Chennai</option>
		                				</select>
		              				</div>
		
		              				<div class="form-group">
		                				<label for="numberOfHouseMates">Postal Code</label>
		                				<input type="text" class="form-control" value="${room.roomPostalCode}" id="roomPostalCode" name="roomPostalCode" placeholder="0" maxlength="6">
		              				</div>
		
		              				<div class="form-group">
		                				<label for="neighbourhoods">Neighbourhoods</label>
		                				<input type="text" class="form-control" value="${room.roomAreaInCity}" id="roomAreaInCity" name="roomAreaInCity" placeholder="Select some options" autocomplete="off">
		              				</div>
		              				
		              				<a class="btn btn-primary" style="font-size: 15px;" id="backToRoomDescription"><< Back</a>
		              				<a class="btn btn-primary" style="font-size: 15px;" id="roomDetailNext">Next >></a>
		              				
	              				</div>
							</div>
	
							<div class="row display-none" id="roomDetail">
	
	              				<div class="wizard-progress-steps">
	    							<a class="current"><span class="badge badge-inverse">1</span>Description</a>
	    							<a class="current"><span class="badge">2</span> Address</a>
	    							<a class="current"><span class="badge">3</span> Details</a>
	    							<a><span class="badge">4</span> Preferences</a>
	    							<a><span class="badge">5</span> Amenities</a>
								</div>
								<!-- <div class="listing-header">          
										<span>Room Details</span>
								</div>  -->     
	              
	              				<div class="form-group">
	                				<label for="propertyType">Property Type</label>
	                				<div id="propertyType" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.propertyType eq 'PG'}">active</c:if>"><input type="radio" name="propertyType" id="PG" value="PG" <c:if test="${room.propertyType eq 'PG'}">checked</c:if>> PG</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.propertyType eq 'Flat'}">active</c:if>"><input type="radio" name="propertyType" id="Flat" value="Flat" <c:if test="${room.propertyType eq 'Flat'}">checked</c:if>> Flat</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.propertyType eq 'Bunglow'}">active</c:if>"><input type="radio" name="propertyType" id="Bunglow" value="Bunglow" <c:if test="${room.propertyType eq 'Bunglow'}">checked</c:if>> Bunglow</label>
	                				</div>
	             	 			</div>
	
	              				<div class="form-group">
	                				<label for="roomRelation">I am</label>
	                				<div id="roomRelation" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomRelation eq 'Tenant'}">active</c:if>"><input type="radio" name="roomRelation" id="Tenant" value="Tenant" <c:if test="${room.roomRelation eq 'Tenant'}">checked</c:if>> Tenant</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomRelation eq 'LiveInLandlord'}">active</c:if>"><input type="radio" name="roomRelation" id="LiveInLandlord" value="LiveInLandlord" <c:if test="${room.roomRelation eq 'LiveInLandlord'}">checked</c:if>> Live In Landlord</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomRelation eq 'LandlordButNotLiveIn'}">active</c:if>"><input type="radio" name="roomRelation" id="LandlordButNotLiveIn" value="LandlordButNotLiveIn" <c:if test="${room.roomRelation eq 'LandlordButNotLiveIn'}">checked</c:if>> Landlord But Not Live In</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="roomAccomodates">Accomodates</label>
	                				<div id="roomAccomodates" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomAccomodates eq 'Single'}">active</c:if>"><input type="radio" name="roomAccomodates" id="Single" value="Single" <c:if test="${room.roomAccomodates eq 'Single'}">checked</c:if>> Single</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomAccomodates eq 'Couple'}">active</c:if>"><input type="radio" name="roomAccomodates" id="Couple" value="Couple" <c:if test="${room.roomAccomodates eq 'Couple'}">checked</c:if>> Couple</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomAccomodates eq 'CoupleWithChildren'}">active</c:if>"><input type="radio" name="roomAccomodates" id="CoupleWithChildren" value="CoupleWithChildren" <c:if test="${room.roomAccomodates eq 'CoupleWithChildren'}">checked</c:if>> Couple With Children</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="roomFurnishingType">Furnishing Type</label>
	                				<div id="roomFurnishingType" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomFurnishingType eq 'Fullyfurnished'}">active</c:if>"><input type="radio" name="roomFurnishingType" id="Fullyfurnished" value="Fullyfurnished" <c:if test="${room.roomFurnishingType eq 'Fullyfurnished'}">checked</c:if>> Fully furnished</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomFurnishingType eq 'Partially'}">active</c:if>"><input type="radio" name="roomFurnishingType" id="Partially" value="Partially" <c:if test="${room.roomFurnishingType eq 'Partially'}">checked</c:if>> Partially</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.roomFurnishingType eq 'NotFurnished'}">active</c:if>"><input type="radio" name="roomFurnishingType" id="NotFurnished" value="NotFurnished" <c:if test="${room.roomFurnishingType eq 'NotFurnished'}">checked</c:if>> Not Furnished</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="cookingAtHome">Cooking At home</label>
	                				<div id="cookingAtHome" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.cookingAtHome eq 'Okay'}">active</c:if>"><input type="radio" name="cookingAtHome" id="Okay" value="Okay" <c:if test="${room.cookingAtHome eq 'Okay'}">checked</c:if>> Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.cookingAtHome eq 'NotOkay'}">active</c:if>"><input type="radio" name="cookingAtHome" id="NotOkay" value="NotOkay" <c:if test="${room.cookingAtHome eq 'NotOkay'}">checked</c:if>> Not Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.cookingAtHome eq 'LightCookingOnly'}">active</c:if>"><input type="radio" name="cookingAtHome" id="LightCookingOnly" value="LightCookingOnly" <c:if test="${room.cookingAtHome eq 'LightCookingOnly'}">checked</c:if>> Light Cooking Only</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="arePetsInHouse">Are Pets in house?</label>
	                				<div id="arePetsInHouse" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.arePetsInHouse eq 'Yes'}">active</c:if>"><input type="radio" name="arePetsInHouse" id="Yes" value="Yes" <c:if test="${room.arePetsInHouse eq 'Yes'}">checked</c:if>> Yes</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.arePetsInHouse eq 'No'}">active</c:if>"><input type="radio" name="arePetsInHouse" id="No" value="No" <c:if test="${room.arePetsInHouse eq 'No'}">checked</c:if>> No</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="areSmokersInHouse">Are smokers in house?</label>
	                				<div id="areSmokersInHouse" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.areSmokersInHouse eq 'Yes'}">active</c:if>"><input type="radio" name="areSmokersInHouse" id="Yes" value="Yes" <c:if test="${room.areSmokersInHouse eq 'Yes'}">checked</c:if>> Yes</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.areSmokersInHouse eq 'No'}">active</c:if>"><input type="radio" name="areSmokersInHouse" id="No" value="No" <c:if test="${room.areSmokersInHouse eq 'No'}">checked</c:if>> No</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="areDrinkersInHouse">Are drinkers in house?</label>
	                				<div id="areDrinkersInHouse" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.areDrinkersInHouse eq 'Yes'}">active</c:if>"><input type="radio" name="areDrinkersInHouse" id="Yes" value="Yes" <c:if test="${room.areDrinkersInHouse eq 'Yes'}">checked</c:if>> Yes</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.areDrinkersInHouse eq 'No'}">active</c:if>"><input type="radio" name="areDrinkersInHouse" id="No" value="No" <c:if test="${room.areDrinkersInHouse eq 'No'}">checked</c:if>> No</label>
	                				</div>
	              				</div>
	              				
	              				<a class="btn btn-primary" style="font-size: 15px;" id="backToRoomAddress"><< Back</a>
		              			<a class="btn btn-primary" style="font-size: 15px;" id="roomMatePreferencesNext">Next >></a>
							
							</div>
	
							<div class="row display-none" id="roomMatePreferences">
	
	              				<div class="wizard-progress-steps">
	    							<a class="current"><span class="badge badge-inverse">1</span>Description</a>
	    							<a class="current"><span class="badge">2</span> Address</a>
	    							<a class="current"><span class="badge">3</span> Details</a>
	    							<a class="current"><span class="badge">4</span> Preferences</a>
	    							<a><span class="badge">5</span> Amenities</a>
								</div>
								<!-- <div class="listing-header">          
										<span>Roommate Preferences</span>
								</div>  -->             
	              
	              				<div class="form-group">
	                				<label for="gender">Gender</label>
	                				<div id="gender" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateGender eq 'Male'}">active</c:if>"><input type="radio" name="mateGender" id="Male" value="Male" <c:if test="${room.mateGender eq 'Male'}">checked</c:if>> Male</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateGender eq 'Female'}">active</c:if>"><input type="radio" name="mateGender" id="Female" value="Female" <c:if test="${room.mateGender eq 'Female'}">checked</c:if>> Female</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateGender eq 'NoPreference'}">active</c:if>"><input type="radio" name="mateGender" id="NoPreference" value="NoPreference" <c:if test="${room.mateGender eq 'NoPreference'}">checked</c:if>> No Preference</label>
	                				</div>
	              				</div>
	              
	              				<div class="form-group">
	                				<label for="occupation">Occupation</label>
	                				<div id="occupation" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateOccupation eq 'Professional'}">active</c:if>"><input type="radio" name="mateOccupation" id="Professional" value="Professional" <c:if test="${room.mateOccupation eq 'Professional'}">checked</c:if>> Professional</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateOccupation eq 'Student'}">active</c:if>"><input type="radio" name="mateOccupation" id="Student" value="Student" <c:if test="${room.mateOccupation eq 'Student'}">checked</c:if>> Student</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateOccupation eq 'NoPreference'}">active</c:if>"><input type="radio" name="mateOccupation" id="NoPreference" value="NoPreference" <c:if test="${room.mateOccupation eq 'NoPreference'}">checked</c:if>> No Preference</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="petsOkay">Pets Okay?</label>
	                				<div id="petsOkay" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.matePetsAllowed eq 'Okay'}">active</c:if>"><input type="radio" name="matePetsAllowed" id="Okay" value="Okay" <c:if test="${room.matePetsAllowed eq 'Okay'}">checked</c:if>> Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.matePetsAllowed eq 'NotOkay'}">active</c:if>"><input type="radio" name="matePetsAllowed" id="NotOkay" value="NotOkay" <c:if test="${room.matePetsAllowed eq 'NotOkay'}">checked</c:if>> Not Okay</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="drinkerOkay">Drinker Okay?</label>
	                				<div id="drinkerOkay" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateDrinkingAllowed eq 'Okay'}">active</c:if>"><input type="radio" name="mateDrinkingAllowed" id="Okay" value="Okay" <c:if test="${room.mateDrinkingAllowed eq 'Okay'}">checked</c:if>> Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateDrinkingAllowed eq 'NotOkay'}">active</c:if>"><input type="radio" name="mateDrinkingAllowed" id="NotOkay" value="NotOkay" <c:if test="${room.mateDrinkingAllowed eq 'NotOkay'}">checked</c:if>> Not Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateDrinkingAllowed eq 'NotInTheHouse'}">active</c:if>"><input type="radio" name="mateDrinkingAllowed" id="NotInTheHouse" value="NotInTheHouse" <c:if test="${room.mateDrinkingAllowed eq 'NotInTheHouse'}">checked</c:if>> Not In The House</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="smokersOkay">Smokers okay?</label>
	                				<div id="smokersOkay" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateSmokingAllowed eq 'Okay'}">active</c:if>"><input type="radio" name="mateSmokingAllowed" id="Okay" value="Okay" <c:if test="${room.mateSmokingAllowed eq 'Okay'}">checked</c:if>> Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateSmokingAllowed eq 'NotOkay'}">active</c:if>"><input type="radio" name="mateSmokingAllowed" id="NotOkay" value="NotOkay" <c:if test="${room.mateSmokingAllowed eq 'NotOkay'}">checked</c:if>> Not Okay</label>
	                  					<label class="btn btn-default btn-input <c:if test="${room.mateSmokingAllowed eq 'NotInTheHouse'}">active</c:if>"><input type="radio" name="mateSmokingAllowed" id="NotInTheHouse" value="NotInTheHouse" <c:if test="${room.mateSmokingAllowed eq 'NotInTheHouse'}">checked</c:if>> Not In The House</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="preferToLiveWith">Prefer to Live With</label>
	                				<div id="preferToLiveWith" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.matePreferToLiveWith, 'Maharashtrian')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Maharashtrian" value="Maharashtrian" <c:if test="${fn:contains(room.matePreferToLiveWith, 'Maharashtrian')}">checked</c:if>> Maharashtrian</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.matePreferToLiveWith, 'Gujrati')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Gujrati" value="Gujrati" <c:if test="${fn:contains(room.matePreferToLiveWith, 'Gujrati')}">checked</c:if>> Gujrati</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.matePreferToLiveWith, 'Punjabi')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Punjabi" value="Punjabi" <c:if test="${fn:contains(room.matePreferToLiveWith, 'Punjabi')}">checked</c:if>> Punjabi</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.matePreferToLiveWith, 'SouthIndian')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="SouthIndian" value="SouthIndian" <c:if test="${fn:contains(room.matePreferToLiveWith, 'SouthIndian')}">checked</c:if>> South Indian</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.matePreferToLiveWith, 'Bengali')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="Bengali" value="Bengali" <c:if test="${fn:contains(room.matePreferToLiveWith, 'Bengali')}">checked</c:if>> Bengali</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.matePreferToLiveWith, 'NoPreference')}">active</c:if>"><input type="checkbox" name="matePreferToLiveWith" id="NoPreference" value="NoPreference" <c:if test="${fn:contains(room.matePreferToLiveWith, 'NoPreference')}">checked</c:if>> No Preference</label>
	                				</div>
	              				</div>
	              				
	              				<a class="btn btn-primary" style="font-size: 15px;" id="backToRoomDetail"><< Back</a>
		              			<a class="btn btn-primary" style="font-size: 15px;" id="roomAmenitiesNext">Next >></a>
	              				
							</div>
	
							<div class="row display-none" id="roomAmenities">
	
	              				<div class="wizard-progress-steps">
	    							<a class="current"><span class="badge badge-inverse">1</span>Description</a>
	    							<a class="current"><span class="badge">2</span> Address</a>
	    							<a class="current"><span class="badge">3</span> Details</a>
	    							<a class="current"><span class="badge">4</span> Preferences</a>
	    							<a class="current"><span class="badge">5</span> Amenities</a>
								</div>
								<!-- <div class="listing-header">          
										<span>Room Amenities</span>
								</div>  -->
	
	              				<div class="form-group">
	              					<label for="roomAmenities">Room Amenities</label>
	                				<div id="roomAmenities" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'Television')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="Television" value="Television" <c:if test="${fn:contains(room.roomAmenities, 'Television')}">checked</c:if>> Television</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'Internet')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="Internet" value="Internet" <c:if test="${fn:contains(room.roomAmenities, 'Internet')}">checked</c:if>> Internet</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'Gym')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="Gym" value="Gym" <c:if test="${fn:contains(room.roomAmenities, 'Gym')}">checked</c:if>> Gym</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'Freez')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="Freez" value="Freez" <c:if test="${fn:contains(room.roomAmenities, 'Freez')}">checked</c:if>> Freez</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'AC')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="AC" value="AC" <c:if test="${fn:contains(room.roomAmenities, 'AC')}">checked</c:if>> AC</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'Parking')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="Parking" value="Parking" <c:if test="${fn:contains(room.roomAmenities, 'Parking')}">checked</c:if>> Parking</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'SwimmingPool')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="SwimmingPool" value="SwimmingPool" <c:if test="${fn:contains(room.roomAmenities, 'SwimmingPool')}">checked</c:if>> Swimming Pool</label>
	                  					<label class="btn btn-default btn-input <c:if test="${fn:contains(room.roomAmenities, 'Elevator')}">active</c:if>"><input type="checkbox" name="roomAmenities" id="Elevator" value="Elevator" <c:if test="${fn:contains(room.roomAmenities, 'Elevator')}">checked</c:if>> Elevator</label>
	                				</div>
	              				</div>
	              				
	              				<label for="roomAmenities">Room Pictures</label>
	              				<div class="row">
	              					
	              					<div class="col-sm-4">
			              				<div class="form-group room-image thumbnail">
			                				<img src="" class="img-polaroid" id="uploadPreview1" name="uploadPreview1">
			                				<input type="file" id="uploadImage1" name="uploadImage1" onchange="PreviewImage1();" style="color: transparent;">
			              				</div>
		              				</div>
		              				
		              				<div class="col-sm-4">
			              				<div class="form-group room-image thumbnail">
			                				<img src="" class="img-polaroid" id="uploadPreview2" name="uploadPreview2">
			                				<input type="file" id="uploadImage2" name="uploadImage2" onchange="PreviewImage2();" style="color: transparent;">
			              				</div>
		              				</div>
		              				
		              				<div class="col-sm-4">
			              				<div class="form-group room-image thumbnail">
			                				<img src="" class="img-polaroid" id="uploadPreview3" name="uploadPreview3">
			                				<input type="file" id="uploadImage3" name="uploadImage3" onchange="PreviewImage3();" style="color: transparent;">
			              				</div>
		              				</div>
		              				
		              				<div class="col-sm-4">
			              				<div class="form-group room-image thumbnail">
			                				<img src="" class="img-polaroid" id="uploadPreview4" name="uploadPreview4">
			                				<input type="file" id="uploadImage4" name="uploadImage4" onchange="PreviewImage4();" style="color: transparent;">
			              				</div>
		              				</div>
		              				
		              				<div class="col-sm-4">
			              				<div class="form-group room-image thumbnail">
			                				<img src="" class="img-polaroid" id="uploadPreview5" name="uploadPreview5">
			                				<input type="file" id="uploadImage5" name="uploadImage5" onchange="PreviewImage5();" style="color: transparent;">
			              				</div>
		              				</div>
		              				
		              				<div class="col-sm-4">
			              				<div class="form-group room-image thumbnail">
			                				<img src="" class="img-polaroid" id="uploadPreview6" name="uploadPreview6">
			                				<input type="file" id="uploadImage6" name="uploadImage6" onchange="PreviewImage6();" style="color: transparent;">
			              				</div>
		              				</div>
		              				
	              				</div>
	              				
	              				<div class="form-group">
	                				<a class="btn btn-primary" style="font-size: 15px;" id="backToRoomMatePreferences"><< Back</a>
	              					<button type="submit" class="btn btn-primary" style="font-size: 15px;">Save and activate</button>
	              				</div>
	              				<input type="hidden" value="${room.roomListingImage1}" id="roomListingImage1" name="roomListingImage1"/>
	              				<input type="hidden" value="${room.roomListingImage2}" id="roomListingImage2" name="roomListingImage2"/>
	              				<input type="hidden" value="${room.roomListingImage3}" id="roomListingImage3" name="roomListingImage3"/>
	              				<input type="hidden" value="${room.roomListingImage4}" id="roomListingImage4" name="roomListingImage4"/>
	              				<input type="hidden" value="${room.roomListingImage5}" id="roomListingImage5" name="roomListingImage5"/>
	              				<input type="hidden" value="${room.roomListingImage6}" id="roomListingImage6" name="roomListingImage6"/>
	              				
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
    			var input = document.getElementById('roomAreaInCity');
    			var options = {componentRestrictions: {country: 'in'}};     
    			new google.maps.places.Autocomplete(input, options);
			}
        	google.maps.event.addDomListener(window, 'load', initialize);
		</script>
	
	</body>
</html>