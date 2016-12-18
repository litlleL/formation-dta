package fr.pizzeria.livreur.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.client.ClientDaoFactory;
import fr.pizzeria.dao.service.commande.CommandeDaoFactory;
import fr.pizzeria.dao.service.livreur.LivreurDaoFactory;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;
import fr.pizzeria.livreur.ihm.IhmUtil;
import fr.pizzeria.livreur.ihm.MenuLivreur;

/**
 * 
 * @author AsdrubaL
 * 
 * @since 18/12/2016
 *
 */
public class PizzeriaLivreurConsoleApp {

	private PizzeriaLivreurConsoleApp() {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		String clientImpl = bundle.getString("client.impl");
		String livreurImpl = bundle.getString("livreur.impl");
		String commandeImpl = bundle.getString("commande.impl");

		PizzaDaoFactory daoFactory = null;
		ClientDaoFactory clientFactory = null;
		LivreurDaoFactory livreurFactory = null;
		CommandeDaoFactory commandeFactory = null;

		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
			clientFactory = (ClientDaoFactory) Class.forName(clientImpl).newInstance();
			livreurFactory = (LivreurDaoFactory) Class.forName(livreurImpl).newInstance();
			commandeFactory = (CommandeDaoFactory) Class.forName(commandeImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new PizzaException(e);
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory, clientFactory, livreurFactory,
				commandeFactory);
		MenuLivreur menu = new MenuLivreur(ihmUtil);
		menu.start();
	}
}
