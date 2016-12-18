package fr.pizzeria.livreur.action;

import fr.pizzeria.dao.exception.LivreurException;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 18/12/2016
 */
public abstract class MenuInterface {

	private String libelle;

	/**
	 * 
	 * @throws LivreurException
	 */
	public abstract void executeAction() throws LivreurException;

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
