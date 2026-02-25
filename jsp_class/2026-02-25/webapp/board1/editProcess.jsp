<%@page import="webprj.util.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "IsLoggedIn.jsp"/>
<jsp:useBean id="dao" class="webprj.board1.daos.BoardDAO"/>
<jsp:useBean id="dto" class="webprj.board1.dtos.BoardDTO"/>

<jsp:setProperty property = "*" name="dto"/>

<%
int res = dao.updateArticle(dto);
dao.close();

if(res ==1) {
	response.sendRedirect("content.jsp?num="+dto.getNum());
} else {
	JSFunction.alertBack("수정 실패", out);
}
%>