package fr.pizzeria.action;

import java.util.logging.Logger;

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

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
