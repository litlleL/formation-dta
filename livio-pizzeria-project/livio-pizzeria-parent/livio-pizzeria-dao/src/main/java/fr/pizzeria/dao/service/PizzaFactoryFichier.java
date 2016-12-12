package fr.pizzeria.dao.service;

import fr.pizzeria.dao.pizza.PizzaDaoFichier;

/**
 * 
 * @author Asdrubal Livio
 * @see PizzaDaoFichier
 * 
 * 
 * @since 09/12/2016
 */
public class PizzaFactoryFichier extends PizzaDaoFactory {

	public PizzaFactoryFichier() {
		super(new PizzaDaoFichier());
	}

}
