<?xml version="1.0" encoding="UTF-8"?>
<%@page import="shop2.data.Shop2Dao"%>
<%@page import="shop2.data.Shop2Dto"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sangpum = request.getParameter("sangpum");
	String scolor = request.getParameter("scolor");
	String sphoto = request.getParameter("sphoto");
	String ipgoday = request.getParameter("ipgoday");
	int scnt = Integer.parseInt(request.getParameter("scnt"));
	int sprice = Integer.parseInt(request.getParameter("sprice"));
	
	Shop2Dto dto = new Shop2Dto();
	dto.setSangpum(sangpum);
	dto.setScolor(scolor);
	dto.setSphoto(sphoto);
	dto.setIpgoday(ipgoday);
	dto.setScnt(scnt);
	dto.setSprice(sprice);
	
	Shop2Dao dao = new Shop2Dao();
	dao.insertShop(dto);	
%>


