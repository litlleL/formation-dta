package fr.pizzeria.livreur.ihm;

import java.awt.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import fr.pizzeria.livreur.action.Connection;
import fr.pizzeria.livreur.action.Exit;
import fr.pizzeria.livreur.action.GererCommande;
import fr.pizzeria.livreur.action.Inscription;
import fr.pizzeria.livreur.action.ListerCommande;
import fr.pizzeria.livreur.action.MenuInterface;

/**
 * 
 * @author AsdrubaL
 * 
 * @since 18/12/2016
 *
 */
public class MenuLivreur {

	Map<Integer, MenuInterface> listeOutils = new HashMap<>();
	private IhmUtil reader;

	/**
	 * 
	 * @param ihmUtil
	 */
	public MenuLivreur(IhmUtil ihmUtil) {
		this.reader = ihmUtil;
		if (!this.reader.getLivreurDao().estConnecte()) {
			listeOutils.put(0, new Inscription(ihmUtil));
			listeOutils.put(1, new Connection(ihmUtil));
			listeOutils.put(2, new Exit(ihmUtil));
		} else {
			listeOutils.put(0, new ListerCommande(ihmUtil));
			listeOutils.put(1, new GererCommande(ihmUtil));
			listeOutils.put(2, new Exit(ihmUtil));
		}
	}

	public void start() {
		showMenu();
		executeAction();
	}

	private void showMenu() {
		listeOutils.forEach((k, v) -> System.out.println((k + 1) + ": " + v.getLibelle()));
	}

	private void executeAction() {

		Logger.getLogger(Menu.class.getName()).info("Faites un choix  \n\n");
		String value = reader.getScanner().next();
		if (!this.getReader().getClientDao().estConnecte()) {

			if (Integer.parseInt(value) < 3) {
				listeOutils.get(Integer.parseInt(value) - 1).executeAction();
				start();
			} else if (Integer.parseInt(value) >= 3) {
				this.getReader().getClientDao().quitApp();
				this.getReader().getPizzaDao().quitApp();
				this.getReader().getLivreurDao().quitApp();
				return;
			}
		} else {

			if (Integer.parseInt(value) < 3) {
				listeOutils.get(Integer.parseInt(value) - 1).executeAction();
				start();
			} else if (Integer.parseInt(value) >= 3) {
				listeOutils.get(listeOutils.size() - 1).executeAction();
				start();
			}
		}

	}

	public IhmUtil getReader() {
		return reader;
	}

	public void setReader(IhmUtil reader) {
		this.reader = reader;
	}

}
