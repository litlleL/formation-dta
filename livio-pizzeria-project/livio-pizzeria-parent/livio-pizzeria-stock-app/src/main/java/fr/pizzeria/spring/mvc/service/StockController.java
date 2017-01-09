package fr.pizzeria.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.dao.pizza.spring.repos.ingredient.IngredientReposDao;
import fr.pizzeria.model.Ingredient;

@RestController
@RequestMapping("/ingredients")
public class StockController {

	@Autowired
	public IngredientReposDao ingredient;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> findAll() {
		return ingredient.findAll();
	}

}
