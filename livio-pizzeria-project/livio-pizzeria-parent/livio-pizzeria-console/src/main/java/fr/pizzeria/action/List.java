package fr.pizzeria.action;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public class List extends MenuInterface {

	@Autowired
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public List(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Lister les pizzas");
	}

	@Override
	public void executeAction() {
		this.ihmUtil.getPizzaDao().findAll().forEach(System.out::println);

		Logger.getLogger(List.class.getName())
				.info("------------------ " + Pizza.getNbPizzas() + " pizzas cr�es depuis le lancement du programme");
	}

	@Override
	public void show() {
		Logger.getLogger(List.class.getName()).info(this.getLibelle());
	}

	public String libelle() {
		return this.getLibelle();
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
