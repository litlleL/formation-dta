package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoFichier;

public class PizzaFactoryFichier extends PizzaDaoFactory {

	public PizzaFactoryFichier() {
		super(new PizzaDaoFichier());
	}

}
