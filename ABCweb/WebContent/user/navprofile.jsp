<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="#">ABC</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
      <form action="search.action" method="post" class="form-inline my-2 my-lg-0">
      	<input class="form-control mr-sm-2" type="text" placeholder="Search" name="searchquery">
     	<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="signin.action?password=<s:property value="#session.password" />&email=<s:property value="#session.email" />">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="vieweditprofile.action?submitType=vieweditprofile&email=<s:property value="#session.email" />">Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="userlistthreads.action?email=<s:property value="#session.email" />">Message Board</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listjobs.action?submitType=user&email=<s:property value="#session.email" />">Jobs</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="userlistprojects.action?email=<s:property value="#session.email" />">Projects</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="signout.action">Sign Out</a>
      </li>
    </ul>

  </div>
</nav>
</body>
</html>