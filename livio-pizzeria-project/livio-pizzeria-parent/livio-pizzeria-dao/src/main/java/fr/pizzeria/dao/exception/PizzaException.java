package fr.pizzeria.dao.exception;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 
 * @author Asdrubal Livio
 *
 * 
 * @since 09/12/2016
 */
public class PizzaException extends RuntimeException {

	public PizzaException(SQLException e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(IOException e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(ClassNotFoundException e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(InstantiationException e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(IllegalAccessException e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(ReflectiveOperationException e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(Exception e) {
		Logger.getLogger(PizzaException.class.getName()).info(e.getMessage());
	}

	public PizzaException(String string) {
		Logger.getLogger(PizzaException.class.getName()).info(string);
	}

}
