package fr.pizzeria.config;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.pizza.PizzaDaoFactory;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAdminConsoleAppConfig {

	@Bean
	public PizzaDaoFactory pizzaFactory() {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		try {
			return (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new PizzaException(e);
		}
	}

	@Bean
	public Scanner sc() {
		return new Scanner(System.in);
	}

}