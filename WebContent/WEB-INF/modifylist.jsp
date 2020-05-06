<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="action.ActionCategory"%>
<%@page import="entities.Product"%>
<%@page import="java.util.ArrayList, entities.Category"%>
<%@ page import="util.Const"%>
<%@ page import="entities.User"%>

<%
User user = (User)session.getAttribute("user");
if(user == null && request.getAttribute("logout") == null) {
response.sendRedirect("login");
}else if (user.getRoleId() == 1){
response.sendRedirect("home");
}

ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("viewproducts");
int categorySelected = ActionCategory.getSelectedCategory(request, response);
String productId = request.getParameter("pid");

%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!-- /.container -->
<!-- Page Content -->



<div class="container">
<div class="col-md-10">
<div class="form3-area">
<form class ="form-horizontal" role="form" action="modifylist" method="post">

<h3 style="margin-bottom: 25px; text-align: center;">Edit Product</h3>

<div class="form-group">
<label>Product Category </label>
<select name="category" id="category" class="form-control">
<% if(categories.size() > 0) {
for(Category category : categories) {
%>
<option value="<%=category.getId()%>"><%=category.getName()%></option>
<%
}
}
%>

</select>
</div>
<%
if(products.size() > 0) {
for(Product prodetail : products) {
%>
<input type="hidden" value="<%=productId %>" name="productId">
<div class="form-group">
<label>Name </label>

<input type="text" class="form-control" value="<%=prodetail.getName()%>" id="name" name="name" placeholder="Name" required>
</div>

<div class="form-group">
<label>Description </label>
<textarea class="form-control" id="description" name="description" placeholder="Description" rows="3"><%=prodetail.getDescription() %></textarea>
</div>
<div class="form-group">
<label>Price </label>
<input type="text" class="form-control" id="price" value="<%=prodetail.getPrice() %>" name="price" placeholder="Price" required>
</div>
<div class="form-group">
<label>Serial Number </label>
<input type="text" class="form-control" id="serialNumber" value="<%=prodetail.getSerialNumber() %>" name="serialNumber" placeholder="Serial Number" required>
</div>
<div class="form-group">
<label>Image Name </label>
<input type="text" class="form-control" id="img Name" value="<%=prodetail.getImgName() %>" name="imgName" placeholder="img Name" required>
</div>
<div class="form-group">
<label>Stock Qty </label>
<input type="text" class="form-control" id="stock Qty" value="<%=prodetail.getStockQty() %>" name="stockQty" placeholder="stock Qty" required>
</div>

<button type="submit" id="submit" class="btn btn-primary pull-left">Update Product</button>
<% }
}
%>
</form>
</div>
</div>

</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>