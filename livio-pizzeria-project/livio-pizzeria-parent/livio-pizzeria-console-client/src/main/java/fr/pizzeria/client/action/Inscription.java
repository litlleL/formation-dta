package fr.pizzeria.client.action;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.pizzeria.client.ihm.IhmUtil;
import fr.pizzeria.dao.exception.ClientException;
import fr.pizzeria.dao.exception.PizzaException;
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
	public void executeAction() throws PizzaException {
		Logger.getLogger(Inscription.class.getName()).info("Entrez votre nom: \n");
		String nom = this.ihmUtil.getScanner().next();

		Logger.getLogger(Inscription.class.getName()).info("Entrez votre prenom: \n");
		String prenom = this.ihmUtil.getScanner().next();

		Logger.getLogger(Inscription.class.getName()).info("Entrez votre adresse: \n");
		String adresse = this.ihmUtil.getScanner().next();

		String email = null;
		do {
			Logger.getLogger(Inscription.class.getName()).info("Entrez votre email: \n");
			email = this.ihmUtil.getScanner().next();
		} while (!isValidEmailAddress(email));

		Logger.getLogger(Inscription.class.getName()).info("Entrez votre mot de passe: \n");
		String motDePasse = this.ihmUtil.getScanner().next();
		try {
			MessageDigest mdp = MessageDigest.getInstance("MD5", motDePasse);
		} catch (NoSuchAlgorithmException e) {
			throw new ClientException(e);
		} catch (NoSuchProviderException e) {
			throw new ClientException(e);
		}
		this.getIhmUtil().getClientDao().inscription(new Client(nom, prenom, adresse, email, motDePasse));

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
