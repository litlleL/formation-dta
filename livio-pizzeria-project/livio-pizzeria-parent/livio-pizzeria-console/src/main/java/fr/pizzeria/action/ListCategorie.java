package fr.pizzeria.action;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public class ListCategorie extends MenuInterface {

	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public ListCategorie(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Lister les pizzas par cat�gorie");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() {
		Map<CategoriePizza, List<Pizza>> map =

				this.ihmUtil.getPizzaDao().findAll().stream()
						.collect(Collectors.groupingBy(pizza -> pizza.getCategoriePizza()));

		map.entrySet().stream().forEach(System.out::println);
	}

	@Override
	public void show() {
		Logger.getLogger(ListCategorie.class.getName()).info(this.getLibelle());
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
