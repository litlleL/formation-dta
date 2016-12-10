package fr.pizzeria.dao.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.dao.exception.PizzaException;
import fr.pizzeria.dao.service.PizzaDaoFactory;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Asdrubal Livio
 *
 * @see PizzaDao
 * 
 *      Date 09/12/2016
 */
public class PizzaDaoBase implements PizzaDao {
	/**
	 * 
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	interface IRunSql<T> {
		T exec(Statement st) throws SQLException;
	}

	/**
	 * 
	 *
	 * @param <T>
	 */
	@FunctionalInterface
	interface IRunSqlPrep<T> {
		T execPrep(Connection conn) throws SQLException;
	}

	/**
	 * 
	 * @param run
	 * @return
	 * @throws PizzaException
	 */
	public <T> T execute(IRunSql<T> run) throws PizzaException {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String jdbcUrl = bundle.getString("jdbc.url");
		String jdbcUser = bundle.getString("jdbc.user");
		String jdbcPass = bundle.getString("jdbc.pass");

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
				Statement statement = con.createStatement();) {

			return run.exec(statement);

		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoBase.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}

	/**
	 * 
	 * @param run
	 * @return
	 * @throws PizzaException
	 */
	public <T> T executePrep(IRunSqlPrep<T> run) throws PizzaException {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String jdbcUrl = bundle.getString("jdbc.url");
		String jdbcUser = bundle.getString("jdbc.user");
		String jdbcPass = bundle.getString("jdbc.pass");

		try (Connection con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);) {

			return run.execPrep(con);

		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoBase.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}

	@Override
	public List<Pizza> findAll() throws PizzaException {

		return execute((Statement statement) -> {
			Pizza.setNbPizzas(0);
			List<Pizza> pizzas = new ArrayList<>();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM PIZZA");
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String code = resultSet.getString("code");
				String nom = resultSet.getString("nom");
				Double prix = resultSet.getDouble("prix");
				String categorie = resultSet.getString("categoriePizza");
				pizzas.add(new Pizza(id, code, nom, prix, CategoriePizza.valueOf(categorie)));
			}
			return pizzas;
		});

	}

	@Override
	public void save(Pizza p) throws PizzaException {

		executePrep((Connection con) -> {
			PreparedStatement insertPizza = con
					.prepareStatement("INSERT INTO PIZZA(code,nom,prix,categoriePizza) VALUES(?,?,?,?)");
			insertPizza.setString(1, p.getCode());
			insertPizza.setString(2, p.getNom());
			insertPizza.setDouble(3, p.getPrix());
			insertPizza.setString(4, p.getCategoriePizza().toString());
			insertPizza.execute();
			return null;
		});

	}

	@Override
	public void updatePizza(int id, Pizza p) throws PizzaException {
		int idPizza = id;
		executePrep((Connection con) -> {
			PreparedStatement updatePizza = con
					.prepareStatement("UPDATE PIZZA SET code=?, nom=?, prix=?, categoriePizza=?  WHERE ID=?");
			updatePizza.setString(1, p.getCode());
			updatePizza.setString(2, p.getNom());
			updatePizza.setDouble(3, p.getPrix());
			updatePizza.setString(4, p.getCategoriePizza().getValue().toString());
			updatePizza.setInt(5, idPizza);

			updatePizza.executeUpdate();
			return null;
		});

	}

	@Override
	public void deletePizza(int id) throws PizzaException {
		int idPizza = id;
		executePrep((Connection connection) -> {
			PreparedStatement deletePizzaSt = connection.prepareStatement("DELETE FROM PIZZA WHERE ID = ?");
			deletePizzaSt.setInt(1, idPizza);
			deletePizzaSt.executeUpdate();
			return Void.TYPE;
		});

	}

	@Override
	public void switchData() throws PizzaException {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoSource = bundle.getString("dao.source");

		PizzaDaoFactory daoFactory;
		try {
			daoFactory = (PizzaDaoFactory) Class.forName(daoSource).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new PizzaException(e);
		}
		List<Pizza> pizzas = daoFactory.getPizzaDaoFactory().findAll();

		executePrep((Connection con) -> {
			con.setAutoCommit(false);
			ListUtils.partition(pizzas, 3).forEach(list -> {
				list.forEach(p -> {
					try {
						PreparedStatement insertPizza = con
								.prepareStatement("INSERT INTO PIZZA(code,nom,prix,categoriePizza) VALUES(?,?,?,?)");
						insertPizza.setString(1, p.getCode());
						insertPizza.setString(2, p.getNom());
						insertPizza.setDouble(3, p.getPrix());
						insertPizza.setString(4, p.getCategoriePizza().toString());
						insertPizza.executeUpdate();
					} catch (SQLException e) {
						try {
							con.rollback();
						} catch (SQLException e1) {
							throw new PizzaException(e1);
						}
						throw new PizzaException(e);
					}
				});
				try {
					con.commit();
				} catch (SQLException e) {
					throw new PizzaException(e);
				}
			});
			return null;
		});

	}

}
