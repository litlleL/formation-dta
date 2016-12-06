package fr.pizzeria.action;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class List extends MenuInterface {

	private IhmUtil ihmUtil;

	public List(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Lister les pizzas");
	}

	@Override
	public void executeAction() {
		this.ihmUtil.getPizzaDao().findAll().forEach(System.out::println);

		System.out.println(
				"------------------ " + Pizza.getNbPizzas() + " pizzas crées depuis le lancement du programme");
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
