package fr.pizzeria.spring.mvc.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.dao.pizza.spring.repos.ingredient.IngredientReposDao;
import fr.pizzeria.model.Ingredient;

@Controller
public class IngredientController {

	@Autowired
	private IngredientReposDao ingredients;

	@RequestMapping(value = "/ingredients", method = RequestMethod.GET)
	public String listIngredient() {
		return "list";
	}

	@RequestMapping(value = "/ingredients/{ingredientId}", method = RequestMethod.GET)
	public String editIngredient(@PathVariable int ingredientId, Model model) {
		Ingredient ingredient = getIngredient().findAll().stream().filter(i -> i.getId() == ingredientId).findFirst()
				.get();
		model.addAttribute("ingredient", ingredient);
		return "edit";
	}

	public IngredientReposDao getIngredient() {
		return ingredients;
	}

	public void setIngredient(IngredientReposDao ingredient) {
		this.ingredients = ingredient;
	}
}
