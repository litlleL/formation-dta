package fr.pizzeria.dao.exception;

import java.util.logging.Logger;

public class LivreurException extends RuntimeException {

	public LivreurException(String string) {
		Logger.getLogger(LivreurException.class.getName()).info(string);
	}

}
