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
	void inscription(Client client) throws ClientException;

	/**
	 * 
	 * @param nom
	 * @param mdp
	 * @throws ClientException
	 */
	boolean connection(String email, String mdp) throws ClientException;

	/**
	 * 
	 * @throws ClientException
	 */
	void deconnection() throws ClientException;

	/**
	 * 
	 * @return
	 * @throws ClientException
	 */
	List<Pizza> commander() throws ClientException;

	/**
	 * 
	 * @throws ClientException
	 */
	void listerCommande() throws ClientException;

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
