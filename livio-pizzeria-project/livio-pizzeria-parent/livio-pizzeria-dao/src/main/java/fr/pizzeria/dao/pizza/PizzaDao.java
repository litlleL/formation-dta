package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	List<Pizza> findAll();

	void save(Pizza p);

	void updatePizza(int id, Pizza p);

	void deletePizza(int id);
}
