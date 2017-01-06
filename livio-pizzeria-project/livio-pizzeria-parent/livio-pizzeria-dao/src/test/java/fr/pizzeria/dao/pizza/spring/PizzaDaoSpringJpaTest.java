package fr.pizzeria.dao.pizza.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.spring.config.SpringDaoJDBCConfig;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDaoJDBCConfig.class)
public class PizzaDaoSpringJpaTest {

	@Autowired
	public @Qualifier("pizzaDaoSpringJpa") PizzaDao pizzaDaoSpringJpa;

	@Test
	public void testFindAll() {
		// assertEquals(null, pizzaDaoSpringJpa);
		pizzaDaoSpringJpa.findAll().forEach(System.out::println);
	}

	@Test
	public void testSave() {
		Pizza p = new Pizza("MAR", "mzargherita", 12.50, CategoriePizza.VIANDE);
		pizzaDaoSpringJpa.save(p);
		pizzaDaoSpringJpa.findAll().forEach(System.out::println);
	}

}
