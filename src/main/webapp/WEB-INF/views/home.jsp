<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Spittr</title>
	</head>
<body>
	<spring:escapeBody htmlEscape="true">
		<h1>Welcome to Spittr</h1>
	</spring:escapeBody>
	<h1>Welcome to Spittr</h1>
	
	<spring:url value="/spittles" var="spittlesUrl" >
		<spring:param name="max" value="60" />
		<spring:param name="count" value="20" />
	</spring:url>
	<a href="${spittlesUrl }">Spittles</a> | 
	<spring:url value="/spitter/register"  var="registerUrl" />
	<a href='${registerUrl }'>Register</a>
</body>
</html>