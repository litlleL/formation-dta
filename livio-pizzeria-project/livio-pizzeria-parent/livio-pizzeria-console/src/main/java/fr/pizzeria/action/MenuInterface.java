package fr.pizzeria.action;

public abstract class MenuInterface {

	private String libelle;

	public abstract void executeAction();

	public abstract void show();

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
