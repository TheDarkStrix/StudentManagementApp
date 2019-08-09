<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Update Student
<form action="StudentControllerServlet" method="GET">
<input type="hidden" name="Command" value="UPDATE"/>
<input type="hidden" name="studentId" value="${THE_STUDENT.id}"/>
First Name : <input type="text" value="${THE_STUDENT.firstName}" name="firstName"/>
Last Name : <input type="text" value="${THE_STUDENT.lastName}" name="lastName"/>
Email : <input type="email" value="${THE_STUDENT.email}" name="email"/>
<input type="submit" value="save"/>
</form>
<a href="StudentControllerServlet">Back to Students List</a>
</body>
</html>