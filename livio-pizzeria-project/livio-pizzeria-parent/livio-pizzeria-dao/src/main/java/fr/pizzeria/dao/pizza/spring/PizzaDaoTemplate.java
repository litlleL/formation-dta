// package fr.pizzeria.dao.pizza.spring;
//
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.List;
//
// import javax.annotation.PostConstruct;
// import javax.sql.DataSource;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
// import org.springframework.stereotype.Repository;
//
// import fr.pizzeria.dao.pizza.PizzaDao;
// import fr.pizzeria.model.Pizza;
//
// @Repository
// public class PizzaDaoTemplate implements PizzaDao {
//
// private JdbcTemplate jdbcTemplate;
//
// @Autowired
// public DataSource dataSource;
//
// @PostConstruct
// public void init() {
// this.jdbcTemplate = new JdbcTemplate(dataSource);
// }
//
// @Override
// public List<Pizza> findAll() {
// String sql = "SELECT * FROM pizza ";
// return this.jdbcTemplate.query(sql, new PizzaMapper());
// }
//
// @Override
// public void save(Pizza p) {
// String sql = "INSERT INTO pizza (code,nom,prix,categoriePizza)
// VALUES(?,?,?,?)";
// this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(),
// p.getCategoriePizza());
// }
//
// @Override
// public void updatePizza(int id, Pizza p) {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void deletePizza(int id) {
// // TODO Auto-generated method stub
//
// }
//
// public class PizzaMapper implements RowMapper<Pizza> {
//
// public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
// Pizza p = new Pizza();
//
// System.out.println(p);
// p.setId(rs.getInt("id"));
// p.setCode(rs.getString("code"));
// p.setNom(rs.getString("nom"));
// p.setPrix(Double.parseDouble(rs.getString("prix")));
// return p;
// }
//
// }
//
// }