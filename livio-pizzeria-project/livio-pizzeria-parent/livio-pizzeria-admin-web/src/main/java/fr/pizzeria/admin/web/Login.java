package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") != null)
			response.sendRedirect("/pizzas/list");
		else {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("admin@pizzeria.fr".equals(request.getParameter("email"))
				&& "admin".equals(request.getParameter("password"))) {

			request.getSession().setAttribute("user", request.getParameter("email"));
			response.sendRedirect("/livio-pizzeria-admin-web/pizzas/list");
		} else {
			Map<String, String> errors = new HashMap<>();
			errors.put("login", "Invalid username and/or password");
			request.setAttribute("errors", errors);
			doGet(request, response);
		}

	}

}
