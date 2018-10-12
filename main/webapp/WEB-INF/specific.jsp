<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<h3>Title:</h3>
	<h4><c:out value="${playlist.title}"/></h4>
	<h3>Artist:</h3>
	<h4><c:out value="${playlist.artist}"/></h4>
	<h3>Rating:</h3>
	<h4><c:out value="${playlist.rating}"/></h4>
</body>
</html>