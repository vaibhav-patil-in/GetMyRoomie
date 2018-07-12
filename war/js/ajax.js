var ROOM = ROOM || {};

//View scoped variables to use JSON response objects without making duplicate AJAX calls.
var SearchTimeOut = 0;
var Interval = 500;
var CurrentSearchKey = '';

ROOM.AJAX = function() {
	this.forms = $('.room-form');
    this.bind();
};


ROOM.AJAX.prototype = {

		/**
			Default timeout for all requests.
		@number
		 */
		// TODO Incresed the timeout from 8000 to 15000. We should bring it back to 8000 once the integration is completed.
		_defaultTimeout: 45000,

	    /**
	      Binds all handlers that will result in an ajax request sends them to methods listed below.
	     */
	    bind: function() {
	        var context = this;
	        //added for page blocking when ajax request is made
	        $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);

	        $.ajaxSetup ({
	            // Disable caching of AJAX responses
	            cache: false
	        });  
	        
	        $(".form-reg-email").change(function() {
	        	var ck_email = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
	        	if($.trim($(this).val()) != '' && ck_email.test($.trim($(this).val()))){
	        		context.checkEmailExist($.trim($(this).val()));
	        	}
	        });
	        
	        $(".form-recovery-email").change(function() {
	        	var ck_email = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
	        	if($.trim($(this).val()) != '' && ck_email.test($.trim($(this).val()))){
	        		context.checkIfRecoveryEmailExist($.trim($(this).val()));
	        	}
	        });
	        
	        $('.form-locality-area').each(function() {
	            $(this).bind('keyup', {
	            	areaLocality: $.trim($(this).val()),
	                context: this
	            }, context.getAreaLocalityList);
	        });

	        /*Serach Room mate started*/
	        $("#browseRoomMateLookingInCity").change(function() {
	        	context.searchRoomMates();
	        });
	        
	        $("#browseRoomMateLocation").blur(function(){
	        	context.searchRoomMates();
	        });
	        
	        $('input:radio[name=browseRoomMateUserGender]').on("change", function () {
	        	context.searchRoomMates();
	        });
	        
	        $('input:radio[name=browseRoomMateUserOccupation]').on("change", function () {
	        	context.searchRoomMates();
	        });
	        
	        $("#browseRoomMateMonthlyBudget").change(function() {
	        	context.searchRoomMates();
	        });
	        /*Serach Room mate Ended*/
	        
	        
	        /*Serach Room started*/
	        $("#browseRoomLookingInCity").change(function() {
	        	context.searchRooms();
	        });
	        
	        $("#browseRoomLocation").blur(function(){
	        	context.searchRooms();
	        });
	        
	        $('input:radio[name=browseRoomMateGender]').on("change", function () {
	        	context.searchRooms();
	        });
	        
	        $('input:radio[name=browseRoomPropertyType]').on("change", function () {
	        	context.searchRooms();
	        });
	        
	        $("#browseRoomMonthlyRent").change(function() {
	        	context.searchRooms();
	        });
	        /*Serach Room Ended*/
	        
	    },
	    
	    checkEmailExist: function(email) {
    		$('#ajaxError').addClass('display-none');
    		$('#ajaxError').removeClass('display-block');
	    	$.ajax({
	            url: '/ajaxHandler/service/checkEmailExist/',
	            data: {
	            	email: email
	            },
	            dataType: 'JSON',
	            success: function(data) {
	                if (data.update) {
	                	if(data.update.errorMessage){
	                		$('#ajaxError').removeClass('display-none');
	                		$('#ajaxError').addClass('display-block');
	                		$('#ajaxError').html(data.update.errorMessage);
	                		$('#registerUserButton').attr( "disabled","disabled");
	                	}
	                }
	            },
	            error: function(jqXHR, textStatus, errorThrown) {},
	            timeout: this._defaultTimeout
	        });
	    },
	    
	    checkIfRecoveryEmailExist: function(email) {
    		$('#ajaxError').addClass('display-none');
    		$('#ajaxError').removeClass('display-block');
	    	$.ajax({
	            url: '/ajaxHandler/service/checkEmailExist/',
	            data: {
	            	email: email
	            },
	            dataType: 'JSON',
	            success: function(data) {
	                if (data.update) {
	                	if(data.update.passwordRecoveryEmailNotExist){
	                		$('#ajaxError').removeClass('display-none');
	                		$('#ajaxError').addClass('display-block');
	                		$('#ajaxError').html(data.update.passwordRecoveryEmailNotExist);
	                		$('#passwordRecoveryButton').attr( "disabled","disabled");
	                	}
	                }
	            },
	            error: function(jqXHR, textStatus, errorThrown) {},
	            timeout: this._defaultTimeout
	        });
	    },
	    
	    searchRoomMates: function() {
	    	var lookingCity = $.trim($("#browseRoomMateLookingInCity").val());
	    	var lookingAreaInCity = $.trim($("#browseRoomMateLocation").val());
	    	var userGender = $.trim($('input:radio[name=browseRoomMateUserGender]:checked').val());
	    	var userOccupation = $.trim($('input:radio[name=browseRoomMateUserOccupation]:checked').val());
	    	var monthlyBudget = $.trim($("#browseRoomMateMonthlyBudget").val());
	    	$.ajax({
	            url: '/ajaxHandler/service/searchRoommates/',
	            data: {
	            	lookingCity: lookingCity,
	            	lookingAreaInCity: lookingAreaInCity,
	            	userGender: userGender,
	            	userOccupation: userOccupation,
	            	monthlyBudget: monthlyBudget
	            },
	            dataType: 'JSON',
	            success: function(data) {
	            	if (data.update && data.update.myMateListingList) {
		            	//TODO...Update the page new data provided.
	            		
	            		var results = '';
	            		// check whether there multiple rooms in response
                        if ($.isArray(data.update.myMateListingList))
	                    {
                        	for (var i = 0; i < data.update.myMateListingList.length; i++) {

	                            results += '<a href="/viewRoommate?param='+data.update.myMateListingList[i].userEmail+'">'+
				          					'<div class="col-sm-6 col-md-4">'+
				          						'<div class="thumbnail">'+
				          							'<img src="'+data.update.myMateListingList[i].profileImage+'">'+
			          								'<div class="caption">'+
			          									'<p class="post-name"><b>'+data.update.myMateListingList[i].userName+'</b></p>'+
			          									'<p class="post-summary">'+data.update.myMateListingList[i].profileHeadLine+'</p>'+
			          									'<p class="post-budget">Monthly Budget : '+data.update.myMateListingList[i].monthlyBudget+' INR</p>'+
			          								'</div>'+
			          							'</div>'+
			          						'</div>'+
			          						'</a>';
	                        }
	                    }else{
                            results += '<a href="/viewRoommate?param='+data.update.myMateListingList.userEmail+'">'+
          					'<div class="col-sm-6 col-md-4">'+
          						'<div class="thumbnail">'+
          							'<img src="'+data.update.myMateListingList.profileImage+'">'+
      								'<div class="caption">'+
      									'<p class="post-name"><b>'+data.update.myMateListingList.userName+'</b></p>'+
      									'<p class="post-summary">'+data.update.myMateListingList.profileHeadLine+'</p>'+
      									'<p class="post-budget">Monthly Budget : '+data.update.myMateListingList.monthlyBudget+' INR</p>'+
      								'</div>'+
      							'</div>'+
      						'</div>'+
      						'</a>';
	                    }
                        $("#gridView").empty();
                        $("#gridView").append(results);
	            	}else{
	            		$("#gridView").empty();
	            	}
	            },
	            error: function(jqXHR, textStatus, errorThrown) {},
	            timeout: this._defaultTimeout
	        });
		},
		
		searchRooms: function() {
	    	var lookingCity = $.trim($("#browseRoomLookingInCity").val());
	    	var lookingAreaInCity = $.trim($("#browseRoomLocation").val());
	    	var mateGender = $.trim($('input:radio[name=browseRoomMateGender]:checked').val());
	    	var propertyType = $.trim($('input:radio[name=browseRoomPropertyType]:checked').val());
	    	var monthlyRent = $.trim($("#browseRoomMonthlyRent").val());
	    	$.ajax({
	            url: '/ajaxHandler/service/searchRooms/',
	            data: {
	            	lookingCity: lookingCity,
	            	lookingAreaInCity: lookingAreaInCity,
	            	mateGender: mateGender,
	            	propertyType: propertyType,
	            	monthlyRent: monthlyRent
	            },
	            dataType: 'JSON',
	            success: function(data) {
	            	if (data.update && data.update.myRoomListingList) {
		            	//TODO...Update the page new data provided.
	            		
	            		var results = '';
	            		// check whether there multiple rooms in response
                        if ($.isArray(data.update.myRoomListingList))
	                    {
                        	for (var i = 0; i < data.update.myRoomListingList.length; i++) {

	                            results += '<a href="/viewRoom?param='+data.update.myRoomListingList[i].userEmail+'">'+
				    			           '<div class="col-sm-6 col-md-4">'+
				    			              '<div class="thumbnail">'+
				    			                '<img src="'+data.update.myRoomListingList[i].roomListingImage1+'">'+
				    			                '<div class="caption">'+
				    			                 '<p class="post-name"><b>'+data.update.myRoomListingList[i].roomHeadLine+'</b></p>'+
				    			                 '<p class="post-summary">'+data.update.myRoomListingList[i].roomInCity+'</p>'+
				    			                 '<p class="post-budget">Monthly Rent : '+data.update.myRoomListingList[i].monthlyRent+' INR</p>'+
				    			                 '<p class="post-move-in-date">Available from: '+data.update.myRoomListingList[i].availableFromDate+'</p>'+
				    			                '</div>'+
				    			              '</div>'+
				    			            '</div>'+
				    			            '</a>';
	                        }
	                    }else{
                            results += '<a href="/viewRoom?param='+data.update.myRoomListingList.userEmail+'">'+
	    			           '<div class="col-sm-6 col-md-4">'+
	    			              '<div class="thumbnail">'+
	    			                '<img src="'+data.update.myRoomListingList.roomListingImage1+'">'+
	    			                '<div class="caption">'+
	    			                 '<p class="post-name"><b>'+data.update.myRoomListingList.roomHeadLine+'</b></p>'+
	    			                 '<p class="post-summary">'+data.update.myRoomListingList.roomInCity+'</p>'+
	    			                 '<p class="post-budget">Monthly Rent : '+data.update.myRoomListingList.monthlyRent+' INR</p>'+
	    			                 '<p class="post-move-in-date">Available from: '+data.update.myRoomListingList.availableFromDate+'</p>'+
	    			                '</div>'+
	    			              '</div>'+
	    			            '</div>'+
	    			            '</a>';
	                    }
                        $("#gridView").empty();
                        $("#gridView").append(results);
	            	}else{
	            		$("#gridView").empty();
	            	}
	            },
	            error: function(jqXHR, textStatus, errorThrown) {},
	            timeout: this._defaultTimeout
	        });
		}
};