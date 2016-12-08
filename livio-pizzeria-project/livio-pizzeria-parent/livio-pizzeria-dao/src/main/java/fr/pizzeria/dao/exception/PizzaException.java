package fr.pizzeria.dao.exception;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PizzaException extends Exception {

	public PizzaException(SQLException e) {
		e.printStackTrace();
		Logger.getLogger(PizzaException.class.getName()).log(null, e.getMessage());
	}

	public PizzaException(IOException e) {
		e.printStackTrace();
	}

	public PizzaException(ClassNotFoundException e) {
		e.printStackTrace();
	}

	public PizzaException(InstantiationException e) {
		e.printStackTrace();
	}

	public PizzaException(IllegalAccessException e) {
		e.printStackTrace();
	}

	public PizzaException(ReflectiveOperationException e) {
		e.printStackTrace();
	}

}
