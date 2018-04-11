<!-- Student Profile form 
Author: Binyam Heyi
March 19,2018
FF, IA
 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student Profile Customization form</title>
    <link rel="stylesheet" href='<c:url value="/etc/css/studentProfile.css"/>' id="bootstrap-css">
</head>
<body>
       
        
        <div class="container">
                
            <h1 class="well"> Profile Registration Form</h1>
            
            <div class="col-lg-12 well">
            <div class="row">
                        <form>
                            <div class="col-sm-12">
                                    <div class="col-md-3">
                                            <div class="text-center">
                                              <img src='<c:url value="/etc/images/biny.jpg"/>' class="avatar img-circle" alt="avatar">
                                              <h6>Upload a different photo...</h6>
                                              
                                              <input type="file" class="form-control">
                                            </div>
                                   </div>
                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label>First Name</label>
                                        <input type="text" id="sprof-firstname" placeholder="Enter First Name Here.." class="form-control">
                                    </div>
                                    <div class="col-sm-6 form-group">
                                        <label>Last Name</label>
                                        <input type="text" id="sprof-lastname" placeholder="Enter Last Name Here.." class="form-control">
                                    </div>
                                </div>					
                               
                                <div class="row">
                                    <div class="col-sm-4 form-group">
                                        <label>Building</label>
                                        <input type="text" id="sprof-bldgno" placeholder="Building.." class="form-control">
                                    </div>	
                                    <div class="col-sm-4 form-group">
                                        <label>Room Number</label>
                                        <input type="text"  id="sprof-roomno" placeholder="Room Number.." class="form-control">
                                    </div>	
                                   
                                </div>
                                <div class="row">
                                    
                                    <div class="col-sm-6 form-group">
                                        <label>Department</label>
                                        <input type="text" placeholder="Department.." class="form-control">
                                    </div>	
                                </div>						
                            <div class="form-group">
                                <label>Phone Number</label>
                                <input type="text" id="sprof-phone" placeholder="Phone Number.." class="form-control">
                            </div>		
                            <div class="form-group">
                                <label>Email Address</label>
                                <input type="text" id="sprof-email" placeholder="Email.." class="form-control">
                            </div>	
                          
                            <button type="button" class="btn btn-lg btn-info">Submit</button>					
                            </div>
                        </form> 
                        </div>
            </div>
            </div>
</body>
</html>