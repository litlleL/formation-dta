package fr.pizzeria.admin.service;

import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;

public class DaoProducer {

	@Produces
	public PizzaDao getPizzaDao() {
		return new PizzaDaoJpa();
	}
}
