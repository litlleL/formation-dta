package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * @see PizzaDao
 * 
 * @since 09/12/2016
 */
public class PizzaDaoTableau implements PizzaDao {

	private List<Pizza> pizza = new ArrayList<>();

	public PizzaDaoTableau() {
		pizza.add(new Pizza("MAR", "margherita", 12.50, CategoriePizza.VIANDE));
		pizza.add(new Pizza("PEP", "peperoni", 123.50, CategoriePizza.POISSON));
		pizza.add(new Pizza("REI", "reine", 17.50, CategoriePizza.SANS_VIANDE));
	}

	@Override
	public List<Pizza> findAll() {
		return pizza;
	}

	@Override
	public void save(Pizza p) {
		pizza.add(p);
	}

	@Override
	public void updatePizza(int id, Pizza p) {
		int idPizza = id;
		pizza.get(idPizza).setCode(p.getCode());
		pizza.get(idPizza).setNom(p.getNom());
		pizza.get(idPizza).setPrix(p.getPrix());
		pizza.get(idPizza).setCategoriePizza(p.getCategoriePizza());
	}

	@Override
	public void deletePizza(int id) {

		int idPizza = id;

		Pizza.setNbPizzas(Pizza.getNbPizzas() - 1);
		pizza.remove(idPizza);
	}

}