package fr.pizzeria.client.action;

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
public class ListerCommande extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public ListerCommande(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Lister les commandes");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() throws PizzaException {

	}

	@Override
	public void show() {
		Logger.getLogger(ListerCommande.class.getName()).info(getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
