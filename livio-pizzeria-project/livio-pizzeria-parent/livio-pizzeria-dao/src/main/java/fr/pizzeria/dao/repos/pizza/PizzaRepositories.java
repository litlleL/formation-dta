package fr.pizzeria.dao.repos.pizza;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface PizzaRepositories extends JpaRepository<Pizza, Integer> {

}
