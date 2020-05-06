package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionCategory;
import manager.MCategory;
import util.Const;

/**
* Servlet implementation class AdminCat
*/
@WebServlet(name = "admincat", urlPatterns = { "/admincat" })
public class AdminCat extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public AdminCat() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

request.getRequestDispatcher(Const.PATH_PAGE_CATEGORY).forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
String name = request.getParameter("name");
String description = request.getParameter("description");
System.out.println("Modify java dopost function");
try {
if(ActionCategory.my_category(request, response))
System.out.println("Modify success function");
request.setAttribute("orderscat", MCategory.getOrdersCategory());
request.getRequestDispatcher(Const.PATH_PAGE_CATEGORYLIST).forward(request, response);

} catch (SQLException e) {

e.printStackTrace();
}
}

}