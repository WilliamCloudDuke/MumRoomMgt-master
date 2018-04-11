<!-- This is a login form that will be used 
When the a student registered
Author: Binyam H
March 18, 2018 

 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href='<c:url value="/etc/css/login.css"/>'>
<title>Room Management System</title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="login.js"></script>

<title>Login form</title>
</head>
<body>

	<!--
    This is the container that holds the overall login 
    -->
	

	<div class="container">
		<div class="inside inside-container">
			<img class="mum-logo"
				src='<c:url value="/etc/images/logo-icon-transparent.svg"/>' alt="" />
			 
			<h3 class="form-signin-heading">Sign In</h3>
			<form class="form-signin" method="post" action="login">
				<span id="reauth-email" class="reauth-email"></span> <input
					type="email" id="inputEmail" name="inputEmail" class="form-inputs"
					placeholder="Email address" required autofocus> <input
					type="password" id="inputPassword" name="inputPassword"
					class="form-inputs" placeholder="Password" required>
				<div id="remember" class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<div class="alert alert-danger" id="alert" style="display:none;" >
				     
						<c:if test="${not empty requestScope.errorMessage}">
						     <script type="text/javascript">
          							  $(document).ready(function(){
                                                $("#alert").show();
          									  });
       						</script>
							<h3 class="form-signin-heading">
								<c:out value="${requestScope.errorMessage}" />
							</h3>
						</c:if>
				</div>
				<button class="btn btn-lg btn-primary btn-block btn-signin"
					type="submit">Sign in</button>
			</form>
			<!-- /form -->


			<a href="#" class="forgot-password"> Forgot the password? </a>
		</div>
		<!-- end of inside-container -->
	</div>
	<!-- end of container -->
	
</body>
</html>