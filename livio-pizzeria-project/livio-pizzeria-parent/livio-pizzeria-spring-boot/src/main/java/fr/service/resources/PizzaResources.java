package fr.service.resources;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.service.repos.PizzaRepositories;

@Controller
@RequestMapping("/spring/pizzas")
public class PizzaResources {

	@Autowired
	PizzaRepositories pizzaRepo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Pizza> findAll() {
		return pizzaRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void save(@RequestBody Pizza pizza) {
		pizzaRepo.save(pizza);
	}

	@RequestMapping(value = "/{pizzaId}", method = RequestMethod.PUT)
	@ResponseBody
	public void updatePizza(@PathVariable int pizzaId, @RequestBody Pizza pizza) {
		Pizza newPizza = pizzaRepo.findAll().stream().filter(pizzas -> pizzas.getId() == pizzaId).findFirst().get();
		newPizza.setCode(pizza.getCode());
		newPizza.setNom(pizza.getNom());
		newPizza.setPrix(pizza.getPrix());
		newPizza.setCategoriePizza(pizza.getCategoriePizza());
		newPizza.setUrlImage(pizza.getUrlImage());
		pizzaRepo.save(newPizza);

	}

	@RequestMapping(value = "/{pizzaId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePizza(@PathVariable int pizzaId) {
		Pizza newPizza = pizzaRepo.findAll().stream().filter(pizzas -> pizzas.getId() == pizzaId).findFirst().get();
		newPizza.setArchiver(true);
		pizzaRepo.save(newPizza);
	}

	@PostConstruct
	public void init() {
		List<Pizza> listPizza = new ArrayList<>();

		listPizza.add(new Pizza("MAR", "margherita", 12.50, CategoriePizza.VIANDE));
		listPizza.add(new Pizza("PEP", "peperoni", 14.50, CategoriePizza.SANS_VIANDE));
		listPizza.add(new Pizza("REI", "reine", 15.50, CategoriePizza.POISSON));

		listPizza.forEach(pizza -> pizzaRepo.save(pizza));
	}

}
