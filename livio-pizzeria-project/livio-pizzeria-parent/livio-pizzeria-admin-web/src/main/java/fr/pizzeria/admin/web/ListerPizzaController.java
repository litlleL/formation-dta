package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.service.PizzaService;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaController
 */
@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {

	@Inject
	private PizzaService pizzaDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pizza> list = getPizzaDao().findAll();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/list.pizza.jsp");

		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public PizzaService getPizzaDao() {
		return pizzaDao;
	}

}
