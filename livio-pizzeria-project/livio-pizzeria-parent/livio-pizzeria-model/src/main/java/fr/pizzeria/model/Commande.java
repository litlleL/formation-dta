package fr.pizzeria.model;

import java.util.Date;
import java.util.List;

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
	@ManyToMany
	@JoinTable(name = "commandePizza",

			joinColumns =

			@JoinColumn(name = "commandeid", referencedColumnName = "id"),

			inverseJoinColumns =

			@JoinColumn(name = "pizzaid", referencedColumnName = "id")

	)
	private List<Pizza> pizzas;

	@ManyToOne
	@JoinColumn(name = "clientId")
	private AbstractPerson clientId;
	@ManyToOne
	@JoinColumn(name = "livreurId")
	private AbstractPerson livreurId;

	public Commande(Date date, Statut nonTraitee, int clientId2) {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
