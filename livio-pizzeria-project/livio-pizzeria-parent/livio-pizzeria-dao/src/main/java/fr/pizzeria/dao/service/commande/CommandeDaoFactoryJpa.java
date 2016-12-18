package fr.pizzeria.dao.service.commande;

import fr.pizzeria.dao.commande.CommandeDaoJpa;

/**
 * 
 * @author Asdrubal Livio
 * @see CommandeDaoFactory
 * 
 * @since 19/12/2016
 */
public class CommandeDaoFactoryJpa extends CommandeDaoFactory {

	public CommandeDaoFactoryJpa() {
		super(new CommandeDaoJpa());
	}
}
