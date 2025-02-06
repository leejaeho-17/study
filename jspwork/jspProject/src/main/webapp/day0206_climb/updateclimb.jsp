<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="climb.data.ClimbDao"/>
<jsp:useBean id="dto" class="climb.data.ClimbDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	dao.updateClimb(dto);
%>