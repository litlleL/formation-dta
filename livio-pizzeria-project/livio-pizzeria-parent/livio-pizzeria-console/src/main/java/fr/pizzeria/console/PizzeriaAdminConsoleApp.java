package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.log4j.Logger;

import fr.pizzeria.dao.service.PizzaDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {

	}

	public static void main(String[] args) {

		Logger logger = Logger.getLogger(PizzeriaAdminConsoleApp.class);

		Pizza p1 = new Pizza();
		p1.setCode("MAR");

		Pizza p2 = new Pizza();
		p2.setCode("MAR");

		logger.info("p1=p2 ? " + p1.equals(p2));

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");

		PizzaDaoFactory daoFactory = null;
		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException e) {
			logger.debug("Erreur d'instanciation");
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.debug("Accès illégal");
			logger.error(e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.debug("Class Not Found");
			logger.error(e.getMessage());
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory);
		Menu menu = new Menu(ihmUtil);
		menu.start();
	}
}
