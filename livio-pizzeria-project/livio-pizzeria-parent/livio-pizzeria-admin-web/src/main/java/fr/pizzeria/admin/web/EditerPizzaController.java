package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.service.PizzaService;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	@Inject
	private PizzaService pizzaDao;

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

		boolean archiver = false;
		Pizza pizza = new Pizza(code, nom, prix, categorie, urlImage, archiver);

		getPizzaDao().updatePizza(Integer.parseInt(id), pizza);
		response.sendRedirect("/livio-pizzeria-admin-web/pizzas/list");
	}

	public PizzaService getPizzaDao() {
		return pizzaDao;
	}

}
