<%@ page import="util.Const"%>

<%@page import="action.ActionLogin"%>
<%@ page import="entities.User"%>
<%
//S'il n'y a pas d'utilisateur déjà de connecté
User user    = (User)session.getAttribute("user");
//S'il n'y a pas d'utilisaeur de connecté présentement, on vérifie dans les cookies
// et si nous somme pas en train de nous déconnecter
if(user == null && request.getAttribute("logout") == null) {
	response.sendRedirect("login");
}
%>
<jsp:include page="<%=Const.PATH_HEAD_JSP%>"/>
<jsp:include page="<%=Const.PATH_MENU_JSP%>"/>

<!-- Footer -->
<jsp:include page="<%=Const.PATH_FOOTER_JSP%>"/>