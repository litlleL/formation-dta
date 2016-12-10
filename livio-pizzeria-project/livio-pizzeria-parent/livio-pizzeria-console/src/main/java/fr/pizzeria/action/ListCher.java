package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.ihm.IhmUtil;

/**
 * 
 * @author Asdrubal Livio
 *
 *         Date 09/12/2016
 */
public class ListCher extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public ListCher(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Afficher pizza la plus cher");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() {

		System.out.println(this.ihmUtil.getPizzaDao().findAll().stream()
				.max((pizza1, pizza2) -> Double.compare(pizza1.getPrix(), pizza2.getPrix())).get());

		// pizza.stream().max(Comparator.comparing(Pizza::getPrix))
	}

	@Override
	public void show() {
		Logger.getLogger(List.class.getName()).info(this.getLibelle());
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
