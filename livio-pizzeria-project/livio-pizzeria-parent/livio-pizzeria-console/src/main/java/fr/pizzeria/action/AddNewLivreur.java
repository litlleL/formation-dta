package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 19/12/2016
 */
public class AddNewLivreur extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public AddNewLivreur(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Ajouter un livreur");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() throws PizzaException {
		Logger.getLogger(AddNewLivreur.class.getName())
				.info("----------- Vous vous apprétez à ajouter un nouveau livreur: ---------------\n\n");

		Logger.getLogger(AddNewLivreur.class.getName()).info("----------- Entrez son nom: ---------------\n\n");
		Logger.getLogger(AddNewLivreur.class.getName()).info("----------- Entrez son prenom: ---------------\n\n");

	}

	@Override
	public void show() {
		Logger.getLogger(AddNewLivreur.class.getName()).info(getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
