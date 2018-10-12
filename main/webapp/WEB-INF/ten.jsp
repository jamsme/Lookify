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
	<h3>Top 10 Songs:</h3>
	<c:forEach items="${song}" var="play">
		<h4><c:out value="${play.rating}"/>-<c:out value="${play.title}"/>-<c:out value="${play.artist}"/></h4>
	</c:forEach>
</body>
</html>