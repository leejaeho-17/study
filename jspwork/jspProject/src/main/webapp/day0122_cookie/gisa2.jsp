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
<%
	boolean blogin = false;
	
	//현배 브라우저에 저장된 모든 쿠키값 얻기, 없을 경우 null 값
	Cookie [] cookies = request.getCookies();
	if(cookies != null)
	{
		for(int i=0;i<cookies.length;i++)
		{
			//loginok 라는 쿠키가 있는지 검사
			if(cookies[i].getName().equals("loginok")){
				blogin = true;
				break;
			}
		}
	}
%>
<body>
<%
	if(blogin){%> 
	<pre>
	정경재 기자 = "그때 제가 강하게 이야기해서 동생을 
	경찰에 데려갔다면 살 수도 있었을 텐데…"
	
	임신한 전처를 살해한 혐의로 법정에 선 40대의 항소심 
	재판에서 피해자 유족은 피고인에 대한 엄벌을 탄원하며 눈물을 쏟아냈다.
	
	22일 광주고법 전주재판부 제1형사부(양진수 부장판사) 
	심리로 A(44)씨에 대한 살인 및 살인미수 항소심 공판이 열렸다.
	
	A씨의 잔혹한 범행으로 숨진 B씨의 유족은 
	재판 내내 피고인석을 바라보며 울분을 터뜨렸다.
	
	"혹시 유족분들도 하실 말씀이 있느냐"는 재판장의 물음에 
	마이크를 잡은 B씨의 언니는 "동생이 전남편에게 살해당할 수도 있다며 두렵다고 했다.
	</pre>
	<%} else {%>
	<script type="text/javascript">
		alert("먼저 로그인을 해주세요");
		history.back();//이전 페이지로 이동
	</script>
	<%} 
%>

</body>
</html>