<!-- This page is for generating webpage -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet" href='<c:url value="/etc/css/report.css"/>'
	id="bootstrap-css">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>


<title>Report Generation</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<!-- Nav tabs -->
			<div class="card">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active">
					<li role="presentation"><a href="#profile"
						aria-controls="profile" role="tab" data-toggle="tab">Facility
							Per Room</a></li>
					<li role="presentation"><a href="#messages"
						aria-controls="messages" role="tab" data-toggle="tab">Room
							Transfers</a></li>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane" id="profile">
						<div role="tabpanel" class="tab-pane active" id="home">
							<div class="row">
								<table id="jqGridReport1"></table>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="messages">
						<div class="row">
							<table id="jqGridReport2"></table>
						</div>
					</div>
				</div>

			</div>

		</div>


	</div>
</body>
</html>
