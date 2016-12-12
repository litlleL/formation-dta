package fr.pizzeria.dao.exception;

import java.util.logging.Logger;

public class ClientException extends RuntimeException {

	public ClientException(String string) {
		Logger.getLogger(ClientException.class.getName()).info(string);
	}

	public ClientException(Exception e) {
		Logger.getLogger(ClientException.class.getName()).info(e.getMessage());
	}

}
