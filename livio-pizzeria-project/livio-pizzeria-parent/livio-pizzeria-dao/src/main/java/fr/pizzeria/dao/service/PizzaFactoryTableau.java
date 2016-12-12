package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoTableau;

/**
 * 
 * @author Asdrubal Livio
 * @see PizzaDaoTableau
 * 
 * @since 09/12/2016
 */
public class PizzaFactoryTableau extends PizzaDaoFactory {

	public PizzaFactoryTableau() {
		super(new PizzaDaoTableau());
	}

}
