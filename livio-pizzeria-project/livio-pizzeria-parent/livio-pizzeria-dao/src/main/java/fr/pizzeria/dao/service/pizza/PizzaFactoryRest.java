package fr.pizzeria.dao.service.pizza;

import fr.pizzeria.dao.pizza.PizzaDaoRest;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @see PizzaDaoFactory
 * @since 02/01/2017
 *
 */
public class PizzaFactoryRest extends PizzaDaoFactory {
	public PizzaFactoryRest() {
		super(new PizzaDaoRest());
	}
}
