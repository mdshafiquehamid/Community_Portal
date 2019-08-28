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
<body>
	<h1>Sign In</h1>
	<s:form action="signin.action" method="post">
		<s:textfield label="Email" name="email" />
		<s:password label="Password" name="password" />
		<s:submit value="Sign In" class="btn btn-primary" />
		<s:reset value="Reset" class="btn btn-warning" />
	</s:form>
</body>
</html>