package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.inject.Default;

import fr.pizzeria.model.Client;

@Default
public class ClientService {

	@EJB
	private ClientServiceEjb clientDao;

	public List<Client> findAll() {
		return getClientDao().findAll();
	}

	public void inscription(Client client) {
		getClientDao().inscription(client);
		return;
	}

	public void update(int id, Client client) {
		getClientDao().update(id, client);
	}

	/**
	 * @return the clientDao
	 */
	public ClientServiceEjb getClientDao() {
		return clientDao;
	}

}
