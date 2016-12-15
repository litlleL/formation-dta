package fr.pizzeria.client.ihm;

import java.awt.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import fr.pizzeria.client.action.Commander;
import fr.pizzeria.client.action.Connection;
import fr.pizzeria.client.action.Exit;
import fr.pizzeria.client.action.Inscription;
import fr.pizzeria.client.action.ListStatut;
import fr.pizzeria.client.action.ListerCommande;
import fr.pizzeria.client.action.MenuInterface;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 12/12/2016
 */
public class MenuClient {

	Map<Integer, MenuInterface> listeOutils = new HashMap<>();

	private IhmUtil reader;

	/**
	 * 
	 * @param ihmUtil
	 */
	public MenuClient(IhmUtil ihmUtil) {
		this.reader = ihmUtil;
	}

	public void start() {
		getMenu();
		showMenu();
		executeAction();
	}

	private void getMenu() {
		if (!this.reader.getClientDao().estConnecte()) {
			listeOutils.put(0, new Inscription(reader));
			listeOutils.put(1, new Connection(reader));
			listeOutils.put(2, new Exit(reader));
		} else {
			listeOutils.put(0, new Commander(reader));
			listeOutils.put(1, new ListerCommande(reader));
			listeOutils.put(2, new ListStatut(reader));
			listeOutils.put(3, new Exit(reader));
		}
	}

	private void showMenu() {
		listeOutils.forEach((k, v) -> System.out.println((k + 1) + ": " + v.getLibelle()));
	}

	private void executeAction() {

		Logger.getLogger(Menu.class.getName()).info("Faites un choix  \n\n");
		String value = reader.getScanner().next();
		if (!this.reader.getClientDao().estConnecte()) {

			if (Integer.parseInt(value) < 3) {
				listeOutils.get(Integer.parseInt(value) - 1).executeAction();
				start();
			} else if (Integer.parseInt(value) >= 3) {
				this.reader.getClientDao().quitApp();
				this.reader.getPizzaDao().quitApp();
				return;
			}
		} else {

			if (Integer.parseInt(value) < 4) {
				listeOutils.get(Integer.parseInt(value) - 1).executeAction();
				start();
			} else if (Integer.parseInt(value) >= 4) {
				listeOutils.get(listeOutils.size() - 1).executeAction();
				start();
			}
		}

	}

}
