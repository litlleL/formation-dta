package fr.pizzeria.dao.livreur;

import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.dao.exception.LivreurException;
import fr.pizzeria.model.Livreur;

/**
 * 
 * @author AsdrubaL
 * 
 * @see LivreurDao
 * @since 18/12/2016
 * 
 *
 */
public class LivreurDaoJpa implements LivreurDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private boolean connected;

	public LivreurDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		setConnected(false);
		this.setEntityManagerFactory(Persistence.createEntityManagerFactory("livio-pizzeria"));
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

	/**
	 * 
	 * @param run
	 * @return
	 */
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
	public void inscription(Livreur livreur) throws LivreurException {
		// TODO Auto-generated method stub

	}

	@Override
	public int connection(String email, String mdp) throws LivreurException {
		return 0;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean estConnecte() throws LivreurException {
		return isConnected();
	}

	@Override
	public void deconnection() throws LivreurException {
		setConnected(false);
	}

	@Override
	public void SuppressionLivreur(int id) throws LivreurException {
		// re
	}

	@Override
	public void quitApp() throws LivreurException {
		if (this.getEntityManagerFactory() != null) {
			this.getEntityManagerFactory().close();
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

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
