package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDao {
	Path pathRep = FileSystems.getDefault()
			.getPath(System.getProperty("user.dir") + "/livio-pizzeria-dao/src/main/resources/fichierDao");

	@Override
	public void save(Pizza p) throws PizzaException {
		Path pathFichier = FileSystems.getDefault().getPath(pathRep + "/" + p.getCode() + ".txt");

		try {
			Files.createFile(pathFichier);
			Charset charset = Charset.forName("UTF-8");
			List<String> lines = new ArrayList<>();
			lines.add(p.getCode() + "," + p.getNom() + "," + p.getPrix() + "," + p.getCategoriePizza());
			Files.write(pathFichier, lines, charset, StandardOpenOption.APPEND);
		} catch (IOException e) {
			Logger.getLogger(PizzaDaoFichier.class.getName()).info(e.getMessage());
			throw new PizzaException(e);
		}
	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {
		int idPizza = id - 1;
		String code = findAll().get(idPizza).getCode();
		Logger.getLogger(PizzaDaoFichier.class.getName()).info(code);
	}

	@Override
	public void deletePizza(int id) throws PizzaException {

		int idPizza = id - 1;
		String code = findAll().get(idPizza).getCode();
		Logger.getLogger(PizzaDaoFichier.class.getName()).info(code);

	}

	@Override
	public List<Pizza> findAll() throws PizzaException {
		Pizza.setNbPizzas(0);
		List<Pizza> pizzas = new ArrayList<>();
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(pathRep);) {

			Charset charset = Charset.forName("UTF-8");

			directoryStream.forEach(directory -> {
				try {

					List<String> pizza = Files.readAllLines(directory, charset);
					String str = pizza.get(0);
					String[] parts = str.split(",");
					pizzas.add(new Pizza(parts[0], parts[1], Double.parseDouble(parts[2]),
							CategoriePizza.valueOf(parts[3])));

				} catch (IOException e) {
					Logger.getLogger(PizzaDaoFichier.class.getName()).info(e.getMessage());
					throw new PizzaException(e);
				}
			});
		} catch (IOException e) {
			Logger.getLogger(PizzaDaoFichier.class.getName()).info(e.getMessage());
			throw new PizzaException(e);
		}

		return pizzas;

	}

}
