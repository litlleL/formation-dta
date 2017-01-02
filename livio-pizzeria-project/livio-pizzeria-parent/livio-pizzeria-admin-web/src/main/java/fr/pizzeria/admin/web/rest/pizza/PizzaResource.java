package fr.pizzeria.admin.web.rest.pizza;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.service.PizzaService;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {

	@Inject
	private PizzaService pizzaDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> doGet() {
		return getPizzaDao().findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void doPost() {
		Pizza p = new Pizza("MAR", "Margherita", 12.50, CategoriePizza.VIANDE);
		getPizzaDao().save(p);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void doPut() {
		Pizza pizza = getPizzaDao().findPizza(2);
		pizza.setCode("MAR");
		getPizzaDao().updatePizza(2, pizza);
	}

	@DELETE
	@Path("/{id}")
	public void doDelete(@PathParam("id") Integer id) {
		getPizzaDao().deletePizza(id);
	}

	public PizzaService getPizzaDao() {
		return pizzaDao;
	}

}
