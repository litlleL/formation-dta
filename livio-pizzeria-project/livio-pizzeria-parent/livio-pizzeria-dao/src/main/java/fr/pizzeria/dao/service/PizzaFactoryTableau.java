package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoTableau;

public class PizzaFactoryTableau extends PizzaDaoFactory {

	public PizzaFactoryTableau() {
		super(new PizzaDaoTableau());
	}

}
