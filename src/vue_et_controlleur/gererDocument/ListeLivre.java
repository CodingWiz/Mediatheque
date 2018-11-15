package vue_et_controlleur.gererDocument;

import java.util.ArrayList;

import classMediateque.Livre;

public class ListeLivre {
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
