package action;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MCategory;
import manager.MProduct;

public class ActionAllProducts {

public static void getOrders(HttpServletRequest request, HttpServletResponse response) {
request.setAttribute("prods", MProduct.getProducts());
}

public static void getProductById(int id, HttpServletRequest request, HttpServletResponse response) {
request.setAttribute("viewproducts", MProduct.getProductById(id));
}

}