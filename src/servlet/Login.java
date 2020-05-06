package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.MCookies;
import util.Const;
import action.ActionAdminOrder;
import action.ActionLogin;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déconnecte l'utilisateur, dans le cas où il est déjà connecter et qu'il se diriges sur la page de connexion
		
		loginOrLogout(request, response);

		request.getRequestDispatcher(Const.PATH_PAGE_LOGIN).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Déconnecte l'utilisateur, dans le cas où il est déjà connecter et qu'il se diriges sur la page de connexion
		
		loginOrLogout(request, response);
		ActionLogin.loginAttempt(request, response);
		
		@SuppressWarnings("unchecked")
		String loginState = (String)((HashMap<String, String>)request.getAttribute("hm_errorMsg")).get("loginState");
		@SuppressWarnings("unchecked")
		String userRole   = (String)((HashMap<String, String>)request.getAttribute("user_role")).get("userRole");
		ActionAdminOrder.getOrders(request, response);
		
		if(loginState.equals("ok") && userRole.equals("1"))
			if(request.getParameter("fromCart") == null)
				response.sendRedirect("home");
			else
				request.getRequestDispatcher(Const.PATH_PAGE_CARTUSER).forward(request, response);
			
		else if(loginState.equals("ok") && userRole.equals("2"))
				
				response.sendRedirect("allorder");
		else 
				request.getRequestDispatcher(Const.PATH_PAGE_LOGIN).forward(request, response);
	}
	
	private void loginOrLogout(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getSession().getAttribute("user") != null) {
			//request.getSession().invalidate();
			request.getSession().removeAttribute("user");
			request.getSession().removeAttribute("role_id");
			request.setAttribute("logout", "ok");
			MCookies.destroy("id", request, response);
			MCookies.destroy("token", request, response);
		}
	}
}
