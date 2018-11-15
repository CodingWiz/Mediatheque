package vue_et_controlleur.classMediateque;

public class Livre extends Document{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String auteur;

	public Livre(String noDoc, String titre, String dateParution, String etat, String motscl�s, String auteur) {
		super(noDoc, titre, dateParution, etat, motscl�s);
		this.auteur = auteur;
	}

	public String getAuteur() {
		return auteur;
	} 

}
