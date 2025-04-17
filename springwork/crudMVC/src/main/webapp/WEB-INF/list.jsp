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
 	<div class="container">
 		<table class="table table-bordered">
 			<thead>
 				<tr>
 					<th>번호</th>
 					<th>이름</th>
 					<th>이메일</th>
 					<th>나이</th> <!-- 테이블이 이상하게 출력되서 봤더니 </th> 에서 / 누락했더라.. -->
 					<th>날짜</th>
 					<th>수정, 삭제</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:forEach var="list" items="${crud}">
 				<tr>
 					<td>${list.num}</td>
 					<td>${list.name}</td>
 					<td>${list.email}</td>
 					<td>${list.age}</td>
 					<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd HH:mm" /></td>
 					<td>
 					<button type="button" onclick="location.href='/update?num=${list.num}'">수정</button>
 					<button type="submit" onclick="location.href='/delete?num=${list.num}'">삭제</button>
 					</td>
 				</tr>
 				</c:forEach>
 			</tbody>
 		</table>
 		<button type="button" onclick="location.href='/main'">이전으로</button>
 	</div>
</body>
</html>