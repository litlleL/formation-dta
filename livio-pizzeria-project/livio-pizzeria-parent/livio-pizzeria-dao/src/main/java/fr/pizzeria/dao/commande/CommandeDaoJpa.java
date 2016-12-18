package fr.pizzeria.dao.commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.dao.exception.CommandeException;
import fr.pizzeria.enumeration.Statut;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.utils.AbstractPerson;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 19/12/2016
 */
public class CommandeDaoJpa implements CommandeDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private int clientId;

	public CommandeDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
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
	public boolean commander(Map<Integer, Pizza> commande) throws CommandeException {

		execute((EntityManager entity) -> {
			TypedQuery<AbstractPerson> clientQuery = getEntityManager()
					.createQuery("select p from Client p where p.id ='" + getClientId() + "'", AbstractPerson.class);
			Commande commandes = new Commande();
			List<Pizza> pizzas = new ArrayList<>();
			commande.forEach((k, v) -> {
				for (int i = 0; i < k; i++) {
					pizzas.add(v);
				}
				commandes.setClientId(clientQuery.getResultList().get(0));
				commandes.setDate(new Date());
				commandes.setStatut(Statut.NON_TRAITEE);
				commandes.setPizzas(pizzas);
				getEntityManager().getTransaction().begin();
				getEntityManager().persist(commandes);
				getEntityManager().getTransaction().commit();
			});
			return true;
		});

		return true;
	}

	@Override
	public List<Commande> listerCommande() throws CommandeException {
		return execute((EntityManager entity) -> {
			TypedQuery<Commande> commandeQuery = getEntityManager()
					.createQuery("select c from Commande c where c.clientId ='" + getClientId() + "'", Commande.class);

			return commandeQuery.getResultList();
		});
	}

	@Override
	public void gererCommande(int id) throws CommandeException {

	}

	@Override
	public void setSession(int id) throws CommandeException {
		setClientId(id);
	}

	@Override
	public void quitApp() throws ClientException {
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

}
