package fr.pizzeria.admin.service;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.model.Pizza;

@Default
public class PizzaService {

	@Inject
	private PizzaServiceEjb pizzaDao;

	public List<Pizza> findAll() {
		return getPizzaDao().findAll();

	}

	public PizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
