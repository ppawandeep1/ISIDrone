package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionAdminOrder;
import util.Const;

/**
 * Servlet implementation class Viewdetailoforder
 */
@WebServlet(name = "viewallorder", urlPatterns = { "/viewallorder" })
//@WebServlet("/Viewdetailoforder")
public class Viewdetailoforder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewdetailoforder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oid = Integer.valueOf(request.getParameter("oid"));
		ActionAdminOrder.getOrderById(oid,request, response);
		request.getRequestDispatcher(Const.PATH_PAGE_VIEW_All_ORDERS).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
