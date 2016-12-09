package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDao;

/**
 * 
 * @author Asdrubal Livio
 *
 *         Date 09/12/2016
 */
public abstract class PizzaDaoFactory {

	private PizzaDao pizzaDao;

	/**
	 * 
	 * @param pizzaDao
	 */
	public PizzaDaoFactory(PizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	public PizzaDao getPizzaDaoFactory() {
		return pizzaDao;
	}

}
