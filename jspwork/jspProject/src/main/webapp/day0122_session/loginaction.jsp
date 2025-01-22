<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String chksave = request.getParameter("chksave");
	String myid = request.getParameter("myid");
	String mypass = request.getParameter("mypass");
	
	if(myid.equals("angel") && mypass.equals("1234"))
	{
		if(chksave != null) {//아이디 저장을 체크한 경우
			session.setAttribute("myid", myid);
			session.setAttribute("chksave", "yes");
			
			
		} else {
			//이전에 저장된 세션을 삭제
			session.removeAttribute("chksave");
			session.removeAttribute("myid");
		}
		session.setAttribute("loginok", "yes");
		
		//유지시간 지정(생략시 기본 30분간 유지)
		session.setMaxInactiveInterval(60*60);
		
		response.sendRedirect("./sessionmain.jsp");//메인 페이지로 이동
	} else {%> 
		<script>
			alert("아이디와 비번이 맞지 않습니다")
			history.back();
		</script>
	<%}
	
%>
