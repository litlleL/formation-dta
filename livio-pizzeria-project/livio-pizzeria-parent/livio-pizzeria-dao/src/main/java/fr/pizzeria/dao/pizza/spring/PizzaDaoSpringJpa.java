package fr.pizzeria.dao.pizza.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoSpringJpa implements PizzaDao {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public List<Pizza> findAll() throws PizzaException {
		TypedQuery<Pizza> pizzaQuery = getEntityManager().createQuery("select p from Pizza p ", Pizza.class);
		return pizzaQuery.getResultList();
	}

	@Override
	@Transactional
	public void save(Pizza p) throws PizzaException {
		getEntityManager().persist(p);

	}

	@Override
	@Transactional
	public void updatePizza(int id, Pizza p) throws PizzaException {
		Pizza pizza = getEntityManager().find(Pizza.class, id);
		pizza.setCode(p.getCode());
		pizza.setNom(p.getNom());
		pizza.setPrix(p.getPrix());
		pizza.setCategoriePizza(p.getCategoriePizza());
	}

	@Override
	@Transactional
	public void deletePizza(int id) throws PizzaException {
		Pizza pizza = getEntityManager().find(Pizza.class, id);

		if (getEntityManager() != null) {
			pizza.setArchiver(true);
		}

	}

	public void quitApp() throws PizzaException {
		entityManager.close();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
