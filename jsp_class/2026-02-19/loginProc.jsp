<%@page import="java.util.Enumeration"%>
<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입 처리를 위한 JSP</h2>
<%
String id = request.getParameter("signupId");
String name = request.getParameter("signupName");
String add1 = request.getParameter("signupAddr1");
String add2 = request.getParameter("signupAddr2");

%>
<h3>전달된 값</h3>
ID : <%=id %> <br>
name : <%=name %> <br>
add1 : <%=add1 %> <br>
add2 : <%=add2 %> <br>

<h3>파라미터 이름</h3>
<%
Enumeration<String> names = request.getParameterNames();
while(names.hasMoreElements()) {
	out.println(names.nextElement());
}

Map map = request.getParameterMap();
out.println(map);

out.println("<hr>");

Set es = map.entrySet();
out.println(es.size());

%>
<h3>요청 헤더 정보 알아보기</h3>
<%
Enumeration<String> headerEn = request.getHeaderNames();
while(headerEn.hasMoreElements()) {
	String key = (String)headerEn.nextElement();
	String value = request.getHeader(key);
	
	out.println(key + " : " + value + " <br>");
	
}
%>
<%=request.getPathInfo()%> <br>
<%=request.getContextPath()%> <br>
<%=request.getQueryString()%> <br>

</body>
</html>