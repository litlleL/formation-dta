package fr.pizzeria.client.action;

import java.util.logging.Logger;

import fr.pizzeria.client.ihm.IhmUtil;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */
public class Exit extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Exit(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("sortir");

	}

	@Override
	public void executeAction() {
		Logger.getLogger(Exit.class.getName()).info("Au revoir ^^'");
	}

	@Override
	public void show() {
		Logger.getLogger(Exit.class.getName()).info(this.getLibelle());
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
