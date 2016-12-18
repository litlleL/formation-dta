package fr.pizzeria.dao.livreur;

import java.util.List;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.dao.exception.LivreurException;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;

/**
 * 
 * @author AsdrubaL
 * 
 * @since 18/12/2016
 *
 */
public interface LivreurDao {
	/**
	 * 
	 * @param livreur
	 * @throws LivreurException
	 */
	void inscription(Livreur livreur) throws LivreurException;

	/**
	 * 
	 * @param email
	 * @param mdp
	 * @throws LivreurException
	 */
	void connection(String email, String mdp) throws LivreurException;

	/**
	 * 
	 * @return
	 * @throws LivreurException
	 */
	List<Commande> listerCommande() throws LivreurException;

	/**
	 * 
	 * @param id
	 * @throws LivreurException
	 */
	void gererCommande(int id) throws LivreurException;

	/**
	 * 
	 * @return
	 * @throws LivreurException
	 */
	boolean estConnecte() throws LivreurException;

	/**
	 * 
	 * @throws LivreurException
	 */
	void deconnection() throws LivreurException;

	/**
	 * 
	 * @throws LivreurException
	 */
	default void quitApp() throws LivreurException {
		throw new ClientException("Not implemented");
	}
}
