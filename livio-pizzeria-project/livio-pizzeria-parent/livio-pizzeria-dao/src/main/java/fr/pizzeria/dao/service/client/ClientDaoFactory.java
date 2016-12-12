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
	 * @param pizzaDao
	 */
	public ClientDaoFactory(ClientDao clientDao) {
		setClientDao(clientDao);
	}

	/**
	 * @return the clientDao
	 */
	public ClientDao getClientDao() {
		return clientDao;
	}

	/**
	 * @param clientDao
	 *            the clientDao to set
	 */
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

}
