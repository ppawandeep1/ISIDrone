<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@page import="java.util.ArrayList"%>
<%@page import="manager.MDB"%>
<%@ page import="java.sql.*" %>
<%@ page import="entities.User"%>
<%
User user = (User)session.getAttribute("user");
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}else if (user.getRoleId() == 1){
	response.sendRedirect("home");
}
%>

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

query="UPDATE isidrone.category SET isActive = '0' WHERE id = ?"; //sql update query
ps = MDB.getPS(query);
ps.setInt(1,oid);
ps.executeUpdate(); //execute query

response.sendRedirect("categorylist?successMsg=Category has been deleted successfully");

}
catch(Exception e)
{
out.println(e);
}

%>

<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>