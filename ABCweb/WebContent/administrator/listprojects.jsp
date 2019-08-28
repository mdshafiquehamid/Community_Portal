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
	 		<th>Project ID</th>
	 		<th>Title</th>
	 		<th>Description</th>
	 		<th>Requirements</th>
	 		<th>Posted By</th>
	 	</tr>
 	</thead>
 		<s:iterator value="projectlist">
 			<tr>
	 			<td><s:property value="id" /></td>
	 			<td><s:property value="project_title" /></td>
	 			<td><s:property value="project_description" /></td>
	 			<td><s:property value="project_requirement" /></td>
	 			<td><s:property value="posted_by" /></td>
 			</tr>
		</s:iterator>	
 	
			
</table>


	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>