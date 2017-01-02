package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Default;

import fr.pizzeria.model.Pizza;

@Default
public class PizzaService {

	@EJB
	private PizzaServiceEjb pizzaDao;

	public List<Pizza> findAll() {
		return getPizzaDao().findAll();
	}

	public void save(Pizza p) {
		getPizzaDao().save(p);
	}

	public void updatePizza(int id, Pizza p) {
		getPizzaDao().updatePizza(id, p);
	}

	public void deletePizza(int id) {
		getPizzaDao().deletePizza(id);
	}

	public Pizza findPizza(int id) {
		return getPizzaDao().findPizza(id);
	}

	public PizzaServiceEjb getPizzaDao() {
		return pizzaDao;
	}

}
