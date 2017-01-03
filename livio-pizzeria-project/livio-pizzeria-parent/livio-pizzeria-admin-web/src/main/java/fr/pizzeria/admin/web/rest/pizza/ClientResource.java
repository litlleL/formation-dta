package fr.pizzeria.admin.web.rest.pizza;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.service.ClientService;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientResource {

	@Inject
	private ClientService clientDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> doGet() {
		return getClientDao().findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inscription(Client client) {
		getClientDao().inscription(client);
		return;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(Client client) {
		getClientDao().update(client.getId(), client);
	}

	/**
	 * @return the clientDao
	 */
	public ClientService getClientDao() {
		return clientDao;
	}

}
