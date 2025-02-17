<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>502 jsp study</title>
	<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<link  rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
	<style>
		body *{
			font-family: 'jua';
	    }
	</style>
</head>
<body>
<h2 class="alert alert-danger">HelloController 로 부터 포워드</h2> 
<h4>오늘의 메세지 : ${message}</h4>
<h5>오늘은 <fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>입니다</h5>
<hr>
<h5>매핑주소 연습</h5>
<h6>
	<a href="./bit/shop/addform">./bit/shop/addform 으로 이동</a>
</h6>
<h6>
	<a href="./bit/shop/updateform">./bit/shop/updateform 으로 이동</a>
</h6>
<h6>
	<a href="./bitcamp/shop/list">./bitcamp/shop/list 로 이동</a>
</h6>
<h6>
	<a href="./bitcamp/shop/cart">./bitcamp/shop/cart 로 이동</a>
</h6>
<h6>
	<a href="./bitcamp/board/list">./bitcamp/board/list 로 이동</a>
</h6>
<hr>
<h6>
	<a href="./prop1">application.properties 에서 addr,hp 읽기</a>
</h6>
<h6>
	<a href="./prop2">navercloud.yml 에서 db정보 읽기</a>
</h6>
<hr>
<h6>
	<a href="./form1">get 방식으로 폼 데이터 읽기</a>
</h6>
<h6>
	<a href="./form2">post 방식- dto 로 폼 데이터 읽기</a>
</h6>
<h6>
	<a href="./form3">post 방식 -map 으로 폼 데이터 읽기</a>
</h6>
</body>
</html>