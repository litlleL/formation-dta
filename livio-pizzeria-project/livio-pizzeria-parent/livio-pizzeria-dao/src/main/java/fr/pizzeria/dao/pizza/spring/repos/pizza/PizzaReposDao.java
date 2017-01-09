package fr.pizzeria.dao.pizza.spring.repos.pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaReposDao implements PizzaDao {

	@Autowired
	PizzaRepositories pizzaRepo;

	@Override
	public List<Pizza> findAll() throws PizzaException {
		return pizzaRepo.findAll();
	}

	@Override
	public void save(Pizza p) throws PizzaException {
		pizzaRepo.save(p);
	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {

	}

	@Override
	public void deletePizza(int id) throws PizzaException {

	}

}
