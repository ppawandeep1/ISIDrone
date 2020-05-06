<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.AdminOrder"%>
<%@page import="manager.MDB"%>
<%@ page import="java.sql.*" %>


<jsp:include page="<%=Const.PATH_HEAD_JSP%>" />
<jsp:include page="<%=Const.PATH_MENU_JSP%>" />



<%
	try
	{
		MDB.connect();
		String query;
		PreparedStatement ps;
	 
		int oid= Integer.parseInt(request.getParameter("oid"));
		
		PreparedStatement pstmt=null; //create statement  
		
		query="UPDATE isidrone.order SET isActive = '0' WHERE id = ?"; //sql update query
		ps = MDB.getPS(query);
		ps.setInt(1,oid);
		ps.executeUpdate(); //execute query
		
		response.sendRedirect("allorder?successMsg=Order has been deleted successfully");
		
	}
	catch(Exception e)
	{
	 out.println(e);
	}
%> 
<h2><a href="allorder">Back</a></h2>


<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>








