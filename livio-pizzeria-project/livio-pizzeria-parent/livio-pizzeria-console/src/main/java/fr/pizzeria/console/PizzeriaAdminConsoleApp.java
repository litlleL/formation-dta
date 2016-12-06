package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.service.PizzaDaoFactory;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		Pizza p1 = new Pizza();
		p1.setCode("MAR");

		Pizza p2 = new Pizza();
		p2.setCode("MAR");

		System.out.println("p1=p2 ? " + p1.equals(p2));

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");

		PizzaDaoFactory daoFactory = null;
		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), daoFactory);
		Menu menu = new Menu(ihmUtil);
		menu.start();
	}
}
