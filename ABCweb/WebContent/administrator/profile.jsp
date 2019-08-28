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
		.flex-container {
  			display: flex;
		}
		
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
<%@ include file="navadmin.jsp" %>
<div class="flex-container">
  <div>
  	 <div class="card">
    	<div class="card-body">
    		<p><s:property value="userprofile.firstname" /> <s:property value="userprofile.lastname" /></p>
    		<p><s:property value="userprofile.position" /></p>
    		<p><s:property value="userprofile.email" /></p>
			<p><s:property value="userprofile.company" /></p>
			<p><s:property value="userprofile.country" /></p>
			<p><s:property value="userprofile.city" /></p> 		
    	</div>
    </div>
  </div>
  <div class="panel">
  	 <div class="card">
    	<div class="card-body">
			<h1>Qualifications</h1>
			<s:iterator value="qualifications">
				<div class="card">
    				<div class="card-body">
    					<h5><s:property value="qualification_type" /> in <s:property value="qualification" /></h5>
						<p><s:property value="qualification_description" /></p>	
    				</div>
  				</div>
  				<br>			
			</s:iterator>				
    	</div>
   </div>
    	<div class="card">
    		<div class="card-body">
    			<h1>Experiences</h1>
					<s:iterator value="experiences">
						<div class="card">
    						<div class="card-body">
    							<h5><s:property value="experience_position" /></h5>
								<h6><s:property value="experience_company" /></h6>
								<h6><s:property value="experience_country" /></h6>
								<h6><em><s:property value="duration" /></em></h6>
								<p><s:property value="experience_description" /></p>
    						</div>
  						</div>
  						<br>			
					</s:iterator>			
    		</div>
  		</div>
  		<div class="card">
    		<div class="card-body">
    			<h1>Skills</h1>
    			<br>
    				<s:iterator value="skills">
    					<div class="skill">
    					   <span class="alert alert-dismissible alert-success ">
  								<s:property value="skill" />
    						</span>
    					</div>
    				</s:iterator>	
    		</div>
  		</div>
	</div>
</div>

	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>