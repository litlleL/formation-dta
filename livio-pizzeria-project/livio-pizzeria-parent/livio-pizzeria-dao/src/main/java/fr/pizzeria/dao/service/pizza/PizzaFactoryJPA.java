package fr.pizzeria.dao.service.pizza;

import fr.pizzeria.dao.pizza.PizzaDaoJpa;

/**
 * 
 * @author Asdrubal Livio
 * @see PizzaDaoJpa
 * 
 * @since 09/12/2016
 */
public class PizzaFactoryJPA extends PizzaDaoFactory {

	public PizzaFactoryJPA() {
		super(new PizzaDaoJpa());
	}
}
