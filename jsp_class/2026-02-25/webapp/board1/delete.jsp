<%@page import="webprj.util.JSFunction"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="webprj.board1.daos.BoardDAO"/>


<%
int num = Integer.parseInt(request.getParameter("num"));
int res = dao.deleteArticle(num);
dao.close();


if(res ==1) {
	response.sendRedirect("list.jsp");
} else {
	JSFunction.alertBack("삭제 실패", out);
}

%>