 <!-- Populate the list of rooms with their 
 details
 Author: Binyam H
  March 20, 2018 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.3/css/ui.jqgrid.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.3/jquery.jqgrid.min.js"></script>

<script src='<c:url value="/etc/js/director/roomList.js"/>'></script>

</head>
<body>

	<c:if test='${not empty sessionScope.userBean}'>
		<div id="header">
			<c:if test='${sessionScope.userBean.buildingNumber ne 0}'>
				<span>Room List for Building Number
					${sessionScope.userBean.buildingNumber}</span>
			</c:if>
		</div>
	</c:if>
	<table id="jqGrid"></table>
	<div id="jqGridPager"></div>
</body>
</html>