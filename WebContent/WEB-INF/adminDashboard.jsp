<%@ page import="util.Const"%>

<%@page import="action.ActionLogin"%>
<%@ page import="entities.User"%>
<%
//S'il n'y a pas d'utilisateur d�j� de connect�
User user    = (User)session.getAttribute("user");
//S'il n'y a pas d'utilisaeur de connect� pr�sentement, on v�rifie dans les cookies
// et si nous somme pas en train de nous d�connecter
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>