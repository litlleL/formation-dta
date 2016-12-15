package fr.pizzeria.client.action;

import java.util.logging.Logger;

import fr.pizzeria.client.ihm.IhmUtil;
import fr.pizzeria.dao.exception.PizzaException;

/**
 * 
 * @author Asdrubal
 * 
 * @since 15/12/2016
 *
 */
public class ListStatut extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public ListStatut(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Lister mes commandes par statut");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() throws PizzaException {

	}

	@Override
	public void show() {
		Logger.getLogger(ListStatut.class.getName()).info(this.getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
