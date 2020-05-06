package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MCategory;

public class ActionAllCategory {

public static void getOrdersCategory(HttpServletRequest request, HttpServletResponse response)
{
	request.setAttribute("orderscat", MCategory.getOrdersCategory());
}

public static void getCategorytById(int id, HttpServletRequest request, HttpServletResponse response)
{
	request.setAttribute("viewCategories", MCategory.getCategorytById(id));
}

}