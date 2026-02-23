<%@page import="webprj.common.JDBCPooler"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- id를 fs로 pass도 fs로, name은 hello로 업데이트 해보세요 -->
<%
JDBCPooler pooler = new JDBCPooler();
String sql = "UPDATE MEMBER SET ID =?, NAME=?, PASS=? WHERE ID=?";

Connection conn = new JDBCPooler().conn;
PreparedStatement pstmt = pooler.conn.prepareStatement(sql);

pstmt.setString(1, "fs");
pstmt.setString(2, "fs");
pstmt.setString(3, "hello");
pstmt.setString(4, "jason");


int result = pstmt.executeUpdate();

if(result > 0) {
    out.println("수정 성공");
} else {
    out.println("해당 id 없음");
}
pooler.close();
%>
</body>
</html>