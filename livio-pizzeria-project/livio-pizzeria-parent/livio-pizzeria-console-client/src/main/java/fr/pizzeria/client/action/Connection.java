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
public class Connection extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Connection(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Connexion");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() throws PizzaException {
		this.ihmUtil.getClientDao().connection("sdfsdf", "sdfsdf");
	}

	@Override
	public void show() {
		Logger.getLogger(Connection.class.getName()).info(getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
