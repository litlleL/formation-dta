package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;

public class Delete extends MenuInterface {

	private IhmUtil ihmUtil;

	public Delete(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Supprimer une pizza");
	}

	@Override
	public void executeAction() throws PizzaException {

		this.ihmUtil.getPizzaDao().findAll().forEach(System.out::println);
		
		Logger.getLogger(Delete.class.getName()).info("Veuillez choisir la pizza à supprimer\n");
		int choix;
		choix = this.ihmUtil.getScanner().nextInt();
		this.ihmUtil.getPizzaDao().deletePizza(choix);
	}

	@Override
	public void show() {
		Logger.getLogger(Delete.class.getName()).info(this.getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}
}
