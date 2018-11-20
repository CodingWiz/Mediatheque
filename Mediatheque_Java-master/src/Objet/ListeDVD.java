package Objet;


import java.io.Serializable;
import java.util.ArrayList;


public class ListeDVD implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	
	/*public static void supprimerDVD(Document dvd){
		lstDVDATrouver.remove(dvd);
	}*/
}
