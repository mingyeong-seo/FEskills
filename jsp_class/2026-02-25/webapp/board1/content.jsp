<%@page import="webprj.board1.dtos.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "IsLoggedIn.jsp" %>
<jsp:useBean id="dao" class = "webprj.board1.daos.BoardDAO"/>
<%
// 파라미터 get, update 실행, DTO GET
String num = request.getParameter("num");
int bnum=0;
if(num != null){
	bnum = Integer.parseInt(num);
}
dao.updateVisitCount(bnum);
BoardDTO dto = dao.getArticle(bnum);
dao.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "../Common/link.jsp"/>

<h2>회원제 게시판-상세보기</h2>
<!-- 글 수정 or 삭제로 분기될 수 있기 때문에 form을 사용해서 처리를 한다 -->
<form name = "writeFrm">
	<!-- 글 수정이나 삭제 시 글 번호를 파람으로 넘겨야 함. 
	때문에 글 번호를 hidden 필드에 담아서 넘김 -->
	<input type ="hidden" name = "num" value = "<%=num%>">
	<table border = "1" width="90%">
		<tr>
			<td>번호</td>
			<td><%=dto.getNum() %></td>
			<td>작성자</td>
			<td><%=dto.getName() %></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td><%=dto.getPostdate() %></td>
			<td>조회수</td>
			<td><%=dto.getVisitcount() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="3"><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<!-- 사용자가 textarea에서 엔터를 치면 문자열 안에 \r\n이 저장되고, 
			그걸 브라우저에서 줄바꿈으로 보이게하려고 <br>로 바꾸는 것 -->
			<td colspan="3"><%=dto.getContent().replace("\r\n", "<br>")%></td> 
		</tr>
		
		<tr>
			<td colspan = "4" align="center">
				<%
				// 세션 검증을 하고, 세션의 값과, dto의 값이 같으면 수정, 삭제 버튼 visible 처리
					if(session.getAttribute("userId") != null &&
					session.getAttribute("userId").toString().equals(dto.getId())){
				%>
				<button type="button"
				onclick="location.href='edit.jsp?num=<%=dto.getNum()%>'">
				수정하기
				</button>
				<button type="button"
				onclick="location.href='delete.jsp?num=<%=dto.getNum()%>'">
				삭제하기
				</button>
				<%
					} // end of edit button 
				%>
				<button type="button" onclick="location.href='list.jsp'">
				목록으로
				</button>
			</td>
		</tr>
	</table>
	
</form>

</body>
</html>