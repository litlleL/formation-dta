package fr.pizzeria.client.action;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import fr.pizzeria.client.ihm.IhmUtil;
import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

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
	}

	@Override
	public void executeAction() throws PizzaException {
		Logger.getLogger(Commander.class.getName()).info("---------- Liste des pizzas ----------\n\n");
		String choix;

		Map<Integer, Pizza> commande = new HashMap<>();
		do {

			int pizzaChoisi;

			do {
				this.getIhmUtil().getPizzaDao().findAll().forEach(System.out::println);

				Logger.getAnonymousLogger().info("---------- Choisissez vottre pizza ----------\n\n");
				pizzaChoisi = this.getIhmUtil().getScanner().nextInt();

				Logger.getAnonymousLogger().info("Vous avez choisi cette pizza: \n");
				System.out.println(this.getIhmUtil().getPizzaDao().findAll().get(pizzaChoisi - 1));

				Logger.getAnonymousLogger()
						.info("---------- Est ce la bonne pizza (\"n\") sinon tapez (\"o\") ----------\n\n");
				choix = this.getIhmUtil().getScanner().next();
			} while (("n").equals(choix) || ("N").equals(choix));

			Pizza pizza = this.getIhmUtil().getPizzaDao().findAll().get(pizzaChoisi - 1);

			Logger.getAnonymousLogger().info("Combien en voulez vous?: \n");
			int quantité;
			quantité = this.getIhmUtil().getScanner().nextInt();

			commande.put(quantité, pizza);
			Logger.getAnonymousLogger()
					.info("---------- Pour commander une autre pizza tapez (\"o\") sinon tapez (\"n\") ----------\n\n");
			choix = this.getIhmUtil().getScanner().next();
		} while (("o").equals(choix) || ("O").equals(choix));

		if (this.getIhmUtil().getCommandeDao().commander(commande)) {
			Logger.getLogger(Commander.class.getName())
					.info("---------- Votre commande à bien été effectuer ----------- \n");
		} else {
			Logger.getLogger(Commander.class.getName())
					.info("---------- Erreur lors de la commande (rupture de stock) DSL ----------- \n");
		}
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
