package fr.pizzeria.dao.exception;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

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

	public PizzaException(String string) {
		Logger.getLogger(PizzaException.class.getName()).info(string);
	}

}
