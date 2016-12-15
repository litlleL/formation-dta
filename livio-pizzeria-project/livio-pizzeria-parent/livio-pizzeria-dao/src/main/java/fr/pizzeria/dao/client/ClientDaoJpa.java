package fr.pizzeria.dao.client;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.enumeration.Statut;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.utils.AbstractPerson;

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
	private int clientId;

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
			TypedQuery<AbstractPerson> clientQuery = getEntityManager().createQuery(
					"select p from Client p where p.email ='" + mail + "' and p.motDePasse ='" + mdp + "'",
					AbstractPerson.class);
			if (clientQuery.getResultList().isEmpty()) {
				setConnected(false);
				return false;
			} else {
				setClientId(clientQuery.getResultList().get(0).getId());
				setConnected(true);
				return true;
			}
		});
	}

	@Override
	public boolean commander(Map<Integer, Pizza> commande) throws ClientException {

		return execute((EntityManager entity) -> {
			TypedQuery<AbstractPerson> clientQuery = getEntityManager()
					.createQuery("select p from Client p where p.id ='" + getClientId() + "'", AbstractPerson.class);

			commande.forEach((quantite, pizza) -> {
				Commande commandeClient = new Commande(new Date(), quantite, Statut.NON_TRAITEE,
						clientQuery.getResultList().get(0), pizza);
				getEntityManager().getTransaction().begin();
				getEntityManager().persist(commandeClient);
				getEntityManager().getTransaction().commit();
			});

			return true;

		});
	}

	@Override
	public List<Commande> listerCommande() throws ClientException {
		return execute((EntityManager entity) -> {
			TypedQuery<Commande> commandeQuery = getEntityManager().createQuery("select c from Commande c",
					Commande.class);

			commandeQuery.getResultList().forEach(System.out::println);
			return commandeQuery.getResultList();
		});

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
		setClientId(0);
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

}
