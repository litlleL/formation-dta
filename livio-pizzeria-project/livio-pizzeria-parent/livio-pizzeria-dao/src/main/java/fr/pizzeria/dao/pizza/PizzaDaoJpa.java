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
 * 
 *      Date 09/12/2016
 */
public class PizzaDaoJpa implements PizzaDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public PizzaDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
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
			entityManagerFactory = Persistence.createEntityManagerFactory("livio-pizzeria-console");
			entityManager = entityManagerFactory.createEntityManager();

			return run.exec(entityManager);

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new PizzaException(e);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			entityManagerFactory.close();
		}
	}

	@Override
	public List<Pizza> findAll() throws PizzaException {

		return execute((EntityManager entity) -> {
			TypedQuery<Pizza> pizzaQuery = entityManager.createQuery("select p from Pizza p", Pizza.class);
			List<Pizza> pizzas = pizzaQuery.getResultList();
			return pizzas;
		});

	}

	@Override
	public void save(Pizza p) throws PizzaException {

		execute((EntityManager entity) -> {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
			return null;
		});

	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {

		execute((EntityManager entity) -> {
			Pizza pizza = entityManager.find(Pizza.class, id);
			if (entityManager != null) {
				entityManager.getTransaction().begin();
				pizza.setCode(p.getCode());
				pizza.setNom(p.getNom());
				pizza.setPrix(p.getPrix());
				pizza.setCategoriePizza(p.getCategoriePizza());
				entityManager.getTransaction().commit();
			}
			return null;
		});

	}

	@Override
	public void deletePizza(int id) throws PizzaException {

		execute((EntityManager entity) -> {
			Pizza pizza = entityManager.find(Pizza.class, id);

			if (entityManager != null) {
				entityManager.getTransaction().begin();
				entityManager.remove(pizza);
				entityManager.getTransaction().commit();
			}

			return null;
		});

	}

}
