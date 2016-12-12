package fr.pizzeria.dao.service.client;

import fr.pizzeria.dao.client.ClientDao;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 12/12/2016
 */
public abstract class ClientDaoFactory {

	private ClientDao clientDao;

	/**
	 * 
	 * @param clientDao
	 */
	public ClientDaoFactory(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	/**
	 * @return
	 */
	public ClientDao getClientDao() {
		return clientDao;
	}

}
