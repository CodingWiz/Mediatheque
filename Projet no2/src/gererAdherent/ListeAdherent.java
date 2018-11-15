package gererAdherent;

import java.util.ArrayList;

import classMediateque.Adherent;

public class ListeAdherent {
	public static ArrayList<Adherent>lstAdherentATrouver = new ArrayList<Adherent>();
	
	
	public static void ajouterAdherent(Adherent adherent){
		lstAdherentATrouver.add(adherent);
	}
	
	public static void supprimerAdherent(Adherent adherent){
		lstAdherentATrouver.remove(adherent);
	}

	public static ArrayList<Adherent> getLstAdherentATrouver() {
		return lstAdherentATrouver;
	}

	public static void setLstAdherentATrouver(ArrayList<Adherent> lstAdherentATrouver) {
		ListeAdherent.lstAdherentATrouver = lstAdherentATrouver;
	}
	
	
	
}
