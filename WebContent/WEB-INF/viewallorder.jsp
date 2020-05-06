<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.AdminOrder"%>
<%@page import="action.ActionAdminOrder"%>
<%@page import="action.ActionLogin"%>
<%@ page import="entities.User"%>
<%
User user = (User)session.getAttribute("user");
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}else if (user.getRoleId() == 1){
	response.sendRedirect("home");
}

//Vérification si la catégorie sélectionne est valide (Un utilisateur pourrait tenter d'entré une catégorie invalide dans la barre d'adresse)
@SuppressWarnings("unchecked")
ArrayList<AdminOrder> vieworder = (ArrayList<AdminOrder>) request.getAttribute("vieworder");
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>" />
<jsp:include page="<%=Const.PATH_MENU_JSP%>" />

	<!-- /.container -->
	<!-- Page Content -->
	<div class="container">

		<!-- Introduction Row -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Order Detail</h1>
			</div>
		</div>
		
		<div>
		<!-- Table -->
		
		<h3>Order ID: <%= request.getParameter("oid") %></h3>		
		<table class="admindetail">				
			<%	
			if(vieworder.size() > 0) {
				for(AdminOrder orderdetail : vieworder) {
			%>
			<tr>
				<th>Product Image</th>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Shipped status</th>
			</tr>
			<tr>		
				<td><img class="img-circle img-responsive img-center"
				src="<%=Const.PATH_IMG_PRODUCT+orderdetail.getImgName()%>" alt="Photo de product"
				style="max-width: 90px; max-height: 90px; min-width: 90px;"/></td>
				<td><%=orderdetail.getName() %></td> 
				<td><%=orderdetail.getQty() %></td>
				<td><%=orderdetail.getPrice() %></td>
				<td>
				<%
					if(orderdetail.isShipped()){
						out.println("Shipped");
					}
					else
					{	
						out.println("Processing");
					}
				%>
				</td>
				
			</tr>			
			<% }	
				} %>
				
			<%
			double total = 0;
			for (AdminOrder orderprice : vieworder) {
			    total += orderprice.getPrice();
			}
			%>
			
			<tr id="totalprice">
				<td colspan="3"></td>
				<th colspan="2"><b>Total price = $<%=total %></b></th>
			</tr>
		</table>
		
		<h2><a href="allorder">Back</a></h2>
		</div>
	</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>