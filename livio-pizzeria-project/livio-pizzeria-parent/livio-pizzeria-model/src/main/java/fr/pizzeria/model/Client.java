package fr.pizzeria.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.pizzeria.model.utils.AbstractPerson;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */

@Entity
@DiscriminatorValue("Client")
public class Client extends AbstractPerson {

	private String adresse;
	private String email;
	private String motDePasse;

	@OneToMany(mappedBy = "clientId")
	List<Commande> commande;

	public Client() {

	}

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param email
	 * @param motDePasse
	 */
	public Client(String nom, String prenom, String adresse, String email, String motDePasse) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setMotDePasse(motDePasse);
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Client [nom=" + this.getNom() + ", prenom=" + this.getPrenom() + ", adresse=" + this.getAdresse()
				+ ", email=" + this.getEmail() + ", mdp=" + this.getMotDePasse() + "]";
	}
}
