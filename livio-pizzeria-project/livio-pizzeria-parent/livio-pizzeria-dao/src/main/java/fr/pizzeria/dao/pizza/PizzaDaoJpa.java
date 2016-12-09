package fr.pizzeria.dao.pizza;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements PizzaDao {

	private EntityManagerFactory entityManagerFactory;

	public PizzaDaoJpa() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
	}

	@Override
	public List<Pizza> findAll() throws PizzaException {
		entityManagerFactory = Persistence.createEntityManagerFactory("livio-pizzeria-console");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		TypedQuery<Pizza> pizzaQuery = entityManager.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> pizzas = pizzaQuery.getResultList();

		entityManager.close();
		entityManagerFactory.close();
		return pizzas;
	}

	@Override
	public void save(Pizza p) throws PizzaException {
		entityManagerFactory = Persistence.createEntityManagerFactory("livio-pizzeria-console");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(p);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {
		entityManagerFactory = Persistence.createEntityManagerFactory("livio-pizzeria-console");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Pizza pizza = entityManager.find(Pizza.class, id);
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			pizza.setCode(p.getCode());
			pizza.setNom(p.getNom());
			pizza.setPrix(p.getPrix());
			pizza.setCategoriePizza(p.getCategoriePizza());
			entityManager.getTransaction().commit();
		}

		entityManager.close();
		entityManagerFactory.close();
	}

	@Override
	public void deletePizza(int id) throws PizzaException {
		entityManagerFactory = Persistence.createEntityManagerFactory("livio-pizzeria-console");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Pizza pizza = entityManager.find(Pizza.class, id);

		if (entityManager != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(pizza);
			entityManager.getTransaction().commit();
		}

		entityManager.close();
		entityManagerFactory.close();
	}

}
