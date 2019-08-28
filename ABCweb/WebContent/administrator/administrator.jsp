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
	<%@ include file="navadmin.jsp" %>

<div class="jumbotron jumbo_background admin_jumbo">
  	<h3>Hello</h3>
  	<h3><s:property value="currentuser.firstname" /></h3>
</div>
	<div class="row main-frame">
    	<div class="col-sm-3">
          	<div class="card">
    			<div class="card-body">
    				<h2>Users</h2>
    				<br>
    				<p><a href="adminlist.action?searchquery=All Users">List All Users</a></p>
    			</div>
    		</div>
    	</div>
    	<div class="col-sm-5">
    		<div class="card">
    			<div class="card-body">
					<h2>Opportunities</h2>
					<br>
					<div class="row">
						<div class="col-sm-6">
						   <p><a href="listjobs.action?submitType=admin&email=<s:property value="email" />">View Jobs & Responses</a></p>
						</div>
						<div class="col-sm-6">
						   <p><a href="adminpostjob.action?submitType=new&email=<s:property value="email" />">Post New Job</a></p>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
						   <p><a href="adminlistprojects.action?email=<s:property value="email" />">View Projects</a></p>
						</div>
						<div class="col-sm-6">
						   <p><a href="adminpostproject.action?submitType=new&email=<s:property value="email" />">Post New Project</a></p>
						</div>
					</div>
    			</div>
    		</div>
    	</div>
    	<div class="col-sm-4">
    		<div class="card">
    			<div class="card-body">
					<h2>Message Board</h2>
					<br>
					<div class="row">
						<div class="col-sm-6">
						   <p><a href="adminlistthreads.action?email=<s:property value="email" />">View Threads</a></p>
						</div>
						<div class="col-sm-6">
						   
						</div>
					</div>
    			</div>
    		</div>
    	</div>
    	</div>
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>