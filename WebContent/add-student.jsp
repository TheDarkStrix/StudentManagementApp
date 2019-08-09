<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add Student
<form action="StudentControllerServlet" method="GET">
<input type="hidden" name="Command" value="ADD"/>
First Name : <input type="text" name="firstName"/>
Last Name : <input type="text" name="lastName"/>
Email : <input type="email" name="email"/>
<input type="submit" value="save"/>
</form>
<a href="StudentControllerServlet">Back to Students List</a>
</body>
</html>