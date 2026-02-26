<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>요청 파라미터 확인해보기</h2>
너의 취미: ${param.hobby }<br>
너의 관심 사항: ${paramValues.inter[0] }
${paramValues.inter[1] }
${paramValues.inter[2] }
${paramValues.inter[3] }
${sessionScope.t3 }<br>
${applicationScope.t4 }<br>


</body>
</html>