package fr.pizzeria.dao.livreur;

import fr.pizzeria.dao.exception.LivreurException;
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
	int connection(String email, String mdp) throws LivreurException;

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
		throw new LivreurException("Not implemented");
	}

	/**
	 * 
	 * @param id
	 * @throws LivreurException
	 */
	void SuppressionLivreur(int id) throws LivreurException;
}
