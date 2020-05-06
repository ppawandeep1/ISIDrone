package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionAllProducts;
import action.ActionProduct;
import util.Const;

/**
* Servlet implementation class ProductList
*/
@WebServlet(name = "productlist", urlPatterns = { "/productlist"})
public class ProductList extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public ProductList() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
ActionAllProducts.getOrders(request, response);
request.getRequestDispatcher(Const.PATH_PAGE_PRODUCTLIST).forward(request, response);
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
System.out.println("POST DATA SSstep 1");



try {
if(ActionProduct.product(request, response))
request.getRequestDispatcher(Const.PATH_PAGE_PRODUCTLIST).forward(request, response);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();

}
}

}