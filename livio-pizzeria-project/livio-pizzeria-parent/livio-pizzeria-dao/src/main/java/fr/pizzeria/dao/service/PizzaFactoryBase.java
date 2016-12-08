package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoBase;

public class PizzaFactoryBase extends PizzaDaoFactory {

	public PizzaFactoryBase() {
		super(new PizzaDaoBase());
	}

}
