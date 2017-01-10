package fr.pizzeria.dao.repos.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Ingredient;

public interface IngredientRepositories extends JpaRepository<Ingredient, Integer> {

}
