package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoJpa;

public class PizzaFactoryJPA extends PizzaDaoFactory {

	public PizzaFactoryJPA() {
		super(new PizzaDaoJpa());
	}
}
