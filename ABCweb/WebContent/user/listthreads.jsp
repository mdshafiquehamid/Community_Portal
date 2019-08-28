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
<div class="row messageboard-header">
	<div class="col-sm-10 ">
		<h1 class="messageboard-text">Message Board</h1>
	</div>
	<div class="col-sm-2">
		<a href="usercreatethread.action?submitType=new&email=<s:property value="#session.email" />">
						<button class="btn btn-primary">New Thread</button></a>
	</div>
</div>
<table class="table table-hover message-table">
	<thead>
		<tr class="table-primary">
			<th scope="col">Thread</th>
			<th scope="col">Posted By</th>
			<th scope="col">Posted On</th>
		</tr>		
	</thead>

	<s:iterator value="threadlist">
		<tr class="table-light">
			<td class="thread_title">
				<a href="userreplythread.action?submitType=list&thread_id=<s:property value="id" />&email=<s:property value="#session.email" />">
					<s:property value="thread_message" />
				</a>
			</td>
			<td><s:property value="posted_by" /></td>
			<td><s:property value="posted_on" /></td>
		</tr>
	</s:iterator>
</table>				
	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>