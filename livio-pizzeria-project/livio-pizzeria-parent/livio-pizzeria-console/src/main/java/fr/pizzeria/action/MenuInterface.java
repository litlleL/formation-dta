package fr.pizzeria.action;

import fr.pizzeria.dao.exception.PizzaException;

public abstract class MenuInterface {

	private String libelle;

	public abstract void executeAction() throws PizzaException;

	public abstract void show();

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
