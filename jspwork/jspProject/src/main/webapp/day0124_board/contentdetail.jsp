<%@page import="simpleboard.data.SimpleAnswerDao"%>
<%@page import="simpleboard.data.SimpleAnswerDto"%>
<%@page import="java.util.List"%>
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

.answerlist {
	margin-bottom: 10px;
	margin-left: 10px;
}

.answerdel {
	color: gray;
	margin-left: 5px;
	cursor: pointer;
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
	//6. adao 선언
	SimpleAnswerDao adao = new SimpleAnswerDao();
	//7. num 에 해당하는 alist 가져오기
	List<SimpleAnswerDto> alist = adao.getAnswerByNum(num);
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
	 			<span>조회 : <%=dto.getReadcount()%></span>
	 			<br><br>
	 			<%-- <div>
	 			<%=dto.getContent().replace("\n", "<br>")%>
	 			</div> --%>
	 			<pre><%=dto.getContent()%></pre>
	 			<br><br>
	 			<span style="margin-left: 100px;">
	 			<i class="bi bi-chat-dots"></i>&nbsp;<%=alist.size()%>
	 			</span>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
	 			<div class="answerlist">댓글 출력할 곳...</div>
	 			<%
	 			for(SimpleAnswerDto adto:alist) {%>
	 				[<%=adto.getNickname()%>]&nbsp;
	 				<%=adto.getContent()%> &nbsp;&nbsp;
	 				<i class="bi bi-trash answerdel"></i>
	 				<span class="day">
	 					<%=sdf.format(adto.getWriteday())%>
	 				</span>
	 				
	 				<br>
	 			<%}
	 			%>
	 			<form action="./answeraction.jsp" method="post">
	 				<input type="hidden" name="num" value="<%=num%>">
	 				<div class="input-group">
	 					<input type="text" class="form-control"
	 					name="nickname" style="width: 120px;"
	 					placeholder="닉네임" required="required">
	 					&nbsp;&nbsp;
	 					<input type="text" class="form-control"
	 					name="content" style="width: 250px;"
	 					placeholder="댓글내용" required="required">
	 					&nbsp;&nbsp;
	 					<button type="submit" class="btn btn-sm btn-info">등록</button>
	 				</div>
	 			</form>
	 		</td>
	 	</tr>
	 	<tr>	
	 		<td align="center">
	 			<button type="button" class="btn btn-sm btn-outline-success"
	 			onclick="location.href='./boardform.jsp'">글쓰기</button>
	 			
	 			<button type="button" class="btn btn-sm btn-outline-success"
	 			onclick="location.href='./boardlist.jsp'">목록</button>
	 			
	 			<button type="button" class="btn btn-sm btn-outline-success"
	 			onclick="location.href='./updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
	 			
	 			<button type="button" class="btn btn-sm btn-outline-success"
	 			onclick="delfun(<%=dto.getNum()%>)">삭제</button>
	 			
	 			<script type="text/javascript">
	 				function  delfun(num) {
	 					let ans = confirm("해당 게시글을 삭제합니다");
	 					if(ans) {
	 						location.href = "./boarddelete.jsp?num="+num;
	 					}
						
					}
	 			</script>
	 		</td>
	 	</tr>
	</table>
</div>
</body>
</html>