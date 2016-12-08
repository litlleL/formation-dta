package fr.pizzeria.dao.exception;

import java.io.IOException;
import java.sql.SQLException;

public class PizzaException extends Exception {

	public PizzaException(SQLException e) {
		e.printStackTrace();
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

}
