<%@page import="action.ActionCategory"%>
<%@page import="java.util.ArrayList, entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
int categorySelected = ActionCategory.getSelectedCategory(request, response);
%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!-- /.container -->
<!-- Page Content -->
<div class="container">
<div class="col-md-10">
<a class="btn btn-primary pull-right" href="productlist">ProductList</a>
<div class="form-area">
<form class ="form-horizontal" role="form" action="product" method="post">
<h3 style="margin-bottom: 25px; text-align: center;">Add New Product</h3>

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

<div class="form-group">
<label>Name </label>
<input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
</div>

<div class="form-group">
<label>Description </label>
<textarea class="form-control" id="description" name="description" placeholder="Description" rows="3"></textarea>
</div>



<div class="form-group">
<label>Price </label>
<input type="text" class="form-control" id="price" name="price" placeholder="Price" required>
</div>
<div class="form-group">
<label>Serial Number </label>
<input type="text" class="form-control" id="serialNumber" name="serialNumber" placeholder="Serial Number" required>
</div>
<div class="form-group">
<label>Image Name </label>
<input type="text" class="form-control" id="img Name" name="imgName" placeholder="img Name" required>

</div>
<div class="form-group">
<label>Stock Qty </label>
<input type="text" class="form-control" id="stock Qty" name="stockQty" placeholder="stock Qty" required>
</div>

<button type="submit" id="submit" class="btn btn-primary pull-left">Add Product</button>

</form>
</div>
</div>

</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>