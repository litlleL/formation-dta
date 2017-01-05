package fr.pizzeria.dao.service.pizza.spring;

import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.spring.PizzaDaoTemplate;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;

@Component
public class PizzaFactoryTemplate extends PizzaDaoFactory {
	public PizzaFactoryTemplate() {
		super(new PizzaDaoTemplate());
	}

}