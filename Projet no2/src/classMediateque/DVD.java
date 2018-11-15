package classMediateque;

public class DVD extends Document{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String nbDisque;
	private final String realisateur;


	public DVD(String noDoc, String titre, String dateParution, String etat, String motscl�s, String nbDisque,	String r�alisateur) {
		super(noDoc, titre, dateParution, etat, motscl�s);
		this.nbDisque = nbDisque;
		this.realisateur = r�alisateur;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getNbDisque() {
		return nbDisque;
	}


	public String getRealisateur() {
		return realisateur;
	}

	

	
	
}