package fr.pizzeria.dao.service.commande;

import fr.pizzeria.dao.commande.CommandeDao;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 19/12/2016
 */
public abstract class CommandeDaoFactory {

	private CommandeDao commandeDao;

	public CommandeDaoFactory(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
		;
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}
}
