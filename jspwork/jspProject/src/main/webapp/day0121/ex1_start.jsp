<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>HTML,JSP 주석확인</h3>
<!-- HTML 주석 -->
<%-- JSP 주석 --%>
<h4>이름 : <%=name%></h4> <!-- 선언문의 변수는 위치가 어디든 출력가능 -->
<%!

	//선언문	
	//이곳에 변수를 등록하면 서블릿 변환시 멤버변수로 등록된다
	String name = "홍길동";
%>
<%
	//스크립트릿(scriptets) : 자바영역
	//이곳에서 선언하는 변수는 서블릿 변환 시 지역변수로 등록된다(doGet 의 지역변수로)
	
	//변수를 브라우저에 출력하는 방법 두가지
	//1번째
	out.print("<h2>이름 :"+name+"</h2>");
%>
<h4>이름 : <%=name%></h4> <!--2번째 : 표현식을 이용한 자바영역의 변수 출력-->

<%
	String addr = "서울시 강남구";
	//자바영역 안에서 선언된 지역변수는 선언된 곳보다 아래쪽에서만 사용 가
%>
<h5 style="color : blue">주소 : <%=addr%></h5>
<!--  
jsp 실행 --servlet(java)파일으로 변환 --class 파일로 컴파일 --class파일이 실행되서 브라우저로 나온다
첫날이니ㅏㄲ 딱 한번만 찾아가서 확인(ㅡㅏ이클립스 안의 톰켓서버위치 그 안에 현재 프로젝트가 -->
</body>
</html>