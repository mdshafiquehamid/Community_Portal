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

</style>
</head>
<body class="profile">
	<%@ include file="navprofile.jsp" %>
	<h1 class="heading">Results for "<s:property value="searchquery" />"</h1>
		<div class="table-content">
		<s:if test="noData==true">
			<table class="table table-hover">
				<thead>
					<tr class="table-primary">
						<th scope="col">No.</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Position</th>
						<th scope="col">Company</th>
						<th scope="col">Country</th>
						<th scope="col">City</th>
					</tr>
				</thead>
				<s:iterator value="userlist">
					<tr class="table-light">
						<td><s:property value="id" /></td>
						<td><s:property value="firstname" /></td>
						<td><s:property value="lastname" /></td>
						<td><s:property value="email" /></td>
						<td><s:property value="position" /></td>
						<td><s:property value="company" /></td>
						<td><s:property value="country" /></td>
						<td><s:property value="city" /></td>
						<td>
							<a href="viewprofile.action?submitType=updatedata&email=<s:property value="email" />">
								<button class="btn btn-warning">View Profile</button>
							</a>
						</td>
						<td>
							<a href="message.action?user_email=<s:property value="#session.email" />&recipient_email=<s:property value="email" />">
								<button class="btn btn-warning">Message</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No User Found.</div>
		</s:else>
	</div>

	<script src="Scripts/jquery-3.4.0.min.js"></script>
	<script src="Scripts/bootstrap.min.js"></script>
</body>
</html>