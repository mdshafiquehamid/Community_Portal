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
			width:80%;
			margin: auto;
		}
		
		.skill{
		margin-bottom:5%;
		display: inline-block;
		}
		
		.user{
			width:50%;
			
		}
		
		.recipient{
			width:50%;
		}
	</style>
</head>
<body class="profile">
<%@ include file="navprofile.jsp" %>
	
	<div class="row message-function">
	<div class="col-sm-7 message-area">
		<s:iterator value="messageslist">
			<s:if test="user_email.equals(#session.email)">
			<div class="row">
				<div class="col-sm-6"></div>
				<div class="user col-sm-6">
				<div class="alert alert-dismissible alert-danger">
		    			<p><strong>You says</strong></p>
		    			<p><s:property value="message" /></p>
						<p><em><s:property value="sent_on" /></em></p>
	  			</div>
	  			</div>
	  		</div>	
		</s:if>
		<s:else>
			<div class="row">
			<div class="recipient col-sm-6">
				<div class=" alert alert-dismissible alert-success">
			    			<p><strong><s:property value="firstname" /> <s:property value="lastname" /> says</strong></p>
			    			<p><s:property value="message" /></p>
							<p><em><s:property value="sent_on" /></em></p>
		  			</div>
		  		</div>
		  		<div class="col-sm-6"></div>
	  		</div>
		</s:else>	
		</s:iterator>		
	</div>
	<div class="col-sm-5 message-type">
		<form action=replymessage method="post">
    	<table>
	    	<tr>
	    		<td><label for="message_reply" class="message-font">Message</label></td>
	    	</tr>
	    	<tr>
	    		<td><textarea rows="5" cols="48" id="message_reply" name="message_reply" required></textarea></td>
	    	</tr>
    	</table>
    		<input type="hidden" name="user_email" value='<s:property value="#session.email" />'>
    		<input type="hidden" name="user_id" value='<s:property value="user_id" />'><br>
    		<input type="hidden" name="recipient_id" value='<s:property value="recipient_id" />'>
    		<button name="submitType" value="reply" type="submit" class="btn btn-primary">Send</button>     			
    </form>
	</div>
	</div>
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>