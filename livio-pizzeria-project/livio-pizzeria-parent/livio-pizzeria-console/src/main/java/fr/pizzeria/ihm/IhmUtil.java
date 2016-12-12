package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public class IhmUtil {

	private Scanner scanner;

	private PizzaDao pizzaDao;

	/**
	 * 
	 * @param scanner
	 * @param pizzaFactoryTableau
	 */
	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao.getPizzaDaoFactory();
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

}