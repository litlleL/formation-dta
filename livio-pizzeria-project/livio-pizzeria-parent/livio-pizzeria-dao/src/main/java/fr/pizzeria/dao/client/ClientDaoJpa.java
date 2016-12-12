package fr.pizzeria.dao.client;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * @see ClientDao
 * @since 12/12/2016
 */
public class ClientDaoJpa implements ClientDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public ClientDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		this.setEntityManagerFactory(Persistence.createEntityManagerFactory("livio-pizzeria-console-client"));
	}

	/**
	 * 
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	interface IrunJql<T> {
		T exec(EntityManager entityManager);
	}

	public <T> T execute(IrunJql<T> run) {
		try {
			setEntityManager(getEntityManagerFactory().createEntityManager());

			return run.exec(entityManager);

		} catch (Exception e) {
			if (getEntityManager() != null) {
				getEntityManager().getTransaction().rollback();
			}
			throw new ClientException(e);
		} finally {
			if (entityManager != null) {
				getEntityManager().close();
			}
		}
	}

	@Override
	public void inscription(Client client) throws ClientException {
		execute((EntityManager entity) -> {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(client);
			getEntityManager().getTransaction().commit();
			return null;
		});
	}

	@Override
	public List<Pizza> Commander() throws ClientException {
		return null;
	}

	@Override
	public void connection(String mail, String mdp) throws ClientException {

	}

	@Override
	public void listerCommande() throws ClientException {

	}

	@Override
	public void quitApp() throws ClientException {
		if (this.getEntityManagerFactory() != null) {
			this.getEntityManagerFactory().close();
		} else {
			System.out.println("null");
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
