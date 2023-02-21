<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<body style="background-color:#fffbf0;">
<center>
<table border="2">
<html:form action="studcrud">
<div style="text-align: right; position:relative;">
Search:<html:text property="first_name"  />
  <html:submit  property="submit" >search</html:submit><br><br><br>
</div>
<c:forEach items="${reslist}" var="list">

  <display:table export="true"   
        			name="stud" 
        			requestURI="/studcrud.do" pagesize="4" >

<tr>
	<td ><html:link action="/returnupdatedelete?idSelected=${list.id}"><c:out value="${list.id}" /></html:link></td>
	<td><c:out value="${list.first_name }" /></td>
	<td><c:out value="${list.last_name }" /></td>
	<td><c:out value="${list.dob }" /></td>
	<td><c:out value="${list.city }" /></td>
	<td><c:out value="${list.password }" /></td>
</tr>
  </display:table>
</c:forEach>
</table><br><br>

<html:link action="/pagination?page=1">1</html:link>
<html:link action="/pagination?page=2">2</html:link>
<html:link action="/pagination?page=3">3</html:link>
<html:link action="/pagination?page=4">4</html:link>
<!-- <input type="text" name="text"  placeholder="Search here!" property="submit">
  <input type="submit" name="search"  value="search" property="submit"> -->
  <%-- <div style="text-align: right; position:relative;">
Search:<html:text property="first_name"  />
  <html:submit  property="submit" >search</html:submit><br><br><br>
   </div> --%>
<h3> <a href="reg.jsp"><--Back </a></h3>
</html:form>	
</center>
</body>

