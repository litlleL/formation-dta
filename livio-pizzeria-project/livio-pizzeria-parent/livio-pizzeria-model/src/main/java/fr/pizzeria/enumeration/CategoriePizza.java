package fr.pizzeria.enumeration;

/**
 * 
 * @author Asdrubal Livio
 *
 * 
 *         Date 09/12/2016
 */
public enum CategoriePizza {

	VIANDE("VIANDE"), POISSON("POISSON"), SANS_VIANDE("SANS_VIANDE");

	private String value;

	/**
	 * 
	 * @param value
	 */
	private CategoriePizza(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	private void setValue(String value) {
		this.value = value;
	}
}
