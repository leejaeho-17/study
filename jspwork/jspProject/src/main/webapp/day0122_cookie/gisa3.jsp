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
	김선호 기자 = 60년 전 자신을 성폭행하려던 남성의 혀를 깨물어 중상해죄로 
	징역형을 선고받았던 최말자(78) 씨의 재심 청구 파기환송심 첫 공판이 22일 부산고법에서 열렸다.
	
	부산고법 형사2부(부장판사 이재욱) 심리로 열린 이날 공판에서 최씨 측 변호인은
	"대법원 파기환송 취지처럼 (최씨가 수사기관에) 체포·구금된 부분을 면밀히 검토해달라"고 말했다.
	
	검찰 측은 "대법원이 재심 청구인 진술 그 자체가 재심 이유 존재를 뒷받침하는 핵심적 증거로 
	신빙성이 크다고 보고 파기환송 한 만큼 재심 개시 의견을 낸다"고 밝혔다.
	
	이어 진행된 증인 신문에서 재심 청구인인 최씨는 "1964년 7월 초 아버지랑 
	검찰청에 가서 죄수복을 입고 조그만 방에서 조사받았고, 교도소에서 총 6개월 12일간 있었다"고 진술했다.
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