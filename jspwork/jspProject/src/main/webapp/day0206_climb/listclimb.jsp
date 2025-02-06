<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="climb.data.ClimbDto"%>
<%@page import="java.util.List"%>
<%@page import="climb.data.ClimbDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ClimbDao dao = new ClimbDao();
	List<ClimbDto> list = dao.getAllClimb();
	
	JSONArray arr = new JSONArray();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(ClimbDto dto:list) {
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("cname", dto.getCname());
		ob.put("cprice", dto.getCprice());
		ob.put("cphoto", dto.getCphoto());
		ob.put("cday", dto.getCday());
		ob.put("curl", dto.getCurl());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr%>