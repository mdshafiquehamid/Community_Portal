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
	
	<form action=updateexperience method="post">
    	<table>
	    	<tr>
	    		<td><label for="company">Company</label></td>
	    		<td><input id="company" type="text" name="experience_company" value='<s:property value="experience.experience_company"/>'></td>
	    	</tr>
	    	<tr>
	    		<td><label for="position">Job Position</label></td>
	    		<td><input id="position" type="text" name="experience_position" value='<s:property value="experience.experience_position"/>'></td>
	    	</tr>
	    	<tr>
	    		<td><label for="duration">Duration</label></td>
	    		<td><input id="duration" type="text" name="duration" value='<s:property value="experience.duration"/>'></td>
	    	</tr>
	    	<tr>
	    		<td><label for="country">Country</label></td>
	    		<td><input id="country" type="text" name="experience_country" value='<s:property value="experience.experience_country"/>'></td>
	    	</tr>
	    	<tr>
	    		<td><label for="experience_description">Description</label></td>
	    		<td><textarea rows="10" cols="70" id="experience_description" name="experience_description"><s:property value="experience.experience_description"/></textarea></td>
	    	</tr>
    	</table>
    	<input type="hidden" name="email" value='<s:property value="email"/>'><br>
    	<input type="hidden" name="id" value='<s:property value="experience.id"/>'><br>
    	
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