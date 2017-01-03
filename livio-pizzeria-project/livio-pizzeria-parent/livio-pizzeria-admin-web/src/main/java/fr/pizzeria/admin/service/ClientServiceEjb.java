package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;

@Stateless
public class ClientServiceEjb {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Client> findAll() throws ClientException {

		TypedQuery<Client> clientQuery = getEntityManager().createQuery("SELECT c FROM Client c", Client.class);
		return (List<Client>) clientQuery.getResultList();

	}

	public void inscription(Client client) {

		getEntityManager().persist(client);

	}

	public void update(Integer id, Client client) {
		Client clientToUp = getEntityManager().find(Client.class, id);
		clientToUp.setAdresse(client.getAdresse());
		clientToUp.setEmail(client.getEmail());
		clientToUp.setNom(client.getNom());
		clientToUp.setPrenom(client.getPrenom());
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
