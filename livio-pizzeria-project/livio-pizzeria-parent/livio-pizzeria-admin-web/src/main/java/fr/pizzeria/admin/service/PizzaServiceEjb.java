package fr.pizzeria.admin.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEjb {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Pizza> findAll() throws PizzaException {
		TypedQuery<Pizza> pizzaQuery = getEntityManager().createQuery("select p from Pizza p where p.archiver='false'",
				Pizza.class);
		return pizzaQuery.getResultList();
	}

	public void save(Pizza p) throws PizzaException {
		getEntityManager().persist(p);
	}

	public void updatePizza(int id, Pizza p) throws PizzaException {
		Pizza pizza = getEntityManager().find(Pizza.class, id);
		pizza.setCode(p.getCode());
		pizza.setNom(p.getNom());
		pizza.setPrix(p.getPrix());
		pizza.setCategoriePizza(p.getCategoriePizza());
	}

	public void deletePizza(int id) throws PizzaException {
		Pizza pizza = getEntityManager().find(Pizza.class, id);

		if (getEntityManager() != null) {
			pizza.setArchiver(true);
		}

	}

	public Pizza findPizza(int id) throws PizzaException {
		return getEntityManager().find(Pizza.class, id);
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
