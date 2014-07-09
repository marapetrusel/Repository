<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
<h1>
Login Page
</h1>
<c:url value="/login" var="myUrl"/>
<form:form action= "${myUrl}" commandName="user" method="POST" >
	<label for="username">
	Username
	</label>
	<form:input path="username"/>
	<br>
	<br>
	<label for="password">
	Password
	</label>
	<form:password path="password"/>
	<br>
	<input type="submit" value="Login" />
</form:form>




</body>
</html>
