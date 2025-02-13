<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
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
        <div style="margin: 20px;width: 500px;" class="oklogin">
		<form action="./update" method="post">
			<!-- hidden -->
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="pageNum" value="${pageNum}"> 


			<table class="tab1 table table-bordered">
				<caption align="top">
					<b> 글수정</b>
				</caption>
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="subject" class="form-control"
							required="required" value="${subject}"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea style="width: 100%; height: 120px;"
								name="content" required="required" value="${content}"></textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<button type="submit" class="btn btn-sm btn-outline-secondary">저장하기</button>

							<button type="button" class="btn btn-sm btn-outline-secondary"
								onclick="history.back()">이전으로</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>