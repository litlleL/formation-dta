package fr.pizzeria.dao.client;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;

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
	void inscription(Client client) throws ClientException;

	/**
	 * 
	 * @param email
	 * @param mdp
	 * @throws ClientException
	 */
	int connection(String email, String mdp) throws ClientException;

	/**
	 * 
	 * @throws ClientException
	 */
	void deconnection() throws ClientException;

	/**
	 * 
	 * @throws ClientException
	 */
	default void quitApp() throws ClientException {
		throw new ClientException("Not implemented");
	}

	/**
	 * 
	 * @return
	 * @throws ClientException
	 */
	boolean estConnecte() throws ClientException;

}
