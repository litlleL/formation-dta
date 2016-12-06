package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.PizzaDaoFactory;

public class IhmUtil {

	private Scanner scanner;

	private PizzaDao pizzaDao;

	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaFactoryTableau) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaFactoryTableau.getPizzaDaoFactory();
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

}