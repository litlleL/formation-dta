package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;

/**
 * 
 * @author Asdrubal Livio
 *
 *         Date 09/12/2016
 */
public class InsertQuick extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public InsertQuick(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Inserez 3 par 3");
	}

	@Override
	public void executeAction() throws PizzaException {
		Logger.getLogger(InsertQuick.class.getName()).info("Envoi des donnees de la memoire vers la base \n");
		this.ihmUtil.getPizzaDao().switchData();
	}

	@Override
	public void show() {
		Logger.getLogger(InsertQuick.class.getName()).info(this.getLibelle());
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
