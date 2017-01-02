package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.service.PizzaService;

/**
 * Servlet implementation class SupprimerPizzaController
 */
@WebServlet("/pizzas/delete")
public class SupprimerPizzaController extends HttpServlet {
	@Inject
	private PizzaService pizzaDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SupprimerPizzaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		getPizzaDao().deletePizza(Integer.parseInt(id));
		response.sendRedirect("/livio-pizzeria-admin-web/pizzas/list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public PizzaService getPizzaDao() {
		return pizzaDao;
	}

}
