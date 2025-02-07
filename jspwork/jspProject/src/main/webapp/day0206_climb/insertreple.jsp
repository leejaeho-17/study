<%@page import="climb.data.ClimbRepleDao"%>
<%@page import="climb.data.ClimbRepleDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int star = Integer.parseInt(request.getParameter("star"));
	String message = request.getParameter("message");
	
	ClimbRepleDto dto = new ClimbRepleDto(num,star,message);
	
	ClimbRepleDao dao = new ClimbRepleDao();
	dao.insertRelpe(dto);
%>