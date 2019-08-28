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
	<style>
		table, td, th {border: 1px solid black;}
		table {border-collapse: collapse;}
	</style>
</head>
<body class="profile">
<%@ include file="navadmin.jsp" %>

	<table>
		<tr>		
			<td>Job ID</td>
			<td><s:property value="job_id" /></td>
		</tr>
		<tr>		
			<td>Position</td>
			<td><s:property value="job_position" /></td>
		</tr>
		<tr>		
			<td>Company</td>
			<td><s:property value="job_company" /></td>
		</tr>
		<tr>		
			<td>Description</td>
			<td><s:property value="job_description" /></td>
		</tr>
		<tr>		
			<td>Requirements</td>
			<td><s:property value="job_requirement" /></td>
		</tr>
		<tr>		
			<td>Posted By</td>
			<td><s:property value="posted_by" /></td>
		</tr>
		<tr>		
			<td>No. of Applicants</td>
			<td><s:property value="no_applied" /></td>
		</tr>
	</table>
	<br>
	<h5>Report of Applied Users:</h5>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Email</th>
			</tr>
		</thead>
		<s:iterator value="userlist">
 			<tr>
	 			<td><s:property value="id" /></td>
	 			<td><s:property value="firstname" /> <s:property value="lastname" /></td>
	 			<td><s:property value="email" /></td>	
 			</tr>
		</s:iterator>	
	</table>
	<br>
	<br>
	<a href="listjobs.action?submitType=admin&email=<s:property value="email" />">
				<button class="btn btn-primary">View Jobs</button>
			</a>
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>