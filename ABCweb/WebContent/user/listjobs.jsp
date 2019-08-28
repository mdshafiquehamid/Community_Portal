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

		.panel{
			width:100%;
		}
		
		.skill{
		margin-bottom:5%;
		display: inline-block;
		}
	</style>
</head>
<body class="profile">
<%@ include file="navprofile.jsp" %>

<h1>Jobs Listing</h1>
 <div class="panel">
	<s:iterator value="joblist">
		<div class="card">
    		<div class="card-body">
    			<h3><s:property value="job_position" /></h3>
				<h4><s:property value="job_company" /></h4>
				<h5>Job description</h5>
				<p><s:property value="job_description" /></p>
				<h5>Job Requirements</h5>
				<p><s:property value="job_requirement" /></p>
				<br>
				<h5>Posted by <s:property value="posted_by" /></h5>
				<p>No. of Applicants : <s:property value="no_applied" /></p>
				<a href="applyjob.action?job_id=<s:property value="id" />&email=<s:property value="#session.email" />">
								<button class="btn btn-warning">Apply</button>
				</a>
    		</div>
  		</div>
  		<br>			
	</s:iterator>				
</div>


	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>