package Objet;


import java.io.Serializable;
import java.util.ArrayList;


public class ListeLivre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<Livre>lstLivreATrouver = new ArrayList<Livre>();
	
	public static void ajouterLivre(Livre livre){
		lstLivreATrouver.add(livre);
	}
	
	public static void supprimerLivre(Livre livre){
		lstLivreATrouver.remove(livre);
	}

	public static ArrayList<Livre> getLstLivreATrouver() {
		return lstLivreATrouver;
	}

	public static void setLstLivreATrouver(ArrayList<Livre> lstLivreATrouver) {
		ListeLivre.lstLivreATrouver = lstLivreATrouver;
	}

	
}
