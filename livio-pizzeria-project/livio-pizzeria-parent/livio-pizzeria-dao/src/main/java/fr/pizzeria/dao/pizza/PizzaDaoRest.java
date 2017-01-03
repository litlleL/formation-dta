package fr.pizzeria.dao.pizza;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @see PizzaDao
 * @since 02/01/2017
 *
 */
public class PizzaDaoRest implements PizzaDao {

	@Override
	public List<Pizza> findAll() throws PizzaException {

		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI()).path("pizzas");
		Builder requestBuilder = target.request().accept(MediaType.APPLICATION_JSON);
		Response response = requestBuilder.get();
		return response.readEntity(new GenericType<List<Pizza>>() {
		});
	}

	@Override
	public void save(Pizza p) throws PizzaException {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI()).path("pizzas");
		Builder requestBuilder = target.request().accept(MediaType.APPLICATION_JSON);
		requestBuilder.post(Entity.json(p));
	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {
		ClientConfig config = new ClientConfig();
		config.register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target(getBaseURI()).path("pizzas");
		Builder requestBuilder = target.request().accept(MediaType.APPLICATION_JSON);
		requestBuilder.put(Entity.json(p));
	}

	@Override
	public void deletePizza(int id) throws PizzaException {

	}

	private URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/livio-pizzeria-admin-web/api/rest/").build();
	}

}
