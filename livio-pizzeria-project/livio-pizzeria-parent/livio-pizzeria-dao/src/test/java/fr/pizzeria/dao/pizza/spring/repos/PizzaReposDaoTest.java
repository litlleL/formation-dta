package fr.pizzeria.dao.pizza.spring.repos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.spring.config.SpringDaoJDBCConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDaoJDBCConfig.class)
public class PizzaReposDaoTest {
	@Autowired
	public @Qualifier("pizzaReposDao") PizzaDao pizzaReposDao;

	@Test
	public void testFindAll() {
		assertEquals(0, pizzaReposDao.findAll().size());
		pizzaReposDao.findAll();
	}

}
