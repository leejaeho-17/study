<%@page import="simpleboard.data.SimpleAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//1. idx, num 읽기
	int idx = Integer.parseInt(request.getParameter("idx"));
	int num = Integer.parseInt(request.getParameter("num"));
	//2. adao 선언
	SimpleAnswerDao adao = new SimpleAnswerDao();
	
	adao.deleteAnswer(idx);
	
	response.sendRedirect("./contentdetail.jsp?num="+num);
%>