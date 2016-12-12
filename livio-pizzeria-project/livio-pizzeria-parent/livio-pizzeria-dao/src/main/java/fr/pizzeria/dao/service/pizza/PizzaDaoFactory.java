package fr.pizzeria.dao.service.pizza;

import fr.pizzeria.dao.pizza.PizzaDao;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
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

	/**
	 * 
	 * @return
	 */
	public PizzaDao getPizzaDaoFactory() {
		return pizzaDao;
	}

}
