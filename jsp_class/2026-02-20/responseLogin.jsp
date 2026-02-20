<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 파라미터 get
String id = request.getParameter("id");
String pw = request.getParameter("pw");

// 암호와 ID 검증 로직 작성
if(id.equalsIgnoreCase("fs") && pw.equals("1234")) {
	response.sendRedirect("responseWelcome.jsp"); //파라미터 못 보낸다
} else {
	// 요청 재전송 이라는 개념
	 request.getRequestDispatcher("respMain.jsp?loginErr=1").forward(request,response);
}
%>
</body>
</html>