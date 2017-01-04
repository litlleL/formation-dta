package fr.pizzeria.console;

import java.util.ResourceBundle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.MenuAdmin;

/**
 * 
 * @author Asdrubal Livio
 *
 * @since 09/12/2016
 */
public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.imple");

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(daoImpl,
				"application-config.xml")) {
			context.getBean(MenuAdmin.class).start();
		}
	}
	// PizzaDaoFactory pizzaFactory = null;
	// try {
	// pizzaFactory = (PizzaDaoFactory) Class.forName(daoImpl).newInstance();
	// } catch (InstantiationException | IllegalAccessException |
	// ClassNotFoundException e) {
	// throw new PizzaException(e);
	// }

	// IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), pizzaFactory);
	// sMenuAdmin menu = new MenuAdmin(ihmUtil);

}
