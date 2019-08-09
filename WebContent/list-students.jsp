<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, StudentManagementJDBC.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input type="button" Value="Add Student" onclick="window.location.href='add-student.jsp';">
<table>
<tr>
<th>First Name</th>
<th>Last Name Name</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="tempStudent"  items="${STUDENT_LIST}">
<c:url var="tempLink" value="StudentControllerServlet">
<c:param name="Command" value="LOAD"/>
<c:param name="studentId" value="${tempStudent.id}"/>
</c:url>
<tr>
<td>${tempStudent.firstName}</td>
<td>${tempStudent.lastName}</td>
<td>${tempStudent.email}</td>
<td><a href="${tempLink}">Update</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>