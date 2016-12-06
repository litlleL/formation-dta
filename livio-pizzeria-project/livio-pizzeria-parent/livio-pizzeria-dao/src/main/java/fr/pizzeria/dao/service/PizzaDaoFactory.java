package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDao;

public abstract class PizzaDaoFactory {

	private PizzaDao pizzaDao;

	public PizzaDaoFactory(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	public PizzaDao getPizzaDaoFactory() {
		return pizzaDao;
	}

}
