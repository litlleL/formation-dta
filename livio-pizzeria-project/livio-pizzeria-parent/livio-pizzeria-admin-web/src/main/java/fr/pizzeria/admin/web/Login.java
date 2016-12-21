package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;

/**
 * Servlet implementation class LoginAdmin
 */
public class Login extends HttpServlet {

	private PizzaDao pizzaDao = new PizzaDaoJpa();

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
		// String email = request.getParameter("email");
		// String pass = request.getParameter("password");
		//
		// System.out.println(email);
		// System.out.println(pass);
		// if (("admin@pizzeria.fr").equals(email)) {
		// if (("admin").equals(pass)) {
		// request.setAttribute("log", email);
		// response.sendRedirect("http://localhost:8080/livio-pizzeria-admin-web/pizzas/list");
		// } else {
		// response.sendRedirect("http://localhost:8080/livio-pizzeria-admin-web/pizzas/list");
		// }
		// } else {
		// response.sendRedirect("http://localhost:8080/livio-pizzeria-admin-web/pizzas/list");
		// }

	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

	public void setPizzaDao(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
