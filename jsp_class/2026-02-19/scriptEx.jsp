<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 이게 선언문 스크립트이다..
String name;

public String getName() {
	return this.name;
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 스크립트</title>
</head>
<body>
<%
String name = "민경";

// 브라우저에 데이터 출력시 out 객체를 이용하면 된다. 
out.println(this.name);

for(int i = 0; i<5;i++) {
%>
<%=i%> <br>
<%
	
}
// jsp 스크립트 요소: 3가지가 있음.. 선언부, 스크립트let, 출력문.
// 선언부는 변수나 메서드를 선언하거나 정의할 때 사용되며, 서블릿으로 변환 시연
// 멤버필드와 멤버 or static 메서드로 변환되어진다.

// scriptlet은 was가 호출하는 서블릿의 메서드, 여기서는 _jspService()의 메서드의 
// 내용으로 변환되어서 사용된다. 가장 많이 사용하는 요소이다.

// 출력문(표현식)은 웹 브라우저에 데이터를 출력하는 스크립트문이다.
 %>
</body>
</html>