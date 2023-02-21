<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
<title>Reg page</title>
</head>
<center>
<pre>
<h1 style="border:2px solid black;height:50px;width:500px; font-size:20pt;"> Registration Form</h1>
<html:form action="studcrud">
<pre>		
<%-- id : <html:text property="id" /><html:errors property="id" /> --%>

First_Name:<html:text property="first_name" />
             <html:errors property="first_name" />

Last_Name: <html:text property="last_name" />
           <html:errors property="last_name" />

DOB:<html:text property="dob"></html:text>
       <html:errors property="dob" /> 
       format(yyyy/MM/dd )
 

City: <html:select property="city" > 
    			<option value="PU">Pune</option>
 
    			<option value="ND">Nanded</option>
 
    			<option value="ST">Satara</option>
    			<option value="ST">Kolhapur</option>
</html:select><br><html:errors property="city" />
Password:    <html:password property="password" />
             <html:errors property="password" />

<html:submit property="submit">save</html:submit><br>	
<html:submit property="submit" >search</html:submit><br>
<html:link action="/pagination?page=1">findAll</html:link>

</pre>	
</html:form>
</pre>
</center>
</body>

</html>