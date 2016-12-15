package fr.pizzeria.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

	private Livreur() {
		super();
	}
}
