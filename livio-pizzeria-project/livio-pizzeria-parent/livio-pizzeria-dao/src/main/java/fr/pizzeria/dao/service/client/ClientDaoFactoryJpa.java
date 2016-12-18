package fr.pizzeria.dao.service.client;

import fr.pizzeria.dao.client.ClientDaoJpa;

/**
 * 
 * @author Asdrubal Livio
 * @see ClientDaoFactory
 * 
 * @since 12/12/2016
 */
public class ClientDaoFactoryJpa extends ClientDaoFactory {

	public ClientDaoFactoryJpa() {
		super(new ClientDaoJpa());
	}
}
