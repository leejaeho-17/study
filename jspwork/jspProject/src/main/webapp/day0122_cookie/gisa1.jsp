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
	곽민서 권희원 전재훈 기자 = 윤석열 대통령을 구속한 고위공직자범죄수사처가 
	22일 서울 용산구 한남동 대통령 관저와 대통령실에 대한 압수수색을 수 시간째 시도 중이다.
	
	공수처는 이날 오전 10시30분께부터 검사와 수사관들을 
	대통령 관저와 대통령실 등 2곳으로 보내 압수수색에 나섰다고 밝혔다.
	
	공수처는 현재 대통령경호처에 압수수색영장을 제시한 뒤 
	영장 집행을 위한 협의를 진행 중인 것으로 전해졌다.
	
	공수처는 이번 압수수색을 통해 윤 대통령 수사에 필요한 비상계엄 관련 문건과 회의록, 
	윤 대통령이 사용한 비화폰의 서버 기록, 대통령실 내 PC 등 전산장비를 확보한다는 방침이다.
	
	하지만, 경호처가 현재까지 영장 집행을 승낙하지 않아 
	공수처 수사팀이 대통령실과 관저 내부로 진입하지는 못한 것으로 전해졌다.
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