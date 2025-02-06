<%@page import="climb.data.ClimbDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	ClimbDao dao = new ClimbDao();
	
	dao.deleteClimb(num);
%>