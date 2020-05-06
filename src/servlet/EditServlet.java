package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionAllCategory;
import action.ActionCategory;
import manager.MCategory;
import util.Const;

/**
* Servlet implementation class Modify
*/
@WebServlet(name = "editcategory", urlPatterns = {"/editcategory"})
public class EditServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public EditServlet() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

int pid = Integer.valueOf(request.getParameter("pid"));
ActionAllCategory.getCategorytById(pid,request, response);

ActionCategory.getCategories(request, response);

request.getRequestDispatcher(Const.PATH_PAGE_EDIT).forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
System.out.println("Modify java dopost function");

try {
int pid = Integer.parseInt(request.getParameter("categoryId"));
System.out.println(pid);
if(ActionCategory.update_category(pid, request, response))
System.out.println("Modify java successful function");
request.setAttribute("orderscat", MCategory.getOrdersCategory());
request.getRequestDispatcher(Const.PATH_PAGE_CATEGORYLIST).forward(request, response);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}