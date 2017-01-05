package fr.pizzeria.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.action.config.SpringTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations = "application.xml")
@ContextConfiguration(classes = SpringTestConfig.class)
public class ListPizzaTest {

	@Autowired
	private List listPizza;

	@Test
	public void test() {
		// assertEquals("Lister les pizzas", listPizza.show());
	}

}
