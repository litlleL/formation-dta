package fr.pizzeria.action;

import fr.pizzeria.ihm.IhmUtil;

public class Delete extends MenuInterface {

	private IhmUtil ihmUtil;

	public Delete(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Supprimer une pizza");
	}

	@Override
	public void executeAction() {

		this.ihmUtil.getPizzaDao().findAll().forEach(System.out::println);

		System.out.println("Veuillez choisir la pizza à supprimer\n");
		int choix;
		choix = this.ihmUtil.getScanner().nextInt() - 1;
		this.ihmUtil.getPizzaDao().deletePizza(this.ihmUtil.getPizzaDao().findAll().get(choix).getId());
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
