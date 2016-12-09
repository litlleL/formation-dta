package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 *         Date 09/12/2016
 */
public class Update extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Update(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Mettre à jour une pizza");
	}

	@Override
	public void executeAction() throws PizzaException {
		this.ihmUtil.getPizzaDao().findAll().forEach(System.out::println);

		Logger.getLogger(Update.class.getName()).info("Veuillez choisir la pizza à modifier\n");

		int choix;
		choix = this.ihmUtil.getScanner().nextInt();

		String codePizza;
		Logger.getLogger(Update.class.getName()).info("Veuillez saisir le nouveau code \n");
		codePizza = ihmUtil.getScanner().next();

		String nomPizza;
		Logger.getLogger(Update.class.getName()).info("Veuillez saisir le nouveau nom(sans espace) \n");
		nomPizza = ihmUtil.getScanner().next();

		Double prixPizza;
		Logger.getLogger(Update.class.getName()).info("Veuillez saisir le nouveau prix");
		prixPizza = ihmUtil.getScanner().nextDouble();

		int categorie;
		Logger.getLogger(Update.class.getName()).info("Veuillez choisir la ca�gorie de votre pizza");
		Logger.getLogger(Update.class.getName()).info("\n1 -> Viande \n2 -> Sans Viande \n3 -> Poisson");
		categorie = ihmUtil.getScanner().nextInt();

		if (categorie == 1) {
			this.ihmUtil.getPizzaDao().updatePizza(choix,
					new Pizza(choix, codePizza, nomPizza, prixPizza, CategoriePizza.VIANDE));
		} else if (categorie == 2) {
			this.ihmUtil.getPizzaDao().updatePizza(choix,
					new Pizza(choix, codePizza, nomPizza, prixPizza, CategoriePizza.SANS_VIANDE));
		} else {
			this.ihmUtil.getPizzaDao().updatePizza(choix,
					new Pizza(choix, codePizza, nomPizza, prixPizza, CategoriePizza.POISSON));
		}

	}

	@Override
	public void show() {
		Logger.getLogger(Update.class.getName()).info(this.getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	/**
	 * 
	 * @param ihmUtil
	 */
	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}
}
