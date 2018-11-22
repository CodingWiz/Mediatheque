package Objet;

import java.util.ArrayList;

public class ListePret {
	public static ArrayList<Pret> lstPretATrouver = new ArrayList<Pret>();

	public static void ajouterPret(Pret pret) {
		lstPretATrouver.add(pret);
	}

	public static void supprimerPret(Pret pret) {
		lstPretATrouver.remove(pret);
	}

	public static ArrayList<Pret> getLstPretATrouver() {
		return lstPretATrouver;
	}

	public static void setLstPretATrouver(ArrayList<Pret> lstPretATrouver) {
		ListePret.lstPretATrouver = lstPretATrouver;
	}

}
