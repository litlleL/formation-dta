package fr.pizzeria.action;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;

public class InsertQuick extends MenuInterface {
	private IhmUtil ihmUtil;

	public InsertQuick(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Inserez 3 par 3");
	}

	@Override
	public void executeAction() throws PizzaException {

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
