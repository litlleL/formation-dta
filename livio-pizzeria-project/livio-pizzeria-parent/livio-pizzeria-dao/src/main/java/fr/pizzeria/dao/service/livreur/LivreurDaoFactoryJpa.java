package fr.pizzeria.dao.service.livreur;

import fr.pizzeria.dao.livreur.LivreurDaoJpa;

/**
 * 
 * @author AsdrubaL
 * 
 * @see LivreurDaoFactory
 * @since 18/12/2016
 *
 */
public class LivreurDaoFactoryJpa extends LivreurDaoFactory {

	public LivreurDaoFactoryJpa() {
		super(new LivreurDaoJpa());
	}
}
