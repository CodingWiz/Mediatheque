package Objet;

import java.util.ArrayList;

public class ListePrepose {
	public static ArrayList<Prepose>lstPreposeATrouver = new ArrayList<Prepose>();
	
	
	
	public static void ajouterPrepose(Prepose prepose){
		lstPreposeATrouver.add(prepose);
	}
	
	
	public static void supprimerPrepose(Prepose prepose){
		lstPreposeATrouver.remove(prepose);
	}


	public static ArrayList<Prepose> getLstPreposeATrouver() {
		return lstPreposeATrouver;
	}


	public static void setLstPreposeATrouver(ArrayList<Prepose> lstPreposeATrouver) {
		ListePrepose.lstPreposeATrouver = lstPreposeATrouver;
	}
	
	
	
}

