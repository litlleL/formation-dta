package fr.pizzeria.dao.service.livreur;

import fr.pizzeria.dao.livreur.LivreurDao;

/**
 * 
 * @author AsdrubaL
 * 
 * @since 18/12/2016
 *
 */
public abstract class LivreurDaoFactory {

	private LivreurDao livreurDao;

	/**
	 * 
	 * @param livreurDao
	 */
	public LivreurDaoFactory(LivreurDao livreurDao) {
		this.livreurDao = livreurDao;
	}

	/**
	 * 
	 * @return livreurDao
	 */
	public LivreurDao getLivreurDao() {
		return livreurDao;
	}

}
