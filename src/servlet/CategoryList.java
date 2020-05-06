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
import util.Const;

/**
* Servlet implementation class ProductList
*/
@WebServlet(name = "categorylist", urlPatterns = { "/categorylist"})
public class CategoryList extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public CategoryList() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
ActionAllCategory.getOrdersCategory(request, response);
request.getRequestDispatcher(Const.PATH_PAGE_CATEGORYLIST).forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
System.out.println("POST DATA Step 1");

try {
if(ActionCategory.my_category(request, response))
request.getRequestDispatcher(Const.PATH_PAGE_CATEGORYLIST).forward(request, response);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();

}
}

}