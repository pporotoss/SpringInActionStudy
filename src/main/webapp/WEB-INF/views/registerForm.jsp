<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Register</h1>
	
	<form:form method="POST" commandName="spitter">
		<form:errors path="*" element="div" cssClass="errors" />
		
		<form:label path="firstName" cssErrorClass="error">First Name</form:label>:  
		<form:input path="firstName" cssErrorClass="error" />
			<form:errors path="firstName" cssClass="error"/><br>
		<form:label path="lastName" cssErrorClass="error">Last Name</form:label>: 
		<form:input path="lastName" cssErrorClass="error" /><br>
		<form:label path="email" cssErrorClass="error">Email</form:label>:
		<form:input path="email" type="email" cssErrorClass="error" /><br>
		<form:label path="username" cssErrorClass="error">Username</form:label>:
		<form:input path="username" cssErrorClass="error" /><br>
		<form:label path="password" cssErrorClass="error">Password</form:label>:
		<form:input path="password" cssErrorClass="error" /><br>
		<input type="submit" value="Register" />
	</form:form>	
</body>
</html>