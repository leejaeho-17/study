<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="shop2.data.Shop2Dao"/>
<jsp:useBean id="dto" class="shop2.data.Shop2Dto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	dao.updateShop(dto);
%>