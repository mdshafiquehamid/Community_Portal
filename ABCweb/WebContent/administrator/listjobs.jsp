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

<h1>Jobs Listing</h1>
 <table>
 	<thead>
	 	<tr>
	 		<th>Job ID</th>
	 		<th>Position</th>
	 		<th>Company</th>
	 		<th>Description</th>
	 		<th>Requirements</th>
	 		<th>Posted By</th>
	 		<th>No. of Applicants</th>
	 	</tr>
 	</thead>
 		<s:iterator value="joblist">
 			<tr>
	 			<td><s:property value="id" /></td>
	 			<td><s:property value="job_position" /></td>
	 			<td><s:property value="job_company" /></td>
	 			<td><s:property value="job_description" /></td>
	 			<td><s:property value="job_requirement" /></td>
	 			<td><s:property value="posted_by" /></td>
	 			<td><s:property value="no_applied" /></td>
	 			<td><a href="viewresponses.action?job_id=<s:property value="id" />
	 							&email=<s:property value="#session.email" />
	 							&job_position=<s:property value="job_position" />
	 							&job_company=<s:property value="job_company" />
	 							&job_description=<s:property value="job_description" />
	 							&job_requirement=<s:property value="job_requirement" />
	 							&posted_by=<s:property value="posted_by" />
	 							&no_applied=<s:property value="no_applied" />">
						<button class="btn btn-warning">View Responses</button>
					</a></td>	
 			</tr>
 				
		</s:iterator>	
 	
			
</table>


	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>