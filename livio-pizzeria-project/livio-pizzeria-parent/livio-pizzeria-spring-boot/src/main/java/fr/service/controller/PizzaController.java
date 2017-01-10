package fr.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.model.Pizza;
import fr.service.repos.PizzaRepositories;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	PizzaRepositories pizzaRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		List<Pizza> listPizza = pizzaRepo.findAll();
		model.addAttribute("listPizza", listPizza);
		return "listPizza";

	}

	@RequestMapping(value = "/{pizzaId}", method = RequestMethod.GET)
	public String editIngredient(@PathVariable int pizzaId, Model model) {
		Pizza pizza = pizzaRepo.findAll().stream().filter(i -> i.getId() == pizzaId).findFirst().get();
		model.addAttribute("pizza", pizza);
		return "editPizza";
	}

}
