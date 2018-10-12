<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="css/style.css" type="text/css">
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h3>Songs by: <c:out value="${artist}"/></h3>
	<table>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${song}" var="play">
		<tr>
			<td><a href="/songs/${play.id}"><c:out value="${play.title}"/></a></td>
			<td><c:out value="${play.rating}"/></td>
			<td><a href="/delete/${play.id}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>