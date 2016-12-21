package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
public class EditerPizzaController extends HttpServlet {
	private PizzaDao pizzaDao = new PizzaDaoJpa();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Pizza pizza = getPizzaDao().findPizza(Integer.parseInt(id));
		request.setAttribute("pizza", pizza);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/pages/edit.pizza.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		double prix = Double.valueOf(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie"));
		String urlImage = request.getParameter("url_image");

		Pizza pizza = new Pizza(code, nom, prix, categorie, urlImage);

		getPizzaDao().updatePizza(Integer.parseInt(id), pizza);
		response.sendRedirect("/livio-pizzeria-admin-web/pizzas/list");
	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

	public void setPizzaDao(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
