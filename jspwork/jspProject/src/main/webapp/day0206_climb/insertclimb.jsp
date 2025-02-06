<%@page import="climb.data.ClimbDao"%>
<%@page import="climb.data.ClimbDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String cname = request.getParameter("cname");
	int cprice = Integer.parseInt(request.getParameter("cprice"));
	String cphoto = request.getParameter("cphoto");
	String cday = request.getParameter("cday");
	String curl = request.getParameter("curl");
	
	ClimbDto dto = new ClimbDto();
	dto.setCname(cname);
	dto.setCprice(cprice);
	dto.setCphoto(cphoto);
	dto.setCday(cday);
	dto.setCurl(curl);
	
	ClimbDao dao = new ClimbDao();
	dao.insertClimb(dto);	
%>