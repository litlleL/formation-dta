package fr.pizzeria.dao.pizza.spring.repos;

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
public class PizzaReposDaoTest {
	@Autowired
	public @Qualifier("pizzaReposDao") PizzaDao pizzaReposDao;

	@Test
	public void testFindAll() {
		pizzaReposDao.findAll();
	}

	@Test
	public void testSave() {
		Pizza p = new Pizza("MAR", "mzargherita", 12.50, CategoriePizza.VIANDE);
		pizzaReposDao.save(p);
		pizzaReposDao.findAll().forEach(System.out::println);
	}

}
