<%@page import="java.sql.SQLException"%>
<%@page import="manager.MDB"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="action.ActionCategory"%>
<%@page import="entities.Category"%>
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
ArrayList<Category> categ = (ArrayList<Category>) request.getAttribute("viewCategories");
int categorySelected = ActionCategory.getSelectedCategory(request, response);
String categoryId = request.getParameter("pid");

%>

<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<!-- /.container -->
<!-- Page Content -->

<div class="container">
<div class="col-md-10">
<div class="form3-area">
<form class ="form-horizontal" role="form" action="editcategory" method="post">

<h3 style="margin-bottom: 25px; text-align: center;">Category Form</h3>



<%
if(categ.size() > 0) {
for(Category categorydetail : categ) {
%>
<input type="hidden" value="<%=categoryId %>" name="categoryId">
<div class="form-group">
<label>Name </label>

<input type="text" class="form-control" value="<%=categorydetail.getName()%>" id="name" name="name" placeholder="Name" required>
</div>

<div class="form-group">
<label>Description </label>
<textarea class="form-control" id="description" name="description" placeholder="Description" rows="3"><%=categorydetail.getDescription() %></textarea>
</div>
<button type="submit" id="submit" class="btn btn-primary center">Edit Category</button>
<% }
}
%>
</form>
</div>
</div>

</div>

<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>