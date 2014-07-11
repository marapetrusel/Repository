<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
<c:url value="/login" var="myUrl"/>
<div class= "wrapper">
<form:form action= "${myUrl}" commandName="user" method="POST" >
	<label for="username">
	Username
	</label>
	
	<form:input path="username"/>
	
	<label for="password">
	Password
	</label>
	
	<form:password path="password"/>
	
	<button class="button" type="submit"></button>  
</form:form>
</div>
</body>
</html>
