<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.AdminOrder"%>
<%@page import="action.ActionLogin"%>
<%@ page import="entities.User"%>
<%
User user = (User)session.getAttribute("user");
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}else if (user.getRoleId() == 1){
	response.sendRedirect("home");
}
@SuppressWarnings("unchecked")
	ArrayList<AdminOrder> orders = (ArrayList<AdminOrder>) request.getAttribute("orders");
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>" />
<jsp:include page="<%=Const.PATH_MENU_JSP%>" />


	<!-- /.container -->
	<!-- Page Content -->
	<div class="container">

		<!-- Introduction Row -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">All order of users</h1>
			</div>
		</div>
		<% if(request.getParameter("successMsg") != null){ %>
		<div class="alert alert-success" role="alert">
		  <%=request.getParameter("successMsg") %>
		</div>
		<%} %>
		<!-- Table -->
		<table class="adminorders">
			<tr>
				<th>&nbsp; Id</th>
				<th>Image</th>
				<th>Quantity</th>
				<th>Total Price</th>
				<th>Date</th>
				<th>Shipped Status</th>
				<th>Action</th>
			</tr>
				
			<%
			
			if(orders.size() > 0) {
				for(AdminOrder order : orders) {
			%>
			<tr>		
				<td>#<%=order.getId() %></td>
				<td><img class="img-circle img-responsive img-center"
				src="<%=Const.PATH_IMG_PRODUCT+order.getImgName()%>" alt="Photo de product"
				style="max-width: 60px; max-height: 60px; min-width: 60px;"></td>
				<td><%=order.getQty() %></td>
				<td>$<%=order.getTotal_price() %></td>
				<td><%= order.getDate() %></td>
				<td>
				<%
						if(order.isShipped())
						{
							out.println("Shipped");
						}
						else
						{
							out.println("Processing");
						}
				%>
				</td>
				<td><a href="viewallorder?oid=<%=order.getId()%>">View</a> | &nbsp;<% if(!order.isShipped()){ %><a onclick="if (confirm('Are you sure you want to delete?')) {  href='viewupdate?oid=<%=order.getId()%>' } else { return false; }">Delete</a> <% } %> | &nbsp; <a href="shippedorder?oid=<%=order.getId()%>">Change order status</a></td>	
			</tr>
			
			
			<% 
			} 	}
			%>
		</table>
	</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>
	

	 
