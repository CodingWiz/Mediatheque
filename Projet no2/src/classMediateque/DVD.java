package classMediateque;

public class DVD extends Document{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String nbDisque;
	private final String realisateur;


	public DVD(String noDoc, String titre, String dateParution, String etat, String motsclés, String nbDisque,	String réalisateur) {
		super(noDoc, titre, dateParution, etat, motsclés);
		this.nbDisque = nbDisque;
		this.realisateur = réalisateur;
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