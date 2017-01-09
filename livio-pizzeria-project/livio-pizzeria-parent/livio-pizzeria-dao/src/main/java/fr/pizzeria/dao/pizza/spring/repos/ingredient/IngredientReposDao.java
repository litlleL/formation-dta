package fr.pizzeria.dao.pizza.spring.repos.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Ingredient;

@Repository
public class IngredientReposDao {

	@Autowired
	IngredientRepositories ingredientRepo;

	public List<Ingredient> findAll() {
		return ingredientRepo.findAll();
	}

	public void save(Ingredient ingredient) {
		ingredientRepo.save(ingredient);
	}

	public void update(Ingredient ingredient) {
		ingredientRepo.save(ingredient);
	}

	public void delete(Ingredient ingredient) {
		ingredientRepo.delete(ingredient);
	}

}
