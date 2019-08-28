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
	
	<form action=usercreatethread method="post">
    	<table>
	    	<tr>
	    		<td><label for="thread">Thread*</label></td>
	    		<td><textarea rows="10" cols="70" id="thread" name="thread_message" required></textarea></td>
	    	</tr>
    	</table>
    		<input type="hidden" name="email" value='<s:property value="email"/>'><br>
    		<button name="submitType" value="post" type="submit" class="btn btn-primary">Post</button>     			
    </form>
    	<br>
    		<a href="userlistthreads.action?email=<s:property value="email" />">
				<button class="btn btn-primary">View Threads</button>
			</a>
			<p>*Required Fields</p>
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