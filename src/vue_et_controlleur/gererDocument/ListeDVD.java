package vue_et_controlleur.gererDocument;

import java.util.ArrayList;

import classMediateque.DVD;

public class ListeDVD {
	public static ArrayList<DVD>lstDVDATrouver = new ArrayList<DVD>();
	
	
	public static void ajouterDVD(DVD dvd){
		lstDVDATrouver.add(dvd);
	}
	
	
	




	public static ArrayList<DVD> getLstDVDATrouver() {
		return lstDVDATrouver;
	}







	public static void setLstDVDATrouver(ArrayList<DVD> lstDVDATrouver) {
		ListeDVD.lstDVDATrouver = lstDVDATrouver;
	}







	public static void supprimerDVD(DVD dvd){
		lstDVDATrouver.remove(dvd);
	}
}
