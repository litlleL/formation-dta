package fr.pizzeria.client.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.client.ihm.IhmUtil;
import fr.pizzeria.dao.exception.PizzaException;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */
public class Commander extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Commander(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Commander");
		this.setIhmUtil(ihmUtil);
		java.util.logging.Logger.getLogger(Commander.class.getName()).setLevel(Level.SEVERE);
	}

	@Override
	public void executeAction() throws PizzaException {
		Logger.getLogger(Commander.class.getName()).info("---------- Liste des pizzas ----------\n\n");
		String choix = null;
		do {
			this.getIhmUtil().getPizzaDao().findAll().forEach(System.out::println);

			Logger.getAnonymousLogger().info("---------- Choisissez vottre pizza ----------\n\n");

			int pizzaChoisi = 0;
			pizzaChoisi = this.getIhmUtil().getScanner().nextInt();

			Logger.getAnonymousLogger().info("Vous avez choisi cette pizza: \n");
			System.out.println(this.getIhmUtil().getPizzaDao().findAll().get(pizzaChoisi - 1));

			Logger.getAnonymousLogger()
					.info("---------- Pour commander une autre pizza tapez (\"o\") sinon tapez (\"n\") ----------\n\n");
			choix = this.getIhmUtil().getScanner().next();
		} while (choix.equals("o") || choix.equals("O"));
	}

	@Override
	public void show() {
		Logger.getLogger(Commander.class.getName()).info(getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
