<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
<h1>
	This if my first jsp app! :D
	
	<c:out value="${'Lets count to ten :D'}"/>
	<c:forEach var="i" begin="1" end="10">
		Item <c:out value="${i}"/><p>
	</c:forEach>
</h1>

</body>
</html>