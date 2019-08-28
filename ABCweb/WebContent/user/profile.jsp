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
			width:80%;
			margin:auto;
			margin-top: 2%;
		}
		
		.skill{
		margin-bottom:5%;
		display: inline-block;
		}
		
		.non-bolded{
		font-weight: 300;
		}
		
		.inner-panel{
		margin-top: 2%;
		}
	</style>
</head>
<body class="profile">
<%@ include file="navprofile.jsp" %>
  <div class="profile-area">
  	 <div class="card area">
    	<div class="card-body">
    		<h2><s:property value="userprofile.firstname" /> <s:property value="userprofile.lastname" /></h2>
    		<h4 class="non-bolded"><s:property value="userprofile.position" /> at <s:property value="userprofile.company" /></h4>
			<h4 class="non-bolded"><s:property value="userprofile.country" />, <s:property value="userprofile.city" /></h4>
			<h4>Contact Me : <span class="non-bolded"><s:property value="userprofile.email" /></span> </h4>	
    	</div>
    </div>
  </div>
  <div class="panel">
  	 <div class="card">
    	<div class="card-body">
			<h3>Qualifications</h3>
			<s:iterator value="qualifications">
				<div class="profile-details">
    				<h5 class="bolded"><s:property value="qualification_type" /> in <s:property value="qualification" /></h5>
					<p><s:property value="qualification_description" /></p>	
    			</div>			
			</s:iterator>				
    	</div>
   </div>
    	<div class="card inner-panel">
    		<div class="card-body">
    			<h3>Experiences</h3>
					<s:iterator value="experiences">
						<div class="profile-details">
    							<h5 class="bolded"><s:property value="experience_position" /></h5>
								<h6><s:property value="experience_company" /></h6>
								<h6><s:property value="experience_country" /></h6>
								<h6><em><s:property value="duration" /></em></h6>
								<p><s:property value="experience_description" /></p>
  						</div>		
					</s:iterator>			
    		</div>
  		</div>
  		<div class="card inner-panel">
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

	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>