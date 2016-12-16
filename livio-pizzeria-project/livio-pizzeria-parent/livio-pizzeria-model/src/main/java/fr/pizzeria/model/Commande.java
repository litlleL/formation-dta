package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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

	@ManyToMany
	@JoinTable(name = "commandePizza",

			joinColumns =

			@JoinColumn(name = "commandeid", referencedColumnName = "id"),

			inverseJoinColumns =

			@JoinColumn(name = "pizzaid", referencedColumnName = "id")

	)
	private Set<Pizza> pizzaId;

	public Commande(Date date, Statut nonTraitee, AbstractPerson abstractPerson, Set<Pizza> pizza) {
		super();
		setDate(date);
		setStatut(nonTraitee);
		setClientId(abstractPerson);
		this.pizzaId = pizza;
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

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + "]";
	}

}
