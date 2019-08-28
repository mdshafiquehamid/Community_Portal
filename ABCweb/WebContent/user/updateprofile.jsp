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
  			margin-top: 2%;
		}
		
		.panel{
			width:95%;
			margin-left: 2%;
		}
		
		.skill{
		margin-bottom:5%;
		display: inline-block;
		}
		
		.skill-area, .experience-area{
		margin-top: 2%;
		}
	</style>
</head>
<body class="profile">
<%@ include file="navprofile.jsp" %>
<div class="flex-container">
  <div>
  	 <div class="card">
    	<div class="card-body">
    		<h3>Profile</h3>
    		<form action=vieweditprofile method="post">
    		 	<div class="card">
    			<div class="card-body">
    			<table>
	    			<tr>
	    				<td><label class="bolded" for="firstname">First Name</label></td>
	    				<td><input id="firstname" type="text" name="firstname" value='<s:property value="userprofile.firstname"/>'></td>
	    			</tr>
	    			<tr>
	    				<td><label class="bolded" for="lastname">Last Name</label></td>
	    				<td><input id="lastname" type="text" name="lastname" value='<s:property value="userprofile.lastname"/>'></td>
	    			</tr>
	    			<tr>
	    				<td><label class="bolded" for="email">Email</label></td>
	    				<td><input id="email" type="text" name="email" value='<s:property value="userprofile.email"/>'></td>
	    			</tr>
	    			<tr>
	    				<td><label class="bolded" for="position">Job Position</label></td>
	    				<td><input id="position" type="text" name="position" value='<s:property value="userprofile.position"/>'></td>
	    			</tr>
	    			<tr>
	    				<td><label class="bolded" for="company">Company</label></td>
	    				<td><input id="company" type="text" name="company" value='<s:property value="userprofile.company"/>'></td>
	    			</tr>
	    			<tr>
	    				<td><label class="bolded" for="country">Country</label></td>
	    				<td><input id="country" type="text" name="country" value='<s:property value="userprofile.country"/>'></td>
	    			</tr>
	    			<tr>
	    				<td><label class="bolded" for="city">City</label></td>
	    				<td><input id="city" type="text" name="city" value='<s:property value="userprofile.city"/>'></td>
	    			</tr>
    			</table>
    			</div>
    			</div>
    			<input type="hidden" name="emailhidden" value='<s:property value="userprofile.email"/>'><br>
    			<button name="submitType" value="update" type="submit" class="btn btn-success">Update</button>     			
    		</form>
    			<br>
    				<a href="viewprofile.action?submitType=updatedata&email=<s:property value="userprofile.email" />">
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
    	</div>
    </div>
  </div>
  <div class="panel">
  	 <div class="card">
    	<div class="card-body">
    		<div class="row">
    			<div class="col-sm-10">
    				<h3>Qualifications</h3>
    			</div>
    			<div class="col-sm-2">
    				<span class="newbutton">
					<a href="updatequalification.action?submitType=newdata&email=<s:property value="userprofile.email" />">
						<button class="btn btn-primary">New</button>
					</a>
				</span>
    			</div>
    		</div>
			 	<s:iterator value="qualifications">
					<div class="card">
    					<div class="card-body">
    						<h5 class="bolded"><s:property value="qualification_type" /> in <s:property value="qualification" /></h5>
							<p><s:property value="qualification_description" /></p>
							<a href="updatequalification.action?submitType=viewdata&id=<s:property value="id" />&email=<s:property value="userprofile.email" />">
								<button class="btn btn-warning">Edit</button>
							</a>
							<a href="delete.action?submitType=qualification&id=<s:property value="id" />&email=<s:property value="userprofile.email" />">
								<button class="btn btn-danger">Delete</button>
							</a>
    					</div>
  					</div>
  					<br>			
				</s:iterator>		
    	</div>
   	</div>
    	<div class="card experience-area">
    		<div class="card-body">
    			<div class="row">
    				<div class="col-sm-10">
    					<h3>Experiences</h3>
    				</div>
    				<div class="col-sm-2">
    				<span class="newbutton">
						<a href="updateexperience.action?submitType=newdata&email=<s:property value="userprofile.email" />">
							<button class="btn btn-primary">New</button>
						</a>
					</span>
    				</div>
    			</div>
					<s:iterator value="experiences">
						<div class="card">
    						<div class="card-body">
    							<h5 class="bolded"><s:property value="experience_position" /></h5>
								<h6><s:property value="experience_company" /></h6>
								<h6><s:property value="experience_country" /></h6>
								<h6><em><s:property value="duration" /></em></h6>
								<p><s:property value="experience_description" /></p>
								<a href="updateexperience.action?submitType=viewdata&id=<s:property value="id" />&email=<s:property value="userprofile.email" />">
									<button class="btn btn-warning">Edit</button>
								</a>
								<a href="delete.action?submitType=experience&id=<s:property value="id" />&email=<s:property value="userprofile.email" />">
									<button class="btn btn-danger">Delete</button>
								</a>
    						</div>
  						</div>
  						<br>			
					</s:iterator>			
    		</div>
  		</div>
  		<div class="card skill-area">
    		<div class="card-body">
    			<div class="row">
    				<div class="col-sm-10">
    					<h3>Skills</h3>
    				</div>
    				<div class="col-sm-2">
    				<span class="newbutton">
						<a href="updateskill.action?submitType=newdata&email=<s:property value="userprofile.email" />">
							<button class="btn btn-primary">New</button>
						</a>
					</span>
    				</div>
    			</div>
				<br>
    				<s:iterator value="skills">
    					<div class="skill">
    					   <span class="alert alert-dismissible alert-success ">
    					   		<a href="delete.action?submitType=skill&id=<s:property value="id" />&email=<s:property value="userprofile.email" />">
									<button type="button" class="close">&times;</button>
								</a>
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