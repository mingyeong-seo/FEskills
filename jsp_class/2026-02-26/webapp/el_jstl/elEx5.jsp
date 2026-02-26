<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="webprj.board1.dtos.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL 을 이용한 Collection 데이터 get</h2>
<%
BoardDTO dto = new BoardDTO();
dto.setId("jason");
List<Object>aList = new ArrayList();
aList.add("hello");
aList.add(dto);
pageContext.setAttribute("col", aList);

// 이번엔 Map 타입 객체를 생성해서 사용하는 방법 알아보기
Map<String, String> map = new HashMap();
map.put("a","abc");
map.put("b","def");

request.setAttribute("mymap", map);

// 위 mymap을 EL로 출력하도록 elEx6.jsp로 포워딩 하시오

%>
<%--<jsp:forward page="elEx6.jsp"/>--%>
		

<h3>List 타입의 객체 Access</h3>
${col[0] }<br>
${col[1].id }<br> 

${empty myObj } <!-- 데이터 null여부 검사할때 사용 -->
</body>
</html>