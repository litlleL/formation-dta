package fr.pizzeria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
	@Column(name = "ID")
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
	@JoinTable(name = "commandePizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"))
	private List<Pizza> pizzas;

	public Commande() {

	}

	public Commande(Date date, Statut nonTraitee, AbstractPerson abstractPerson, List<Pizza> pizzas) {
		super();
		setDate(date);
		setStatut(nonTraitee);
		setClientId(abstractPerson);
		this.pizzas = pizzas;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
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
