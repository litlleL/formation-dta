package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import fr.pizzeria.enumeration.CategoriePizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * 
 * @since 09/12/2016
 */

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	private String code;
	private String nom;
	private Double prix;
	@Enumerated(EnumType.STRING)
	private CategoriePizza categoriePizza;
	private String urlImage;
	private boolean archiver = false;
	@Transient
	private static int nbPizzas;

	public Pizza() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categoriePizza
	 */
	public Pizza(int id, String code, String nom, double prix, CategoriePizza categoriePizza) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
	}

	/**
	 * 
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categoriePizza
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categoriePizza) {
		super();
		this.id = nbPizzas;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = categoriePizza;
		nbPizzas += 1;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categorie, String urlImage, boolean archiver) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.setArchiver(archiver);
		this.categoriePizza = categorie;
		this.urlImage = urlImage;
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(code).append(nom).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().append(code, rhs.code).append(nom, rhs.nom).append(prix, rhs.prix).isEquals();
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", nom=" + nom + ", prix=" + prix + "]";
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public boolean isArchiver() {
		return archiver;
	}

	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}

}
