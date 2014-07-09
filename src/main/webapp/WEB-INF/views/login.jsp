<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
<h1>
Login Page
</h1>

<form name="login">
Username <input type="text" name="userid"/>
<br>
<br>
Password <input type="password" name="pass"/>
<br>
<br>
<input type="button" onclick="check(this.form)" value="Login"/>

<input type="reset" value="Cancel"/>
</form>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
