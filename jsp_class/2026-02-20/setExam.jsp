<%@ page import="webprj.dtos.UserDTO" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 책에 없다 -->
	<h2>Scope 저장 페이지</h2>
<% 
UserDTO user = new UserDTO();
user.setId("jason");
user.setPw("1234");

request.setAttribute("user", user);
request.getRequestDispatcher("resSocpe.jsp").forward(request, response);

%>
</body>
</html>