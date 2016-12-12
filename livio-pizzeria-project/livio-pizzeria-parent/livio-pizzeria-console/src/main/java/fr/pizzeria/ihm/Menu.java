package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.action.Create;
import fr.pizzeria.action.Delete;
import fr.pizzeria.action.Exit;
import fr.pizzeria.action.InsertQuick;
import fr.pizzeria.action.List;
import fr.pizzeria.action.ListCategorie;
import fr.pizzeria.action.ListCher;
import fr.pizzeria.action.MenuInterface;
import fr.pizzeria.action.Update;
import fr.pizzeria.dao.exception.PizzaException;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public class Menu {

	Map<Integer, MenuInterface> listeOutils = new HashMap<>();

	IhmUtil reader;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Menu(IhmUtil ihmUtil) {
		listeOutils.put(0, new List(ihmUtil));
		listeOutils.put(1, new ListCategorie(ihmUtil));
		listeOutils.put(2, new ListCher(ihmUtil));
		listeOutils.put(3, new Create(ihmUtil));
		listeOutils.put(4, new Update(ihmUtil));
		listeOutils.put(5, new Delete(ihmUtil));
		listeOutils.put(6, new InsertQuick(ihmUtil));
		listeOutils.put(7, new Exit(ihmUtil));
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

		if (Integer.parseInt(value) < 8) {
			listeOutils.get(Integer.parseInt(value) - 1).executeAction();
			start();
		} else if (Integer.parseInt(value) >= 8) {
			listeOutils.get(listeOutils.size() - 1).executeAction();
			this.reader.getPizzaDao().quitApp();
			return;
		}

	}

}
