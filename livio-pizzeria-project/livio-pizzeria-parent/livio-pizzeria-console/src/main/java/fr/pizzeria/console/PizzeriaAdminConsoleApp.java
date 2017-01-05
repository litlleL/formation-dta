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

}
