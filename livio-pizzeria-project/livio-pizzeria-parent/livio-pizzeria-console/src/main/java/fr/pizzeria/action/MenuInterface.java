package fr.pizzeria.action;

import fr.pizzeria.dao.exception.PizzaException;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public abstract class MenuInterface {

	private String libelle;

	/**
	 * 
	 * @throws PizzaException
	 */
	public abstract void executeAction() throws PizzaException;

	public abstract void show();

	public String getLibelle() {
		return libelle;
	}

	/**
	 * 
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
