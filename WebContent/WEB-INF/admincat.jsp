<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="util.Const"%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>
<%@ page import="entities.User"%>
<%
User user = (User)session.getAttribute("user");
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}else if (user.getRoleId() == 1){
	response.sendRedirect("home");
}
%>
<!-- /.container -->
<!-- Page Content -->
<div class="container">
<div class="col-md-10">
<a class="btn btn-primary pull-right" href="categorylist">CategoryList</a>
<div class="form-area">
<form class ="form-horizontal" role="form" action="admincat" method="post">
<h3 style="margin-bottom: 25px; text-align: center;">Category Form</h3>
<div class="form-group">
<label>Name </label>
<input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
</div>

<div class="form-group">
<label>Description </label>
<textarea class="form-control" id="description" name="description" placeholder="Description" rows="3"></textarea>
</div>

<div class="form-group text-center" style="clear: left; top: 15px; margin-bottom: 15px;">
<button type="submit" id="submit" class="btn btn-primary center" >Add Category</button>
</div>
</form>
</div>
</div>
</div>
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>