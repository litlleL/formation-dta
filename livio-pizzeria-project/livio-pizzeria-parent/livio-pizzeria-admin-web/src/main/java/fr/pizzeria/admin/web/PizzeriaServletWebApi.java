package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzeriaServletWebApi
 */
@WebServlet("/api/servlet/pizzas")
public class PizzeriaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PizzaDao pizzaDao = new PizzaDaoJpa();

	/**
	 * Default constructor.
	 */
	public PizzeriaServletWebApi() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Pizza> list = pizzaDao.findAll();
		PrintWriter out = resp.getWriter();
		list.forEach(p -> out.write(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " "
				+ p.getCategoriePizza() + "\n"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.save(pizza);
		resp.setStatus(201);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		CategoriePizza catP = CategoriePizza.valueOf(req.getParameter("cat"));
		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), catP);
		pizzaDao.updatePizza(Integer.parseInt(id), pizza);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
		String idPizza = req.getParameter("idPizza");
		pizzaDao.deletePizza(Integer.parseInt(idPizza));
	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

	public void setPizzaDao(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

}
