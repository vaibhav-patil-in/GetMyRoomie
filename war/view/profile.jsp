<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="common/include.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<title>Manage your profile | GetmyRoomie.com</title>
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
    
		<script type="text/javascript">

    		function PreviewImage() {
        		var oFReader = new FileReader();
        		oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);

				oFReader.onload = function (oFREvent) {
            		document.getElementById("uploadPreview").src = oFREvent.target.result;
            		document.getElementById("userProfileimage").value = oFREvent.target.result;
        		};
    		};
		</script>

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
	          		<li class="active"><a href="/profile"><span class="glyphicon glyphicon-user"></span> About Me</a></li>
	          		<li><a href="/profileNeedARoom"><span class="glyphicon glyphicon-user"></span> Need a room</a></li>
	          		<li><a href="/profileListARoom"><span class="glyphicon glyphicon-home"></span> List a room</a></li>
	          		<li><a href="/profileMyListing"><span class="glyphicon glyphicon-list"></span> My Listings</a></li>
	          		<li><a href="/profileMyShortList"><span class="glyphicon glyphicon-heart"></span> My Shortlist</a></li>
	          		<li><a href="/profileMessages"><span class="glyphicon glyphicon-inbox"></span> Inbox <span class="badge">${messageCount}</span></a></li>
	        	</ul>
	
	        	<div class="tab-content">
	          		<div class="tab-pane active" id="AboutMe">
	           			<form role="form" action="/updateProfile" method="post" id="profileAboutMeForm">
	
							<div class="row">
								<div class="listing-header">          
									<span>Basics</span>
								</div>
	
								<div class="col-sm-6">
									<div class="form-group profile-image thumbnail">
	                					<img src="" class="img-polaroid" id="uploadPreview" name="uploadPreview">
	                					<input type="file" id="uploadImage" name="uploadImage" onchange="PreviewImage();" style="color: transparent;">
	                					<p class="help-block">Please choose a picture profile.</p>
	                					<input type="hidden" value="${user.userProfileimage}" id="userProfileimage" name="userProfileimage"/>
	              					</div>
	              				</div>
	              
	            				<div class="col-sm-6">
	              					<div class="form-group">
	                					<label for="displayName">Name</label>
	                					<input type="text" class="form-control" id="userName" name="userName" value="${user.userName}" placeholder="Please enter your name">
	              					</div>
	
	              					<div class="form-group">
	                					<label for="mobileNumber">Mobile Number</label>
	              						<input type="text" class="form-control" id="userMobileNumber" name="userMobileNumber" value="${user.userMobileNumber}" maxlength="10" placeholder="Please enter your mobile number">
	                					<input type="checkbox" name="showUserMobileNumber" id="checkBoxMobile" value="Yes" <c:if test="${user.showUserMobileNumber eq 'Yes'}">checked</c:if>/><span class="label-hint"> Show my mobile number to other people on my profile.</span>
	             	 				</div>
	
	              					<div class="form-group">
	                					<label for="email">Email</label>
	                					<input type="email" class="form-control" disabled="disabled" id="userEmail" name="userEmail" value="${user.userEmail}" placeholder="Please enter your email">
	              					</div>
	
	              					<div class="form-group">
	                					<label for="age">My Age</label>
	                					<input type="text" class="form-control input-field-minimz" id="userAge" name="userAge" value="${user.userAge}" placeholder="Age">
	              					</div>
	           				 	</div>
							</div>
	
							<div class="row">
								<div class="listing-header">          
									<span>About me</span>
								</div>
	
	              				<div class="form-group">
	                				<label for="gender">My Gender</label>
	                				<div id="gender" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${user.userGender eq 'Male'}">active</c:if>"><input type="radio" name="userGender" id="Male" value="Male" <c:if test="${user.userGender eq 'Male'}">checked</c:if>> Male</label>
	                  					<label class="btn btn-default btn-input <c:if test="${user.userGender eq 'Female'}">active</c:if>"><input type="radio" name="userGender" id="Female" value="Female" <c:if test="${user.userGender eq 'Female'}">checked</c:if>> Female</label>
	                				</div>
	             	 			</div>
	              
	              				<div class="form-group">
	                				<label for="occupation">My Occupation</label>
	                				<div id="occupation" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${user.userOccupation eq 'Professional'}">active</c:if>"><input type="radio" name="userOccupation" id="Professional" value="Professional" <c:if test="${user.userOccupation eq 'Professional'}">checked</c:if>> Professional</label>
	                  					<label class="btn btn-default btn-input <c:if test="${user.userOccupation eq 'Student'}">active</c:if>"><input type="radio" name="userOccupation" id="Student" value="Student" <c:if test="${user.userOccupation eq 'Student'}">checked</c:if>> Student</label>
	                				</div>
	              				</div>
	              
	              				<div class="form-group">
	                				<label for="petsOkay">Do you have Pets ?</label>
	                				<div id="petsOkay" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${user.userHavePets eq 'Yes'}">active</c:if>"><input type="radio" name="userHavePets" id="Yes" value="Yes" <c:if test="${user.userHavePets eq 'Yes'}">checked</c:if>> Yes</label>
	                  					<label class="btn btn-default btn-input <c:if test="${user.userHavePets eq 'No'}">active</c:if>"><input type="radio" name="userHavePets" id="No" value="No" <c:if test="${user.userHavePets eq 'No'}">checked</c:if>> No</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="drinkerOkay">Do you drink?</label>
	                				<div id="drinkerOkay" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${user.userDrink eq 'Yes'}">active</c:if>"><input type="radio" name="userDrink" id="Yes" value="Yes" <c:if test="${user.userDrink eq 'Yes'}">checked</c:if>> Yes</label>
	                  					<label class="btn btn-default btn-input <c:if test="${user.userDrink eq 'No'}">active</c:if>"><input type="radio" name="userDrink" id="No" value="No" <c:if test="${user.userDrink eq 'No'}">checked</c:if>> No</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="drinkerOkay">Do you smoke?</label>
	                				<div id="drinkerOkay" class="btn-group-sm" data-toggle="buttons">
	                  					<label class="btn btn-default btn-input <c:if test="${user.userSmoke eq 'Yes'}">active</c:if>"><input type="radio" name="userSmoke" id="Yes" value="Yes" <c:if test="${user.userSmoke eq 'Yes'}">checked</c:if>> Yes</label>
	                  					<label class="btn btn-default btn-input <c:if test="${user.userSmoke eq 'No'}">active</c:if>"><input type="radio" name="userSmoke" id="No" value="No" <c:if test="${user.userSmoke eq 'No'}">checked</c:if>> No</label>
	                				</div>
	              				</div>
	
	              				<div class="form-group">
	                				<label for="aboutMe">About me</label>
	                				<textarea class="form-control" id="userAboutMe" name="userAboutMe" rows="3" placeholder="Please write some interesting things about you">${user.userAboutMe}</textarea>
	              				</div>
	
	              				<button type="submit" class="btn btn-primary" style="font-size: 15px;">Update</button>
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
    	<script src="js/lib/jquery.blockUI.js" type="text/javascript"></script>
    	<script src="js/bootstrap.js"></script>
    	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
    	<script type="text/javascript" src="../js/scripts.js"></script>
	</body>
</html>