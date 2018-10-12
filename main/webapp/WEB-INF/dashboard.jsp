<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<a class="dash" href="/new">Add New</a>
		<a class="dash" href="/search/topTen">Top Songs</a>
		<form id="dash" action="/search" method="post">
			<input type="text" name="artist">
			<input type="submit" value="Search Artist">
		</form>
		<table>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${playlist}" var="play">
			<tr>
				<td><a href="/songs/${play.id}"><c:out value="${play.title}"/></a></td>
				<td><c:out value="${play.rating}"/></td>
				<td><a href="/delete/${play.id}">Delete</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>