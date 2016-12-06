package fr.pizzeria.enumeration;

public enum CategoriePizza {

	VIANDE("VIANDE"), POISSON("POISSON"), SANS_VIANDE("SANS_VIANDE");

	private String value;

	private CategoriePizza(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
