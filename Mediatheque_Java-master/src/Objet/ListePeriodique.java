package Objet;


import java.io.Serializable;
import java.util.ArrayList;


public class ListePeriodique implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<Periodique>lstPeriodiqueATrouver = new ArrayList<Periodique>();
	
	public static void ajouterPeriodique(Periodique periodique){
		lstPeriodiqueATrouver.add(periodique);
	}
	
	public static void supprimerPeriodique(Periodique periodique){
		lstPeriodiqueATrouver.remove(periodique);
	}

	public static ArrayList<Periodique> getLstPeriodiqueATrouver() {
		return lstPeriodiqueATrouver;
	}

	public static void setLstPeriodiqueATrouver(ArrayList<Periodique> lstPeriodiqueATrouver) {
		ListePeriodique.lstPeriodiqueATrouver = lstPeriodiqueATrouver;
	}
	
	

	
}
