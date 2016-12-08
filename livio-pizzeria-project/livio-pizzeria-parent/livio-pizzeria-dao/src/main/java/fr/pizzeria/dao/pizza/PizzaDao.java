package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAll() throws PizzaException;

	void save(Pizza p) throws PizzaException;

	void updatePizza(int id, Pizza p) throws PizzaException;

	void deletePizza(int id) throws PizzaException;
}
