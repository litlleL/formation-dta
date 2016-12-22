package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEjb implements PizzaDao {

	@PersistenceContext(unitName = "pizza-ds")
	private EntityManager entityManager;

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
			TypedQuery<Pizza> pizzaQuery = getEntityManager()
					.createQuery("select p from Pizza p where p.archiver='false'", Pizza.class);
			return pizzaQuery.getResultList();
		});

	}

	@Override
	public void save(Pizza p) throws PizzaException {

	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {

	}

	@Override
	public void deletePizza(int id) throws PizzaException {

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
