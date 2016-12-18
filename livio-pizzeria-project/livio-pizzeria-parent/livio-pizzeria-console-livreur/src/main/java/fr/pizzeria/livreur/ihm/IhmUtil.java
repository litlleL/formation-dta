package fr.pizzeria.livreur.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.client.ClientDao;
import fr.pizzeria.dao.commande.CommandeDao;
import fr.pizzeria.dao.livreur.LivreurDao;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.service.client.ClientDaoFactory;
import fr.pizzeria.dao.service.commande.CommandeDaoFactory;
import fr.pizzeria.dao.service.livreur.LivreurDaoFactory;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;

/**
 * 
 * @author AsdrubaL
 * 
 * @since 18/12/2016
 *
 */
public class IhmUtil {

	private Scanner scanner;
	private PizzaDao pizzaDao;
	private ClientDao clientDao;
	private LivreurDao livreurDao;
	private CommandeDao commandeDao;

	/**
	 * 
	 * @param scanner
	 * @param pizzaDao
	 * @param clientDao
	 * @param livreurDao
	 * @param commandeFactory
	 */
	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao, ClientDaoFactory clientDao, LivreurDaoFactory livreurDao,
			CommandeDaoFactory commandeDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao.getPizzaDaoFactory();
		this.clientDao = clientDao.getClientDao();
		this.livreurDao = livreurDao.getLivreurDao();
		this.commandeDao = commandeDao.getCommandeDao();
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

	public LivreurDao getLivreurDao() {
		return livreurDao;
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}

}
