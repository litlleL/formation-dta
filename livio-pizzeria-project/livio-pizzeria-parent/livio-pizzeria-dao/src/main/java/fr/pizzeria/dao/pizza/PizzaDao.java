package fr.pizzeria.dao.pizza;

import java.util.List;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * 
 *         Date 09/12/2016
 */
public interface PizzaDao {
	/**
	 * 
	 * @return List<Pizza>
	 * @throws PizzaException
	 */
	List<Pizza> findAll() throws PizzaException;

	/**
	 * 
	 * @param p
	 * @throws PizzaException
	 */
	void save(Pizza p) throws PizzaException;

	/**
	 * 
	 * @param id
	 * @param p
	 * @throws PizzaException
	 */
	void updatePizza(int id, Pizza p) throws PizzaException;

	/**
	 * 
	 * @param id
	 * @throws PizzaException
	 */
	void deletePizza(int id) throws PizzaException;

	/**
	 * 
	 * @throws PizzaException
	 */
	default void switchData() throws PizzaException {
		throw new PizzaException("Pas d'implementation !!");
	}
}
