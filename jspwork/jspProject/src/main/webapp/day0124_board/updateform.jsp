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

.tabboard th {
	background-color: orange;
}

.btn {
	width: 100px;
}
</style>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	SimpleBoardDao dao = new SimpleBoardDao();
	
	SimpleBoardDto dto = dao.getData(num);
%>
<body>
<div style="margin: 30px;width: 400px;">
	<form action="./updateaction.jsp" method="post">
 	<input type="hidden" name="num" value="<%=num%>">
		<table class="table table-bordered tabboard">
			<caption align="top">
				<h5><b>글수정</b></h5>
			</caption>
			<tr>
				<th width="100">작성자</th>
				<td>
					<input type="text" name="writer" class="form-control"
					autofocus="autofocus" required="required" value="<%=dto.getWriter()%>">
				</td>
			</tr>
			<tr>
				<th width="100">제목</th>
				<td>
					<input type="text" name="subject" class="form-control"
					 required="required" value="<%=dto.getSubject()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea style="width: 100%;height: 150px;" 
					class="form-control" name="content" 
					required="required"><%=dto.getContent()%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit" class="btn btn-sm btn-outline-secondary">글수정</button>					
					<button type="button" class="btn btn-sm btn-outline-secondary" onclick="history.back()">이전으로</button>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>