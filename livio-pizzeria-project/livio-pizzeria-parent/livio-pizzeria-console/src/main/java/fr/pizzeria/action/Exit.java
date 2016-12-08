package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.ihm.IhmUtil;

public class Exit extends MenuInterface {


	private IhmUtil ihmUtil;

	public Exit(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("sortir");
		
	}

	@Override
	public void executeAction() {
		Logger.getLogger(Exit.class.getName()).info("Au revoir ^^'");
		System.exit(0);
	}

	@Override
	public void show() {
		Logger.getLogger(Exit.class.getName()).info(this.getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}
}
