<%@page import="shop2.data.ShopRepltDao"%>
<%@page import="shop2.data.ShopRepleDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int star = Integer.parseInt(request.getParameter("star"));
	String message = request.getParameter("message");
	
	ShopRepleDto dto = new ShopRepleDto(num,star,message);
	
	ShopRepltDao dao = new ShopRepltDao();
	dao.insertRelpe(dto);
%>