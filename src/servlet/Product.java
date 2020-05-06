package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionCategory;
import action.ActionProduct;
import manager.MProduct;
import util.Const;

/**
* Servlet implementation class Product
*/
@WebServlet(name = "product", urlPatterns = { "/product"})
public class Product extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final MProduct dao = null;

/**
* @see HttpServlet#HttpServlet()
*/
public Product() {
super();
// TODO Auto-generated constructor stub
}

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
ActionCategory.getCategories(request, response);
request.getRequestDispatcher(Const.PATH_PAGE_PRODUCT).forward(request, response);


}


/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
System.out.println("POST DATA step 1");



try {
if(ActionProduct.product(request, response))
	request.setAttribute("prods", MProduct.getProducts());
	request.getRequestDispatcher(Const.PATH_PAGE_PRODUCTLIST).forward(request, response);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();

}
}

}