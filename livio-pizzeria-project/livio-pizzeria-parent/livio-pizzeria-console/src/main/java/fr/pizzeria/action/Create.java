package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 *         Date 09/12/2016
 */
public class Create extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Create(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Ajouter une pizza");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() {
		String codePizza;
		Logger.getLogger(Create.class.getName()).info("Veuillez saisir le code \n");
		codePizza = ihmUtil.getScanner().next();

		String nomPizza;
		Logger.getLogger(Create.class.getName()).info("Veuillez saisir le nom(sans espace) \n");
		nomPizza = ihmUtil.getScanner().next();

		double prixPizza;
		Logger.getLogger(Create.class.getName()).info("Veuillez saisir le prix\n");
		prixPizza = ihmUtil.getScanner().nextDouble();

		int categorie;
		Logger.getLogger(Create.class.getName()).info("\n Veuillez choisir la ca�gorie de votre pizza \n");
		Logger.getLogger(Create.class.getName()).info("\n1 -> Viande \n2 -> Sans Viande \n3 -> Poisson");
		categorie = ihmUtil.getScanner().nextInt();

		if (categorie == 1) {
			this.ihmUtil.getPizzaDao().save(new Pizza(codePizza, nomPizza, prixPizza, CategoriePizza.VIANDE));
		} else if (categorie == 2) {
			this.ihmUtil.getPizzaDao().save(new Pizza(codePizza, nomPizza, prixPizza, CategoriePizza.SANS_VIANDE));
		} else {
			this.ihmUtil.getPizzaDao().save(new Pizza(codePizza, nomPizza, prixPizza, CategoriePizza.POISSON));
		}
	}

	@Override
	public void show() {
		Logger.getLogger(Create.class.getName()).info(this.getLibelle());
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
