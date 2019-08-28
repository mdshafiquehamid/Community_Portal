<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="Styles/bootstrap.min.css">
	<link rel="stylesheet" href="CSS/styles.css">
</head>
<body class="background">
<%@ include file="navhome.jsp" %>
	
	<div class="row main-frame">
    	<div class="col-sm-6 welcome">
    				<%@ include file="welcomemessage.jsp" %>
    	</div>
    	<div class="col-sm-6 welcome">
    				<h3>Your Password has been successfully changed</h3>
    	</div>
    </div>

	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>