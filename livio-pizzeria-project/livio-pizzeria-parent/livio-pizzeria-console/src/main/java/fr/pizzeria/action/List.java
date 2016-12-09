package fr.pizzeria.action;

import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 *         Date 09/12/2016
 */
public class List extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public List(IhmUtil ihmUtil) {
		super();
		this.setIhmUtil(ihmUtil);
		this.setLibelle("Lister les pizzas");
	}

	@Override
	public void executeAction() throws PizzaException {
		this.ihmUtil.getPizzaDao().findAll().forEach(System.out::println);

		Logger.getLogger(List.class.getName())
				.info("------------------ " + Pizza.getNbPizzas() + " pizzas cr�es depuis le lancement du programme");
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
