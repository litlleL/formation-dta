package fr.pizzeria.client.action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.pizzeria.client.ihm.IhmUtil;
import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.dao.exception.PizzaException;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */
public class Connection extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Connection(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Connexion");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() throws PizzaException {
		Logger.getLogger(Connection.class.getName()).info("---------- Connexion ----------- \n");

		String email;
		do {
			Logger.getLogger(Inscription.class.getName()).info("Mail: \n");
			email = this.ihmUtil.getScanner().next();
		} while (!isValidEmailAddress(email));

		Logger.getLogger(Connection.class.getName()).info("Mot de passe: \n");
		String motDePasse = this.ihmUtil.getScanner().next();

		byte[] md5sum;
		try {
			md5sum = MessageDigest.getInstance("SHA1").digest(motDePasse.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new ClientException(e);
		}

		String motDePasseHash = String.format("%032X", new BigInteger(1, md5sum));

		if (this.ihmUtil.getClientDao().connection(email, motDePasseHash)) {
			Logger.getLogger(Connection.class.getName()).info("---------- Bienvenue ----------- \n");
		} else {
			Logger.getLogger(Connection.class.getName())
					.info("---------- Erreur dans le mail ou le mot de passe ----------- \n");
		}
	}

	@Override
	public void show() {
		Logger.getLogger(Connection.class.getName()).info(getLibelle());
	}

	public boolean isValidEmailAddress(String email) {
		String regexPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]*(.[a-zA-Z]{2,})*";
		Pattern p = Pattern.compile(regexPattern);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

}
