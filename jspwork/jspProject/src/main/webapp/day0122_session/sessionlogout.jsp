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
</style>
</head>
<body>
<div style="margin: 30px;">
	<b style="font-size: 25px;">
		비트캠프님이 로그인 했습니다
	</b>
	<button type="button" class="btn btn-sm btn-danger"
	style="margin-left: 30px;"
	onclick="location.href='./logoutaction.jsp'">로그아웃</button>
	
	<hr>
	<jsp:include page="../day0122/ex2_divfoodlist.jsp"/>
</div>
</body>
</html>