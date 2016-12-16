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
@DiscriminatorValue("Livreur")
public class Livreur extends AbstractPerson {
	@OneToMany(mappedBy = "livreurId")
	List<Commande> commande;

	private Livreur() {
		super();
	}
}
