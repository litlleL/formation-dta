package fr.pizzeria.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.pizzeria.enumeration.Statut;
import fr.pizzeria.model.utils.AbstractPerson;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */

@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	@Enumerated(EnumType.STRING)
	private Statut statut;

	// Clé étrangère

	@ManyToOne
	@JoinColumn(name = "clientId")
	private AbstractPerson clientId;
	@ManyToOne
	@JoinColumn(name = "livreurId")
	private AbstractPerson livreurId;

	private int quantite;
	@OneToOne
	private Pizza pizzaId;

	public Commande(Date date, Integer quantite, Statut nonTraitee, AbstractPerson abstractPerson, Pizza pizza) {
		super();
		setDate(date);
		setQuantite(quantite);
		setStatut(nonTraitee);
		setClientId(abstractPerson);
		setPizzaId(pizza);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public AbstractPerson getClientId() {
		return clientId;
	}

	public void setClientId(AbstractPerson clientId) {
		this.clientId = clientId;
	}

	public AbstractPerson getLivreurId() {
		return livreurId;
	}

	public void setLivreurId(AbstractPerson livreurId) {
		this.livreurId = livreurId;
	}

	public Pizza getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(Pizza pizzaId) {
		this.pizzaId = pizzaId;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + "]";
	}

}
