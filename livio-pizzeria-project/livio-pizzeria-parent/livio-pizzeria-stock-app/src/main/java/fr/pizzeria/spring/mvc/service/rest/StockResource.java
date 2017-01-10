package fr.pizzeria.spring.mvc.service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.repos.ingredient.IngredientReposDao;
import fr.pizzeria.model.Ingredient;

@Controller
public class StockResource {

	@Autowired
	public IngredientReposDao ingredients;

	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> findAll() {
		return ingredients.findAll();
	}

	@RequestMapping(value = "/rest/ingredients", method = RequestMethod.POST)
	public void ajouterIngredients(@ModelAttribute("ingredient") Ingredient ingredient) {
		ingredients.save(ingredient);
	}

	@RequestMapping(value = "/rest/ingredients/{ingredientId}", method = RequestMethod.GET)
	@ResponseBody
	public Ingredient findIngredient(@PathVariable int ingredientId) {
		return ingredients.findAll().stream().filter(i -> i.getId() == ingredientId).findFirst().get();
	}

	@RequestMapping(value = "/ingredients/{ingredientId}", method = RequestMethod.POST)
	@ResponseBody
	public void updateIngredient(@PathVariable int ingredientId, @ModelAttribute("ingredient") Ingredient ingred) {
		ingredients.update(ingred, ingredientId);
	}
}
