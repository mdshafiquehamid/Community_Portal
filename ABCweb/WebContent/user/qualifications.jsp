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
	
	<form action=updatequalification method="post">
    	<table>
	    	<tr>
	    		<td><label for="qualification_type">Qualification Type</label></td>
	    		<td><input id="qualification_type" type="text" name="qualification_type" value='<s:property value="qualification.qualification_type"/>'></td>
	    	</tr>
	    		<tr>
	    		<td><label for="qualification">Qualification</label></td>
	    		<td><input id="qualification" type="text" name="qualification_cert" value='<s:property value="qualification.qualification"/>'></td>
	    	</tr>
	    	<tr>
	    		<td><label for="qualification_description">Description</label></td>
	    		<td><textarea rows="10" cols="70" id="qualification_description" name="qualification_description"><s:property value="qualification.qualification_description"/></textarea></td>
	    	</tr>
    	</table>
    	<input type="hidden" name="email" value='<s:property value="email"/>'><br>
    	<input type="hidden" name="id" value='<s:property value="qualification.id"/>'><br>
    	
    		<button name="submitType" value="update" type="submit" class="btn btn-primary">Update</button>     			
    </form>
    		<br>
    		<a href="vieweditprofile.action?submitType=vieweditprofile&email=<s:property value="email" />">
			<button class="btn btn-primary">View Profile</button>
			</a>
		
    	<s:if test="ctr>0">
    		<br>
			<span style="color: red;"><s:property value="msg" /></span>
		</s:if>
		<s:else>
			<br>
			<span style="color: red;"><s:property value="msg" /></span>
		</s:else>
	    	
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>