package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.livreur.LivreurDaoFactory;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.MenuAdmin;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		String livreurImpl = bundle.getString("livreur.impl");

		PizzaDaoFactory pizzaFactory = null;
		LivreurDaoFactory livreurFactory = null;
		try {
			pizzaFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
			livreurFactory = (LivreurDaoFactory) Class.forName(livreurImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new PizzaException(e);
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), pizzaFactory, livreurFactory);
		MenuAdmin menu = new MenuAdmin(ihmUtil);
		menu.start();
	}
}
