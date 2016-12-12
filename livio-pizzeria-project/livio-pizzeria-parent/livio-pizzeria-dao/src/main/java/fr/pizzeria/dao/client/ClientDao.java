package fr.pizzeria.dao.client;

import java.util.List;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * 
 * @since 12/12/2016
 */
public interface ClientDao {
	/**
	 * 
	 * @param client
	 * @throws ClientException
	 */
	Boolean inscription(Client client) throws ClientException;

	/**
	 * 
	 * @param client
	 * @throws ClientException
	 */
	Boolean connection(String nom, String mdp) throws ClientException;

	/**
	 * 
	 * @return
	 * @throws ClientException
	 */
	List<Pizza> Commander() throws ClientException;

	/**
	 * 
	 * @throws ClientException
	 */
	void listerCommande() throws ClientException;

	default void quitApp() throws ClientException {
		throw new ClientException("Not implemented");
	}

}
