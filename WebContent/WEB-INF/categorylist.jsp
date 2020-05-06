<%@page import="action.ActionCategory"%>
<%@page import="manager.MCategory"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="entities.User"%>
<%
User user = (User)session.getAttribute("user");
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}else if (user.getRoleId() == 1){
	response.sendRedirect("home");
}
@SuppressWarnings("unchecked")
ArrayList<Category> orders = (ArrayList<Category>) request.getAttribute("orderscat");
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>" />
<jsp:include page="<%=Const.PATH_MENU_JSP%>" />


<!-- /.container -->
<!-- Page Content -->
<div class="container">

<!-- Introduction Row -->
<div class="row">
<div class="col-lg-12">
</div>
</div>

<% if(request.getParameter("successMsg") != null){ %>
<div class="alert alert-success" role="alert">
<%=request.getParameter("successMsg") %>
</div>
<%} %>
<h2 align="center"><font><strong>Category List</strong></font></h2>
<a class="btn btn-primary pull-right" href="admincat">Add Category</a>
</br></br></br>

<!-- Table -->
<table class="adminorders" >

<tr>
<th>ID</th>
<th> Name </th>
<th> Description </th>
<th colspan="2">Actions </th>
</tr>

<%
if(orders.size() > 0) {
for(Category ordercat : orders) {
%>
<tr>
<td><%=ordercat.getId()%></td>
<td><%=ordercat.getName()%></td>
<td><%=ordercat.getDescription() %></td>
<td><a onclick="if (confirm('Are you sure you want to delete?')) { href='deletecategory?oid=<%=ordercat.getId()%>' } else { return false; }">Delete</a></td>
<td><a href="editcategory?pid=<%=ordercat.getId() %>">Edit</a></td>
</tr>
<%
}
}
%>
</table>

</div>

<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>