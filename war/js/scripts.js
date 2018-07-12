/**
 * @fileoverview Individual pieces of functionallity that are not broad enough to be broken out into a plugin
 */
/*$.blockUI();

$( document ).ready(function() {
	$.unblockUI();
});*/

$(function(){})

$.fn.exists = function(callback) {
  var args = [].slice.call(arguments, 1);

  if (this.length) {
    callback.call(this, args);
  }
  return this;
};

//Load image in the preview of profile image box.
$("#userProfileimage").exists(function() {
	$("#uploadPreview").attr('src', $("#userProfileimage").val());
});

$("#roomListingImage1").exists(function() {
	$("#uploadPreview1").attr('src', $("#roomListingImage1").val());
});

$("#roomListingImage2").exists(function() {
	$("#uploadPreview2").attr('src', $("#roomListingImage2").val());
});

$("#roomListingImage3").exists(function() {
	$("#uploadPreview3").attr('src', $("#roomListingImage3").val());
});

$("#roomListingImage4").exists(function() {
	$("#uploadPreview4").attr('src', $("#roomListingImage4").val());
});

$("#roomListingImage5").exists(function() {
	$("#uploadPreview5").attr('src', $("#roomListingImage5").val());
});

$("#roomListingImage6").exists(function() {
	$("#uploadPreview6").attr('src', $("#roomListingImage6").val());
});

function PreviewImage1() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage1").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview1").src = oFREvent.target.result;
    	document.getElementById("roomListingImage1").value = oFREvent.target.result;
	};
};

function PreviewImage1() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage1").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview1").src = oFREvent.target.result;
    	document.getElementById("roomListingImage1").value = oFREvent.target.result;
	};
};

function PreviewImage2() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage2").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview2").src = oFREvent.target.result;
    	document.getElementById("roomListingImage2").value = oFREvent.target.result;
	};
};

function PreviewImage3() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage3").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview3").src = oFREvent.target.result;
    	document.getElementById("roomListingImage3").value = oFREvent.target.result;
	};
};

function PreviewImage4() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage4").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview4").src = oFREvent.target.result;
    	document.getElementById("roomListingImage4").value = oFREvent.target.result;
	};
};

function PreviewImage5() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage5").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview5").src = oFREvent.target.result;
    	document.getElementById("roomListingImage5").value = oFREvent.target.result;
	};
};

function PreviewImage6() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("uploadImage6").files[0]);

	oFReader.onload = function (oFREvent) {
    	document.getElementById("uploadPreview6").src = oFREvent.target.result;
    	document.getElementById("roomListingImage6").value = oFREvent.target.result;
	};
};

//Login Form Validation are applied here.
$('#loginForm').bootstrapValidator({
    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	j_username: {
            validators: {
                notEmpty: {
                    message: 'The email address is required and cannot be empty'
                },
                emailAddress: {
                    message: 'The email address is not a valid'
                }
            }
        },
        j_password: {
            validators: {
                notEmpty: {
                    message: 'The password is required and cannot be empty'
                },
                stringLength: {
                    min: 8,
                    message: 'The password must have at least 8 characters'
                }
            }
        }
    }
});



//register Form Validation are applied here.
$('#registerForm').bootstrapValidator({
    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	userEmail: {
            validators: {
                notEmpty: {
                    message: 'The email address is required and cannot be empty'
                },
                emailAddress: {
                    message: 'The email address is not a valid'
                }
            }
        },
        userPassword: {
            validators: {
                notEmpty: {
                    message: 'The password is required and cannot be empty'
                },
                stringLength: {
                    min: 8,
                    message: 'The password must have at least 8 characters'
                }
            }
        },
        userName: {
            validators: {
                notEmpty: {
                    message: 'The name is required and cannot be empty'
                },
                stringLength: {
                    min: 6,
                    message: 'The name must have at least 6 characters and contains first name last name'
                }
            }
        },
        userMobileNumber: {
            validators: {
                notEmpty: {
                    message: 'The mobile number is required and cannot be empty'
                },
                digits: {
                    message: 'The mobile number can contain digits only'
                }
            }
        }
    }
});


//register Form Validation are applied here.
$('#profileAboutMeForm').bootstrapValidator({
    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	userEmail: {
            validators: {
                notEmpty: {
                    message: 'The email address is required and cannot be empty'
                },
                emailAddress: {
                    message: 'The email address is not a valid'
                }
            }
        },
        userName: {
            validators: {
                notEmpty: {
                    message: 'The name is required and cannot be empty'
                },
                stringLength: {
                    min: 6,
                    message: 'The name must have at least 6 characters and contains first name last name'
                }
            }
        },
        userMobileNumber: {
            validators: {
                notEmpty: {
                    message: 'The mobile number is required and cannot be empty'
                },
                digits: {
                    message: 'The mobile number can contain digits only'
                }
            }
        },
        userAboutMe: {
            validators: {
                notEmpty: {
                    message: 'The information about you is required and cannot be empty'
                },
                stringLength: {
                    min: 60,
                    message: 'Please enter more than 60 characters about you.'
                }
            }
        }
    }
});


//Forgot password Form Validation are applied here.
$('#forgotPasswordForm').bootstrapValidator({
    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	userEmail: {
            validators: {
                notEmpty: {
                    message: 'The email address is required and cannot be empty'
                },
                emailAddress: {
                    message: 'The email address is not a valid'
                }
            }
        }
    }
});

//Profile need a room form.
$('#profileNeedARoomForm').bootstrapValidator({
    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	profileHeadLine: {
            validators: {
                notEmpty: {
                    message: 'The profile headline is required and cannot be empty'
                },
                stringLength: {
                    min: 40,
                    message: 'Please enter more than 40 characters for profile headline'
                }
            }
        },
        lookingInCity: {
            validators: {
                notEmpty: {
                    message: 'Please select city where you are looking for room'
                }
            }
        },
        lookingforArea: {
            validators: {
                notEmpty: {
                    message: 'Please select area in city where you are looking for room'
                }
            }
        },
        rentingForMonth: {
            validators: {
                notEmpty: {
                    message: 'Please select for how many months you would like to rent'
                }
            }
        },
        monthlyBudget: {
            validators: {
                notEmpty: {
                    message: 'The monthly budget is required and cannot be empty'
                },
                digits: {
                    message: 'The monthly budget can contain digits only'
                }
            }
        }
    }
});


//Profile need a room form.
$('#profileListARoom').bootstrapValidator({
    // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
    	roomHeadLine: {
            validators: {
                notEmpty: {
                    message: 'The room headline is required and cannot be empty'
                },
                stringLength: {
                    min: 40,
                    message: 'Please enter more than 40 characters for room headline'
                }
            }
        },
        aboutRoom: {
            validators: {
                notEmpty: {
                    message: 'The about room is required and cannot be empty'
                },
                stringLength: {
                    min: 60,
                    message: 'Please enter more than 60 characters for about room'
                }
            }
        },
        numberOfRooms: {
            validators: {
                notEmpty: {
                    message: 'The number of rooms is required and cannot be empty'
                },
                digits: {
                    message: 'The number of rooms can contain digits only'
                }
            }
        },
        numberOfRoomMates: {
            validators: {
                notEmpty: {
                    message: 'The number of room mates is required and cannot be empty'
                },
                digits: {
                    message: 'The number of room mates can contain digits only'
                }
            }
        },
        minimumStay: {
            validators: {
                notEmpty: {
                    message: 'The minimum stay is required and cannot be empty'
                },
                digits: {
                    message: 'The minimum stay can contain digits only'
                }
            }
        },
        monthlyRent: {
            validators: {
                notEmpty: {
                    message: 'The monthly rent is required and cannot be empty'
                },
                digits: {
                    message: 'The monthly rent can contain digits only'
                }
            }
        },
        roomInCity: {
            validators: {
                notEmpty: {
                    message: 'Please select city where you are looking for room'
                }
            }
        },
        roomPostalCode: {
            validators: {
                notEmpty: {
                    message: 'The postal code is required and cannot be empty'
                },
                digits: {
                    message: 'The postal code can contain digits only'
                }
            }
        },
        roomAreaInCity: {
            validators: {
                notEmpty: {
                    message: 'Please select area in city where you room is located'
                }
            }
        }
    }
});

//Change the form action
$("#searchType").change(function() {
	
	if("roommate" == $.trim($(this).val())){
		$('.home-page-search-form').attr( "action","/searchRoommatesFromHomePage");
	}
	
	if("room" == $.trim($(this).val())){
		$('.home-page-search-form').attr( "action","/searchRoomsFromHomePage");
	}
});


/*Hide and show Profile need a room starts*/
$("#roomRequiredDetailsNext").click(function(){
	$("#roomRequiredDetails").hide();
	$("#roomMatePreferences").show();	
});

$("#backToRoomRequiredDetails").click(function(){
	$("#roomRequiredDetails").show();
	$("#roomMatePreferences").hide();	
});
/*Hide and show Profile need a room Ends*/

/*Hide and show Profile list a room starts*/
$("#roomAddressNext").click(function(){
	$("#roomAddress").show();
	$("#roomDescription").hide();
	$("#roomDetail").hide();
	$("#roomMatePreferences").hide();
	$("#roomAmenities").hide();	
});

$("#backToRoomDescription").click(function(){
	$("#roomAddress").hide();
	$("#roomDescription").show();
	$("#roomDetail").hide();
	$("#roomMatePreferences").hide();
	$("#roomAmenities").hide();
});

$("#roomDetailNext").click(function(){
	$("#roomAddress").hide();
	$("#roomDescription").hide();
	$("#roomDetail").show();
	$("#roomMatePreferences").hide();
	$("#roomAmenities").hide();
});

$("#backToRoomAddress").click(function(){
	$("#roomAddress").show();
	$("#roomDescription").hide();
	$("#roomDetail").hide();
	$("#roomMatePreferences").hide();
	$("#roomAmenities").hide();
});

$("#roomMatePreferencesNext").click(function(){
	$("#roomAddress").hide();
	$("#roomDescription").hide();
	$("#roomDetail").hide();
	$("#roomMatePreferences").show();
	$("#roomAmenities").hide();
});

$("#backToRoomDetail").click(function(){
	$("#roomAddress").hide();
	$("#roomDescription").hide();
	$("#roomDetail").show();
	$("#roomMatePreferences").hide();
	$("#roomAmenities").hide();
});

$("#roomAmenitiesNext").click(function(){
	$("#roomAddress").hide();
	$("#roomDescription").hide();
	$("#roomDetail").hide();
	$("#roomMatePreferences").hide();
	$("#roomAmenities").show();
});

$("#backToRoomMatePreferences").click(function(){
	$("#roomAddress").hide();
	$("#roomDescription").hide();
	$("#roomDetail").hide();
	$("#roomMatePreferences").show();
	$("#roomAmenities").hide();
});
/*Hide and show Profile list a room ends*/

/*Room Photo Gallery starts*/
$(document).ready(function(){
	$('li img').on('click',function(){
		var src = $(this).attr('src');
        var img = '<img src="' + src + '" class="img-responsive"/>';

        //Start of new code
        var index = $(this).parent('li').index();                   
        var html = '';
        html += img;                
        html += '<div style="height:25px;clear:both;display:block;">';
        html += '<a class="controls next" href="'+ (index+2) + '">next &raquo;</a>';
        html += '<a class="controls previous" href="' + (index) + '">&laquo; prev</a>';
        html += '</div>';
        //End of new code

        $('#myModal').modal();
        $('#myModal').on('shown.bs.modal', function(){
            $('#myModal .modal-body').html(html);
        })
        $('#myModal').on('hidden.bs.modal', function(){
            $('#myModal .modal-body').html('');
        });
    });  
 })
 
$(document).on('click', 'a.controls', function(){
	
	var index = $(this).attr('href');
    var src = $('ul.row li:nth-child('+ index +') img').attr('src');             
    $('.modal-body img').attr('src', src);
     
    var newPrevIndex = parseInt(index) - 1; 
    var newNextIndex = parseInt(newPrevIndex) + 2; 
    if($(this).hasClass('previous')){               
    	$(this).attr('href', newPrevIndex); 
        $('a.next').attr('href', newNextIndex);
    }else{
        $(this).attr('href', newNextIndex); 
        $('a.previous').attr('href', newPrevIndex);
    }
     
    var total = $('ul.row li').length + 1; 
    //hide next button
    if(total === newNextIndex){
        $('a.next').hide();
    }else{
        $('a.next').show()
    }            
    //hide previous button
    if(newPrevIndex === 0){
    	$('a.previous').hide();
    }else{
    	$('a.previous').show()
    }
    return false;
});
/*Room Photo Gallery Ends*/