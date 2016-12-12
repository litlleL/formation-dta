package fr.pizzeria.client.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.client.ClientDao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.client.ClientDaoFactory;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 12/12/2016
 */
public class IhmUtil {

	private Scanner scanner;

	private PizzaDao pizzaDao;
	private ClientDao clientDao;

	/**
	 * 
	 * @param scanner
	 * @param pizzaFactoryTableau
	 */
	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao, ClientDaoFactory clientDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao.getPizzaDaoFactory();
		this.clientDao = clientDao.getClientDao();
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

}