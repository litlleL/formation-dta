package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.PizzaDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {

	}

	public static void main(String[] args) throws PizzaException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");

		PizzaDaoFactory daoFactory = null;
		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new PizzaException(e);
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory);
		Menu menu = new Menu(ihmUtil);
		menu.start();
	}
}
