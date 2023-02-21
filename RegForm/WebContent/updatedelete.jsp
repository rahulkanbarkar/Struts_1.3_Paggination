<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<body style="background-color:#fffbf0;">
<html:form action="/studcrud">
<center>

<table border="2">
<tr>
	<th>ID</th>
	<th>first_name</th>
	<th>last_name</th>
	<th>dob</th>

	<th>city</th>
	<th>Password</th>
</tr>
<c:forEach items="${updatelist}" var="list">
<tr>
	<td><html:link action="/returnupdatedelete">Edit <c:out value="${list.id }" /></html:link></td>
	<%-- <td><c:out value="${list.name }" /></td>
	<td><c:out value="${list.email }" /></td>
	<td><c:out value="${list.gender }" /></td>
	<td><c:out value="${list.username }" /></td>
	<td><c:out value="${list.password }" /></td> --%>
	<td ><input type="text" name="first_name"  value='<c:out value="${list.first_name }"/>' /></td>
	<td><input type="text" name="last_name"  value='<c:out value="${list.last_name }"/>' /></td>
	<td><input type="text" name="dob"  value='<c:out value="${list.dob}"/>' /></td>
	<td><input type="text" name="city" value='<c:out value="${list.city }"/>' /></td>
	<td><input type="text" name="password" value='<c:out value="${list.password }"/>' /></td>
	
	<td><input name="id" type="hidden" value='<c:out value="${list.id }"/>' /></td>
	<td><input name="first_name" type="hidden" value='<c:out value="${list.first_name }"/>' /></td>
	<td><input name="last_name" type="hidden" value='<c:out value="${list.last_name }"/>' /></td>
	<td><input name="dob" type="hidden" value='<c:out value="${list.dob}"/>' /></td>
	<td><input name="city" type="hidden" value='<c:out value="${list.city }"/>' /></td>
	<td><input name="password" type="hidden" value='<c:out value="${list.password }"/>' /></td>
</tr>
</c:forEach>
</table><br><br>
      

<center>
 <html:submit property="submit">update</html:submit><br><br>
        <html:submit property="submit">delete</html:submit></center><br>
  
 <%--  <html:submit property="submit">findAll</html:submit> --%>

</html:form>
</body>

       
</html>