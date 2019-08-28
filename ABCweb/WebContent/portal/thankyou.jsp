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
    				<h2>Your Registration is successful. Thank you for registering!</h2>
    					<h5>First Name: <s:property value="firstname" /></h5>
						<h5>Last Name: <s:property value="lastname" /></h5>
						<h5>Email: <s:property value="email" /></h5>
						<h5>Password: <s:property value="password" /></h5>
    	</div>
    </div>
</body>
</html>