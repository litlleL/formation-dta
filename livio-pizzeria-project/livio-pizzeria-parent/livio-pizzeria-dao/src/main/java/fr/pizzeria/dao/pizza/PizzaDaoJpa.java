package fr.pizzeria.dao.pizza;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * @see PizzaDao
 * @since 09/12/2016
 */
public class PizzaDaoJpa implements PizzaDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public PizzaDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		this.setEntityManagerFactory(Persistence.createEntityManagerFactory("livio-pizzeria-console"));
	}

	/**
	 * 
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	interface IRunJql<T> {
		T exec(EntityManager entityManager);
	}

	/**
	 * 
	 * @param run
	 * @return
	 */
	public <T> T execute(IRunJql<T> run) {
		try {
			setEntityManager(getEntityManagerFactory().createEntityManager());

			return run.exec(entityManager);

		} catch (Exception e) {
			if (getEntityManager() != null) {
				getEntityManager().getTransaction().rollback();
			}
			throw new PizzaException(e);
		} finally {
			if (entityManager != null) {
				getEntityManager().close();
			}
		}
	}

	@Override
	public List<Pizza> findAll() throws PizzaException {

		return execute((EntityManager entity) -> {
			TypedQuery<Pizza> pizzaQuery = getEntityManager().createQuery("select p from Pizza p", Pizza.class);
			return pizzaQuery.getResultList();
		});

	}

	@Override
	public void save(Pizza p) throws PizzaException {

		execute((EntityManager entity) -> {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(p);
			getEntityManager().getTransaction().commit();
			return null;
		});

	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {

		execute((EntityManager entity) -> {
			Pizza pizza = getEntityManager().find(Pizza.class, id);
			if (getEntityManager() != null) {
				getEntityManager().getTransaction().begin();
				pizza.setCode(p.getCode());
				pizza.setNom(p.getNom());
				pizza.setPrix(p.getPrix());
				pizza.setCategoriePizza(p.getCategoriePizza());
				getEntityManager().getTransaction().commit();
			}
			return null;
		});

	}

	@Override
	public void deletePizza(int id) throws PizzaException {

		execute((EntityManager entity) -> {
			Pizza pizza = getEntityManager().find(Pizza.class, id);

			if (getEntityManager() != null) {
				getEntityManager().getTransaction().begin();
				getEntityManager().remove(pizza);
				getEntityManager().getTransaction().commit();
			}

			return null;
		});

	}

	@Override
	public void quitApp() throws PizzaException {

		this.getEntityManagerFactory().close();
	}

	/**
	 * @return the entityManagerFactory
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * @param entityManagerFactory
	 *            the entityManagerFactory to set
	 */
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
