package Objet;

import java.util.ArrayList;

public class ListeAdherant {
	public static ArrayList<Adherent> lstAdherantATrouver = new ArrayList<Adherent>();

	public static void ajouterAdherant(Adherent adherant) {
		lstAdherantATrouver.add(adherant);
	}

	public static void supprimerAdherant(Adherent adherant) {
		lstAdherantATrouver.remove(adherant);
	}

	public static ArrayList<Adherent> getLstAdherantATrouver() {
		return lstAdherantATrouver;
	}

	public static void setLstAdherantATrouver(ArrayList<Adherent> lstAdherantATrouver) {
		ListeAdherant.lstAdherantATrouver = lstAdherantATrouver;
	}

}
