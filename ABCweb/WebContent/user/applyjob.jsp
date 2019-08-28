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
<body class="profile">
<%@ include file="navprofile.jsp" %>

	<h1><s:property value="msg" /></h1>
	<br>
	<a href="listjobs.action?submitType=user&email=<s:property value="email" />">
				<button class="btn btn-primary">View Jobs</button>
			</a>

	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>