<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring3Example</title>
</head>
<body>
	<h1>
		Welcome
		<core:out value="${loginForm.userName}" />
	</h1>

	<table>
		<tr>
			<td><a href="loginform.html">Back</a></td>
		</tr>
	</table>

	<core:if test="${not empty lists}">
		<h3>List of Employees.....</h3>
		<table>
			<tr>
				<td><b>UserName</b></td>
				<td><b>Password</b></td>
				<td><b>EmailId</b></td>
			</tr>
			<core:forEach var="listValue" items="${lists}">
				<tr>
					<td>${listValue.getUserName()}</td>
					<td>${listValue.getUserPassword()}</td>
					<td>${listValue.getEmail()}</td>
				</tr>
			</core:forEach>

		</table>

	</core:if>
</body>
</html>