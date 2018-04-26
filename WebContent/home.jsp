<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Database SQL DAO Pattern</h1>
	<hr>
	<form action="HomeController" method="POST">
		<input placeholder="Username" type="text" name="username">
		<input placeholder="Password" type="text" name="password">
		<input placeholder="email" type="text" name="email">
		<input type="submit" value="Submit">
	</form>
	<hr>
	
	<c:forEach var="list_data" items="${data}">
		
		<li>
		${list_data.username} ${list_data.password} (${list_data.email})
		</li>
		
	</c:forEach>
</body>
</html>