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

<div class="jumbotron jumbo_background">
  <div class="row">
  	<div class="col-sm-8 jumbo-message">
  		<h3><s:property value="currentuser.firstname" /> <s:property value="currentuser.lastname" /></h3>
  		<h3><s:property value="currentuser.position" /></h3>
  		<h3><s:property value="currentuser.company" /></h3>
  		<h3><s:property value="currentuser.country" />, <s:property value="currentuser.city" /></h3>
  	</div>
    <div class="col-sm-4">
    	<div class="row" >
    			<a href="viewprofile.action?submitType=updatedata&email=<s:property value="email" />">
						<button class="btn btn-primary">View Profile</button>
				</a>
    	</div>
		<br>
    	<div class="row" >
    	   		<a href="vieweditprofile.action?submitType=vieweditprofile&email=<s:property value="email" />">
						<button class="btn btn-primary">Edit Profile</button>
				</a>
    	</div>
  	</div>
  </div>
</div>
	<div class="row main-frame">
    	<div class="col-sm-4">
          	<div class="card">
          	 	<h2 class="card-header bg-primary mb-3 text-white">Message Board</h2>
    			<div class="card-body">
    				<p><a href="userlistthreads.action?email=<s:property value="email" />">List Threads</a></p>
    				<p><a href="usercreatethread.action?submitType=new&email=<s:property value="email" />">Post New Thread</a></p>
    			</div>
    		</div>
    	</div>
    	<div class="col-sm-4">
          	<div class="card">
          	 	<h2 class="card-header bg-success mb-3 text-white">Jobs</h2>
    			<div class="card-body">
    				<p><a href="listjobs.action?submitType=user&email=<s:property value="email" />">View Jobs</a></p>
    				<p><a href="postjob.action?submitType=new&email=<s:property value="email" />">Post New Job</a></p>
    			</div>
    		</div>
    	</div>
    	<div class="col-sm-4">
    		<div class="card">
    			<h2 class="card-header bg-danger mb-3 text-white">Projects</h2>
    			<div class="card-body">
					<p><a href="userlistprojects.action?email=<s:property value="email" />">View Projects</a></p>
					<p><a href="userpostproject.action?submitType=new&email=<s:property value="email" />">Post New Project</a></p>
    			</div>
    		</div>
    	</div>
    	</div>
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>