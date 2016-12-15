package fr.pizzeria.dao.client;

import java.util.List;
import java.util.Map;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
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
	boolean commander(Map<Integer, Pizza> commande) throws ClientException;

	/**
	 * 
	 * @throws ClientException
	 */
	List<Commande> listerCommande() throws ClientException;

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
