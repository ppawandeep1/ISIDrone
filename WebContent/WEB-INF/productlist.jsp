<%@page import="action.ActionProduct"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="entities.Product"%>
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
ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("prods");

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

<!-- Table -->
<h2 align="center"><font><strong>Product List</strong></font></h2>
<a class="btn btn-primary pull-right" href="product">Add Product</a>
</br></br></br>


<table class="adminorders">

<tr>

<th> Product Image </th>
<th> Category</th>
<th> Name </th>
<th> Description </th>
<th> Price </th>
<th> Serial Number </th>
<th> Quantity </th>
<th style="width:13%"> Actions </th>
</tr>


<%

if(products.size() > 0) {
for(Product prodlist : products) {
%>
<tr >

<td><img class="img-circle img-responsive img-center"
src="<%=Const.PATH_IMG_PRODUCT+prodlist.getImgName()%>" alt="Photo de product"
style="max-width: 90px; max-height: 90px; min-width: 90px;"></td>
<td>#<%=prodlist.getCategory() %></td>
<td><%=prodlist.getName()%></td>
<td><%=prodlist.getDescription() %></td>
<td>$<%= prodlist.getPrice() %></td>
<td><%= prodlist.getSerialNumber() %></td>
<td><%= prodlist.getStockQty() %></td>
<td><a href="modifylist?pid=<%=prodlist.getId()%>">Modify</a> | <a href="delete?oid=<%=prodlist.getId()%>">Delete</a></td>


</tr>
<%

}

}

%>
</table>
<hr>
</div>
<%-----<!-- <a href="viewallorder?oid=<%=order.getId()%>">

<li><a href="allorder">All Order</a>
<a href="Viewdetailoforder?oid=<%session.setAttribute("oid", order.getId());%>"></li> -->
--%>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>