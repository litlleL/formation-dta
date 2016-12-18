package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.livreur.LivreurDao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.livreur.LivreurDaoFactory;
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

	private LivreurDao livreurDao;

	/**
	 * 
	 * @param scanner
	 * @param livreurDao
	 * @param pizzaFactoryTableau
	 */
	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao, LivreurDaoFactory livreurDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao.getPizzaDaoFactory();
		this.livreurDao = livreurDao.getLivreurDao();
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

	public LivreurDao getLivreurDao() {
		return livreurDao;
	}

}