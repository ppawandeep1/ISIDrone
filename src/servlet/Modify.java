package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionAllProducts;
import action.ActionCategory;
import action.ActionProduct;
import manager.MProduct;
import util.Const;

/**
* Servlet implementation class Modify
*/
@WebServlet(name = "modifylist", urlPatterns = {"/modifylist"})
public class Modify extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public Modify() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

int pid = Integer.valueOf(request.getParameter("pid"));
ActionAllProducts.getProductById(pid,request, response);

ActionCategory.getCategories(request, response);

request.getRequestDispatcher(Const.PATH_PAGE_MODIFY).forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
try {
int pid = Integer.parseInt(request.getParameter("productId"));
if(ActionProduct.update2(pid, request, response))
request.setAttribute("prods", MProduct.getProducts());
request.getRequestDispatcher(Const.PATH_PAGE_PRODUCTLIST).forward(request, response);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();

}
}
}