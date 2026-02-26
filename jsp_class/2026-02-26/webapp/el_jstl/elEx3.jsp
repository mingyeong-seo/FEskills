<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="webprj.board1.dtos.BoardDTO"/>
<%
dto.setId("jason");
request.setAttribute("dto", dto);
request.setAttribute("reqScoP1", "값1");
request.setAttribute("reqScoP2", "값2");
%>

<!-- forward를 통해서 elEx4에 요청을 전달한다. 이때 파라미터도 같이 생성해서 보낸다 -->
<jsp:forward page="elEx4.jsp">
	<jsp:param value="hello" name="msg1"/>
	<jsp:param value="world" name="msg2"/>
</jsp:forward>