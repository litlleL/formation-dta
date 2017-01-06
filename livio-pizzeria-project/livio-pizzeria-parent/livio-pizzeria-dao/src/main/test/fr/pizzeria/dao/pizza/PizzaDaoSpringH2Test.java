// package fr.pizzeria.dao.pizza;
//
// import static org.junit.Assert.assertEquals;
//
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import fr.pizzeria.dao.pizza.spring.PizzaDaoTemplate;
// import fr.pizzeria.dao.pizza.spring.SpringJDBCConfig;
//
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = SpringJDBCConfig.class)
// public class PizzaDaoSpringH2Test {
//
// @Autowired
// PizzaDaoTemplate pizzaDaoSpringH2;
//
// @Test
// public void test() {
// assertEquals(2, pizzaDaoSpringH2.findAll().size());
// pizzaDaoSpringH2.findAll().forEach(p -> System.out.println(p.getCode() + " "
// + p.getNom() + " " + p.getPrix()));
// }
//
// }