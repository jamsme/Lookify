<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="dashboard">
		<a href="/dashboard">Dashboard</a>
		<form:form action="/new/playlist" method="post" modelAttribute="playlist">
		    <h5 class="red"><form:errors path="title"/></h5>
		    <h4><form:label path="title">Title</form:label></h4>
		    <p><form:input path="title"/></p>
		    <h5 class="red"><form:errors path="artist"/></h5>
		    <h4><form:label path="artist">Artist</form:label></h4>
		    <p><form:input path="artist"/></p>
		    <h5 class="red"><form:errors path="rating"/></h5>    
		    <h4><form:label path="rating">Rating (1-10)</form:label></h4>
		    <p><form:input type="number" path="rating"/></p>    
		    <input type="submit" value="Add Song"/>
	</form:form> 
	</div>
</body>
</html>