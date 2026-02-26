<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose</title>
</head>
<body>
	<c:if test="${not (empty param.kor or empty param.math) }">
		<c:set var="avg" value="${(param.kor + param.math)/2 }" />
		<c:choose>
			<c:when test="${avg >= 90 }">A학점임</c:when>
			<c:when test="${avg >= 80 and avg <90}">B학점임</c:when>
			<c:when test="${avg >= 70 and avg <80 }"> C학점임</c:when>
			<c:otherwise>F학점임</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>