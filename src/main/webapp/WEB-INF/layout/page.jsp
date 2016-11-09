<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/style.css" />' >
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<div id="content">
		<tiles:insertAttribute name="body" /><!-- base를 확장한 attribute name이 body인 definition중에서 컨트롤러가 반환한 이름을 표시. -->
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>