<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body style="background-color:#fffbf0;">
<center>
<table border="1">
<tr>
	<th>ID</th>
	<th>first_name</th>
	<th>last_name</th>
	<th>dob</th>
	<th>city</th>
	<th>Password</th>
</tr>
<c:forEach items="${reslist }" var="list">
<tr>
	<td><c:out value="${list.id }" /></td>
	<td><c:out value="${list.first_name}" /></td>
	<td><c:out value="${list.last_name }" /></td>
	<td><c:out value="${list.dob }" /></td>
	<td><c:out value="${list.city }" /></td>
	<td><c:out value="${list.password }" /></td>
</tr>
</c:forEach>
</table>
<h3> <a href="reg.jsp"><--Back </a></h3>
</center>
</body>
</html>