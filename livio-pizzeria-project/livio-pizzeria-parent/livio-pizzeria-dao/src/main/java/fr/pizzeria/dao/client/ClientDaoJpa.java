package fr.pizzeria.dao.client;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	private boolean connected;

	public ClientDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		setConnected(false);
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

			getEntityManager().getTransaction().begin();
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
	public boolean connection(String mail, String mdp) throws ClientException {
		return execute((EntityManager entity) -> {
			TypedQuery<Client> clientQuery = getEntityManager().createQuery(
					"select p from Client p where p.email ='" + mail + "' and p.motDePasse ='" + mdp + "'",
					Client.class);
			if (clientQuery.getResultList().isEmpty()) {
				setConnected(false);
				return false;
			} else {
				setConnected(true);
				return true;
			}
		});
	}

	@Override
	public List<Pizza> commander() throws ClientException {
		return null;
	}

	@Override
	public void listerCommande() throws ClientException {

	}

	@Override
	public void quitApp() throws ClientException {
		if (this.getEntityManagerFactory() != null) {
			this.getEntityManagerFactory().close();
		}
	}

	@Override
	public boolean estConnecte() throws ClientException {
		return isConnected();
	}

	@Override
	public void deconnection() throws ClientException {
		setConnected(false);
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
