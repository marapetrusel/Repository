<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
<h1>
	<form:form action="http://localhost:8080/usermanagement/login" commandName="logindata" method="POST">
		<label for="username">Username: </label>
		<form:input path="username"/><BR>
		<label for="form:password">Password: </label>
		<form:password path="password"/><BR>
		
		<input type="submit" name="Submit"/>
		
	</form:form>

</h1>

</body>
</html>