 

<!-- Student Request (Form sample taken from 
  https://app.webtma.net/GenerateRequest.aspx?key=8fMN5Hy6FyywErc0I4i04X9%2fDVXnVsmZaTS7gGLRYJ%2bC3FF9Hp5vOKPI2B5iQg0o) 
Author: Binyam Heyi
March 20,2018
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
     <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">     
      <link rel="stylesheet" href='<c:url value="/etc/css/studentProfile.css"/>' id="bootstrap-css">
 </head>
 <body>
        
         
         <div class="container">
                 
             <h1 class="well"> Request Form</h1>
             
             <div class="col-lg-12 well">
             <div class="row">
                         <form>
                             <div class="col-sm-12">
                                   
                                 <div class="row">
                                     <div class="col-sm-6 form-group">
                                         <label>First Name</label>
                                         <input type="text" name="firstName" placeholder="Enter First Name Here.." class="form-control">
                                     </div>
                                     <div class="col-sm-6 form-group">
                                         <label>Last Name</label>
                                         <input type="text" name="lastName" placeholder="Enter Last Name Here.." class="form-control">
                                     </div>
                                 </div>					
                                
                                 <div class="row">
                                     <div class="col-sm-4 form-group">
                                         <label>Building</label>
                                         <input type="text" name="building" placeholder="Building.." class="form-control">
                                     </div>	
                                     <div class="col-sm-4 form-group">
                                         <label>Room Number</label>
                                         <input type="text" name="roomnumber" placeholder="Room Number.." class="form-control">
                                     </div>	
                                    
                                 </div>
                                
                             <div class="form-group">
                                 <label>Phone Number</label>
                                 <input type="text" name="phonenumber" placeholder="Phone Number.." class="form-control">
                             </div>		
                             <div class="form-group">
                                 <label>Email Address</label>
                                 <input type="text" name="email" placeholder="Email.." class="form-control">
                             </div>	
                                                            
                             <div class="form-group" >
                                <label for="exampleFormControlSelect1">Request Type</label>
                                <select class="form-control" id="exampleFormControlSelect1" name="requesttypes">
                                  <option value="maintainance">Maintainance</option>
                                  <option value="moveout">Move Out</option>
                                  <option value="roomchange">Room Change</option>                                
                                </select>
                              </div>
                                                                                                                                                                
                              <div class="form-group">
                                  <label for="exampleFormControlTextarea1">Additonal Info</label>
                                  <textarea name="addInfo" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>
                                
                             
                              <strong>Request Date: </strong>
                              <input id="date" type="date">   
                            
                             <br>
                            <button type="button" class="btn btn-lg btn-info">Submit</button>					
                             </div>
                         </form> 
                         </div>
             </div>
             </div>
 </body>
 </html>