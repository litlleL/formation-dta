package fr.pizzeria.dao.client;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public class ClientDaoJpa implements ClientDao {
	private EntityManagerFactory entityManagerFactory;

	public ClientDaoJpa() {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		this.setEntityManagerFactory(Persistence.createEntityManagerFactory("livio-pizzeria-console"));
	}

	@Override
	public List<Pizza> Commander() throws ClientException {
		return null;
	}

	@Override
	public Boolean inscription(Client client) throws ClientException {
		return false;
	}

	@Override
	public Boolean connection(String mail, String mdp) throws ClientException {
		return false;
	}

	@Override
	public void listerCommande() throws ClientException {

	}

	@Override
	public void quitApp() throws ClientException {
		this.getEntityManagerFactory().close();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}
