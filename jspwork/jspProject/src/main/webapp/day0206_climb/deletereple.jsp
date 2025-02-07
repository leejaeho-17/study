<%@page import="climb.data.ClimbRepleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx = Integer.parseInt(request.getParameter("idx"));
	ClimbRepleDao dao = new ClimbRepleDao();
	dao.deleteReple(idx);
%>