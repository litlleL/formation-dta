package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.action.Connection;
import fr.pizzeria.action.Exit;
import fr.pizzeria.action.Inscription;
import fr.pizzeria.action.MenuInterface;
import fr.pizzeria.dao.exception.PizzaException;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 12/12/2016
 */
public class Menu {

	Map<Integer, MenuInterface> listeOutils = new HashMap<>();

	IhmUtil reader;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Menu(IhmUtil ihmUtil) {
		listeOutils.put(0, new Inscription(ihmUtil));
		listeOutils.put(1, new Connection(ihmUtil));
		listeOutils.put(2, new Exit(ihmUtil));
		this.reader = ihmUtil;
	}

	/**
	 * 
	 * @throws PizzaException
	 */
	public void start() {
		showMenu();
		executeAction();
	}

	private void showMenu() {
		listeOutils.forEach((k, v) -> System.out.println((k + 1) + ": " + v.getLibelle()));
	}

	/**
	 * 
	 * @throws PizzaException
	 */
	private void executeAction() {

		System.out.println("Faites un choix  \n");

		String value = reader.getScanner().next();

		if (Integer.parseInt(value) < 3) {
			listeOutils.get(Integer.parseInt(value) - 1).executeAction();
			start();
		} else if (Integer.parseInt(value) >= 3) {
			listeOutils.get(listeOutils.size() - 1).executeAction();
			this.reader.getPizzaDao().quitApp();
			this.reader.getClientDao().quitApp();
			return;
		}

	}

}
