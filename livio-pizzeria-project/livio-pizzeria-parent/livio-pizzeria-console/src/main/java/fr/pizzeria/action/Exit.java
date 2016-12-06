package fr.pizzeria.action;

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
		System.out.println("Au revoir ^^'");
		System.exit(0);
	}

	@Override
	public void show() {
		System.out.println(this.getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}
}
