package fr.pizzeria.enumeration;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */
public enum Statut {

	EN_ATTENTE("En attente"), EN_COURS("En cours de livraison"), TERMINER("Livrée");

	private String value;

	/**
	 * 
	 * @param value
	 */
	private Statut(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}
}
