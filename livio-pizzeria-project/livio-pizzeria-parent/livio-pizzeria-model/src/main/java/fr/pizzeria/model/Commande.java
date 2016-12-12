package fr.pizzeria.model;

import java.sql.Date;
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
	@ManyToMany
	@JoinTable(name = "commandePizza",

			joinColumns =

			@JoinColumn(name = "commandeid", referencedColumnName = "id"),

			inverseJoinColumns =

			@JoinColumn(name = "pizzaid", referencedColumnName = "id")

	)
	private List<Pizza> pizzas;
	@OneToOne
	private AbstractPerson livreurId;
	@OneToOne
	private AbstractPerson clientId;

	private Commande() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
