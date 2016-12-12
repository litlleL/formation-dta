package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.client.ClientDaoFactory;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 12/12/2016
 */
public class PizzeriaClientConsoleApp {

	private PizzeriaClientConsoleApp() {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		String clientImpl = bundle.getString("client.impl");

		PizzaDaoFactory daoFactory = null;
		ClientDaoFactory clientFactory = null;
		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
			clientFactory = (ClientDaoFactory) Class.forName(clientImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new PizzaException(e);
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory, clientFactory);
		Menu menu = new Menu(ihmUtil);
		menu.start();
	}
}
