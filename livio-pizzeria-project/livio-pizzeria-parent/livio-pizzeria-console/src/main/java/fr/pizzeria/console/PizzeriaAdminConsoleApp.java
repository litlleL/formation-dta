package fr.pizzeria.console;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.config.PizzeriaAdminConsoleAppConfig;
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

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAdminConsoleAppConfig.class)) {
			context.getBean(MenuAdmin.class).start();
		}

	}

	// ResourceBundle bundle = ResourceBundle.getBundle("application");
	// String daoImpl = bundle.getString("dao.imple");

	// try (ClassPathXmlApplicationContext context = new
	// ClassPathXmlApplicationContext(daoImpl,
	// "application-config.xml")) {
	// context.getBean(MenuAdmin.class).start();
	// }

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
