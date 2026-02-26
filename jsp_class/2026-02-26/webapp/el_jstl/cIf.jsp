<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="num" value="100"/>
<c:set var="str" value="hell"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- if:test 라는 속성에 조건식을 걸고, 그 값을 var라는 속성 변수에 대입시키는 구문
else는 없으며 오직 if만 존재한다.. if 내부에 if를 중첩할 수는 있다. -->
<c:if test="${num % 2 eq 0 }" var ="res"> <!-- num %2 시 0과 같나? test, 결과값 0은 res에 대입된다. -->
	${num }은 짝수임.. 여긴 test가 true 일 때만 나온다
</c:if>
${res } <br>

<c:if test="${str eq 'hell' }">
	${"나올까?" }
</c:if>
</body>
</html>