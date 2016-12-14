package fr.pizzeria.client.action;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.pizzeria.client.ihm.IhmUtil;
import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.model.Client;

/**
 * 
 * @author Asdrubal Livio
 * 
 * @since 12/12/2016
 *
 */
public class Inscription extends MenuInterface {
	private IhmUtil ihmUtil;

	/**
	 * 
	 * @param ihmUtil
	 */
	public Inscription(IhmUtil ihmUtil) {
		super();
		this.setLibelle("Inscription");
		this.setIhmUtil(ihmUtil);
	}

	@Override
	public void executeAction() throws ClientException {

		Logger.getLogger(Inscription.class.getName()).info("---------- Inscription ---------- \n");
		Logger.getLogger(Inscription.class.getName()).info("Entrez votre nom: \n");
		String nom = this.ihmUtil.getScanner().next();

		Logger.getLogger(Inscription.class.getName()).info("Entrez votre prenom: \n");
		String prenom = this.ihmUtil.getScanner().next();

		Logger.getLogger(Inscription.class.getName()).info("Entrez votre adresse: \n");
		String adresse = this.ihmUtil.getScanner().next();

		String email;
		do {
			Logger.getLogger(Inscription.class.getName()).info("Entrez votre email: \n");
			email = this.ihmUtil.getScanner().next();
		} while (!isValidEmailAddress(email));

		Logger.getLogger(Inscription.class.getName()).info("Entrez votre mot de passe: \n");
		String motDePasse = this.ihmUtil.getScanner().next();

		byte[] md5sum;
		try {
			md5sum = MessageDigest.getInstance("SHA1").digest(motDePasse.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new ClientException(e);
		}

		String motDePasseHash = String.format("%032X", new BigInteger(1, md5sum));

		this.getIhmUtil().getClientDao().inscription(new Client(nom, prenom, adresse, email, motDePasseHash));
	}

	@Override
	public void show() {
		Logger.getLogger(Inscription.class.getName()).info(getLibelle());
	}

	public IhmUtil getIhmUtil() {
		return ihmUtil;
	}

	public void setIhmUtil(IhmUtil ihmUtil) {
		this.ihmUtil = ihmUtil;
	}

	public boolean isValidEmailAddress(String email) {
		String regexPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]*(.[a-zA-Z]{2,})*";
		Pattern p = Pattern.compile(regexPattern);
		Matcher m = p.matcher(email);
		return m.matches();
	}
}
