package fr.pizzeria.dao.pizza.spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface PizzaRepositories extends JpaRepository<Pizza, Integer> {

}
