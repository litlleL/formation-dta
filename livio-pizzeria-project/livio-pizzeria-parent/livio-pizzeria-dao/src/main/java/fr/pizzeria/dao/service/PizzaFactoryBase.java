package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoBase;

/**
 * 
 * @author Asdrubal Livio
 * @see PizzaDaoBase
 * 
 * @since 09/12/2016
 */
public class PizzaFactoryBase extends PizzaDaoFactory {

	public PizzaFactoryBase() {
		super(new PizzaDaoBase());
	}

}
