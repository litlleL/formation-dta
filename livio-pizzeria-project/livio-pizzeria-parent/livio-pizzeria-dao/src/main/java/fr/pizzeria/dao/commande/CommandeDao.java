package fr.pizzeria.dao.commande;

import java.util.List;
import java.util.Map;

import fr.pizzeria.dao.exception.CommandeException;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * 
 * @since 19/12/2016
 */
public interface CommandeDao {

	/**
	 * 
	 * @return
	 * @throws CommandeException
	 */
	boolean commander(Map<Integer, Pizza> commande) throws CommandeException;

	/**
	 * 
	 * @throws CommandeException
	 */
	List<Commande> listerCommande() throws CommandeException;

	/**
	 * 
	 * @throws CommandeException
	 */
	default void quitApp() throws CommandeException {
		throw new CommandeException("Not implemented");
	}

	void setSession(int id) throws CommandeException;

	void gererCommande(int id) throws CommandeException;
}
