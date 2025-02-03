<?xml version="1.0" encoding="UTF-8"?>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop.data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.data.ShopDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <data>
   <%
   ShopDao dao = new ShopDao();
   String search = request.getParameter("search");
   List<ShopDto> list = dao.getAllDatas();
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
   
   for(ShopDto dto:list)
   {%>
	  <shop idx = "<%=dto.getIdx()%>">
	  	 <sangpum><%=dto.getSangpum()%></sangpum>
	  	 <su><%=dto.getSu()%></su>
	  	 <danga><%=dto.getDanga()%></danga>
	  	 <ipgoday><%=dto.getIpgoday()%></ipgoday>
	  </shop>
   <%}
   %>
   </data>
