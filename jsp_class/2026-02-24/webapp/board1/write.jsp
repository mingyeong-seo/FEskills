<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="IsLoggedIn.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>
<jsp:include page="../Common/link.jsp"/>

<h2>회원제 게시판 - 글쓰기 페이지</h2>
<form action = "writeProcess.jsp" method = "post">
	<table border = "1" width = "90%">
		<tr>
			<td>제목</td>
			<td>
				<input type = "text" name ="title" style = "width:90%">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name = "content" style = "width : 90%; height : 500px;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan = "2" align = "center">
				<button type = "submit">작성 완료</button>
				<button type = "reset">다시 입력</button>
				<button type = "button" onclick = "location.href='list.jsp'">
					목록보기
				</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>