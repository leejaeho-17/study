<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.data.SimpleBoardDto"%>
<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'jua';
}
.btn {
	width: 90px;
}

.day {
	color: #ccc;
	font-size: 0.8em;
	float: right;
}
</style>
</head>
<%
	//1. num 읽기
	int num = Integer.parseInt(request.getParameter("num"));
	//2. dao 선언
	SimpleBoardDao dao = new SimpleBoardDao();
	//3. 조회수 증가 메서드 호출
	dao.updateReadCount(num);
	//4. num 에 해당하는 dto 얻기
	SimpleBoardDto dto = dao.getData(num);
	//5. 날짜 양식 (yyyy.MM.dd HH:mm)
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
%>
<body>
<div style="margin: 20px;width: 500px;">
	<table class="table">
	 	<caption align="top">
	 		<h2><b><%=dto.getSubject()%></b></h2>
	 	</caption>
	 	<tr>
	 		<td>
	 			<b>작성자 : <%=dto.getWriter() %></b>
	 			<span class="day"><%=sdf.format(dto.getWriteday()) %></span>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 			<span>조회 : <%=dto.getReadcount()%></span>>
	 			<br><br>
	 			<div>
	 			<%=dto.getContent()%>
	 			</div>
	 		</td>
	 	</tr>
	</table>
</div>
</body>
</html>