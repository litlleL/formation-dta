package fr.pizzeria.dao.exception;

import java.util.logging.Logger;

public class CommandeException extends RuntimeException {

	public CommandeException(String string) {
		Logger.getLogger(CommandeException.class.getName()).info(string);
	}

}
