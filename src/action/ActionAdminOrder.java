package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.AdminAllOrder;

public class ActionAdminOrder {
	
	public static void getOrders(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("orders", AdminAllOrder.getOrders());
	}

	public static void getOrderById(int id, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("vieworder", AdminAllOrder.getOrderById(id));
	}


}
