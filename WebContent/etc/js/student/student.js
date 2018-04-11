/*
 * Last Update: 03/22/2018
 * navigational logic for student interface
 *  author Joseph Kelly Tusoy
 * */

$(document).ready(function() {
	
	console.log("initiated student.js");
	$('#nav_profile').click(function() {
		$('#profileContent').show();
		$('#requestContent').hide();
		$('#arrivalContent').hide();
	
	 
		$.ajax({
			url : 'http://localhost:8080/RoomMgtApp/student',
			success : function(result) {
				$("#sprof-firstname").val(result.name);
				$("#sprof-lastname").val(result.lastName);
				$("#sprof-email").val(result.email);
				$("#sprof-phone").val(result.phone);
				$("#sprof-bldgno").val("140");
				$("#sprof-roomno").val("101");  	
			}
		});

	});
	
	
	$('#nav_request').click(function() {
		$('#profileContent').hide();
		$('#requestContent').show();
		$('#arrivalContent').hide();
	 
		 

	});
	
	
	$('#nav_arrival').click(function() {
		$('#profileContent').hide();
		$('#requestContent').hide();
		$('#arrivalContent').show();
	 

	});
	
	
	

});