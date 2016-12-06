package fr.pizzeria.action;

import fr.pizzeria.ihm.IhmUtil;

public class ListCher extends MenuInterface {

	private IhmUtil ihmUtil;

	public ListCher(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Afficher pizza la plus cher");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() {

		System.out.println(this.ihmUtil.getPizzaDao().findAll().stream()
				.max((pizza1, pizza2) -> Double.compare(pizza1.getPrix(), pizza2.getPrix())).get());

		//
		// pizza.stream().max(Comparator.comparing(Pizza::getPrix))
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
