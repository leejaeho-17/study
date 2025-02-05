<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop2.data.Shop2Dto"%>
<%@page import="shop2.data.Shop2Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <%
    	//1. num 읽기
    	int num = Integer.parseInt(request.getParameter("num"));
    	//2. dao 선언
    	Shop2Dao dao = new Shop2Dao();
    	//3. num 에 해당하는 dto 얻기 (dao 에 메서드 추가해야함 : getSangpum(int num))
    	Shop2Dto dto = dao.getSangpum(num);
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	
    %>
    <body>
    <!-- table 을 이용해서 상세페이지 만들기,
    맨 아래에 수정, 삭제, 목록 버튼 만들기 -->
    <div style="margin: 20px;width : 500px">
    <table class="table">
    	<tr>
    		<td>
    			<img src="<%=dto.getSphoto() %>" width="230" height="300"
    			border="1">
    		</td>
    		<td valign="middle">
    			<h6>상품명 : <%=dto.getSangpum() %></h6>
    			<h6>상품 색상 : 
    				<span style="background-color: <%=dto.getScolor()%>">
    				<%=dto.getScolor()%></span></h6>
    			<h6>수 량 : <%=dto.getScnt() %></h6>
    			<h6>단 가 : <%=dto.getSprice() %></h6>
    			<h6>입고일 : <%=dto.getIpgoday() %></h6>
    			<h6>등록일 : <%=sdf.format(dto.getWriteday()) %></h6>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			<button type="button" class="btn btn-sm btn-success" 
    			id="btnupdate">수정</button>
    			
    			<button type="button" class="btn btn-sm btn-success" 
    			id="btndelete">삭제</button>
    			
    			<button type="button" class="btn btn-sm btn-success" 
    			onclick="location.href='./shopmain.html'">목록</button>
    		</td>
    	</tr>
    
    
    
    </table>
    </div>
    
    </body>
</html>