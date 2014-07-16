<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
 <title>Login Page</title>
 <link rel="stylesheet" type="text/css" href="resources/viewcss.css">
</head>
<body>
	<c:url value="/login" var="myurl"/>
	
	<%-- <form:form action="http://localhost:8080/usermanagement/login" commandName="logindata" method="POST"> --%> 
	
	<div id="wrapper"><form:form cssClass="formclass" action="${myurl}" commandName="logindata" method="POST">	
		<h1>LOGIN</h1>
		<div class="formdiv">
			<form:input class="input" path="username"/>
			<form:password class="input" path="password"/>
		</div>
		
		<button id="submitbutton"></button>
		
	</form:form></div>
</body>
</html>