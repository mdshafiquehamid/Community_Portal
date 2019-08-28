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
			margin-left: 4%;
			margin-right: 4%;
		}
		
		.skill{
		margin-bottom:5%;
		display: inline-block;
		}
		
		.form-panel{
			margin-left: 3%;
			margin-right: 4%;
		}
	</style>
</head>
<body class="profile">
<%@ include file="navadmin.jsp" %>
	
	<h1 class="heading">Thread</h1>
	
	<div class="panel">
		<div class=" thread-header row text-white bg-dark">
			<strong class="posted_date"><s:property value="thread.posted_on" /> (Thread Starter)</strong>
		</div>
		<div class="row thread-content">
	    	<div class="col-sm-2 thread_user">
	    		<p><s:property value="thread.posted_by" /></p>
	    	</div>
	    	<div class="col-sm-10 thread_message">
	    		<p><s:property value="thread.thread_message" /></p>
	    	</div>
	    </div>				
	</div>
	<br>	

	<div class="panel">
		<s:iterator value="replies">
				<div class="thread-header row text-white bg-dark">
					<strong class="posted_date">
						<s:property value="posted_on" />
					</strong>
				</div>
	    			<div class="row thread-content">
	    				<div class="col-sm-2 thread_user">
	    					<p><s:property value="thread.posted_by" /></p>
	    				</div>
	    				<div class="col-sm-10 thread_message">
	    					<p><s:property value="thread_message" /></p>
	    				</div>
	    			</div>
	  		<br>			
		</s:iterator>				
	</div>
	<form class="form-panel" action=adminreplythread method="post">
    	<table >
	    	<tr>
	    		<td><strong><label for="thread">Reply Message Board</label></strong></td>
	    	</tr>
	    	<tr>
	    		<td><textarea rows="10" cols="128" id="thread" name="thread_message" required></textarea></td>
	    	</tr>
    	</table>
    		<input type="hidden" name="thread_id" value='<s:property value="thread_id" />'>
    		<input type="hidden" name="email" value='<s:property value="#session.email" />'><br>
    		<button name="submitType" value="reply" type="submit" class="btn btn-primary">Post</button>     			
    </form>
    
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>