<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"  autoFlush = "true" buffer = "8kb"
import = "java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<!-- 페이지 지시어를 통해 예외가 발생하면 해당 페이지로 제어권을 넘기도록 한다. 
이때, 제어권을 받는 에러핸들링 페이지는 내부적으로 exception 객체를 자동으로 사용할 수 있다. 
이렇게 해서 예외 내용을 찾아서 디버그에 활용할 수 있다. -->

<!-- 에러가 발생하면 IsErrorPage.jsp로 제어권을 넘기라는 의미 -->


<!-- jsp 스크립팅 요소에는 다음과 같이 존재한다. 

1. 페이지 지시어: JSP가 변환될 자바 코드(앞으론 서블릿이라고 할것)의 전체 설정 정보를 나타냄. 
특별하게 변경해서 사용될 요소는 없음.

2. 페이지 include: 다른 페이지를 import 해서 합쳐서 하나의 페이지로 만들 때 사용한다.

3. tab lib 지시어: EL(나중에 배움)의 사용 여부를 선언한느 지시어

4. 내장 객체: 서블릿 API를 JSP에서 쉽게 사용할 수 있도록 객체화 한 것. 얘네들이 주 학습 타겟이다. 
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<select name = "searchField">
	<option value = "title">제목</option>
	<option value = "member">작성자</option>
</select>
<input type = "text" name = "searchWorld" size = "30"><button>검색하기</button>
</body>
</html>