package vue_et_controlleur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Objet.DVD;
import Objet.Document;
import Objet.LectureDesFichiers;
import Objet.ListeDVD;
import Objet.ListeLivre;
import Objet.ListePeriodique;
import Objet.Livre;
import Objet.Periodique;
/*import classMediateque.Pret;
import gererPret.ListePret;*/

public class Serialisation {
	
	 private static Serialisation instance;
	/* ArrayList<Prepose> lstPrepose = LectureDesFichiers.LireFichierPrepose("Preposé.txt");
	 ArrayList<Adherent> lstAdherent = LectureDesFichiers.LireFichierAdhérant("Adhérent.txt");*/
	 ArrayList<DVD> lstDVD = ListeDVD.getLstDVDATrouver();
	 ArrayList<Livre> lstLivre = ListeLivre.getLstLivreATrouver();
	 ArrayList<Periodique> lstPeriodique = ListePeriodique.getLstPeriodiqueATrouver();
	 
	 
	 
	 
	/* public ArrayList<Prepose> getLstPrepose() {
		return lstPrepose;
	}

	public void setLstPrepose(ArrayList<Prepose> lstPrepose) {
		this.lstPrepose = lstPrepose;
	}

	public ArrayList<Adherent> getLstAdherent() {
		return lstAdherent;
	}

	public void setLstAdherent(ArrayList<Adherent> lstAdherent) {
		this.lstAdherent = lstAdherent;
	}

	public ArrayList<DVD> getLstDVD() {
		return lstDVD;
	}

	public void setLstDVD(ArrayList<DVD> lstDVD) {
		this.lstDVD = lstDVD;
	}

	public ArrayList<Livre> getLstLivre() {
		return lstLivre;
	}

	public void setLstLivre(ArrayList<Livre> lstLivre) {
		this.lstLivre = lstLivre;
	}

	public ArrayList<Periodique> getLstPeriodique() {
		return lstPeriodique;
	}

	public void setLstPeriodique(ArrayList<Periodique> lstPeriodique) {
		this.lstPeriodique = lstPeriodique;
	}*/
	 
	 

	
	private Serialisation(){
		// TODO Auto-generated method stub
		try {
			
			File fileDVD = new File("DVD.ser");
			if (fileDVD.exists()) {
				fileDVD.delete();
			}
			File fileLivre = new File("livre.ser");
			if (fileLivre.exists()) {
				fileLivre.delete();
			}
			File filePer = new File("periodique.ser");
			if (filePer.exists()) {
				filePer.delete();
			}
			
			FileOutputStream fichierDocument = new FileOutputStream("document.ser");			
			ObjectOutputStream osDoc = new ObjectOutputStream(fichierDocument);
			
		
			
			FileOutputStream fichierDVD = new FileOutputStream("DVD.ser");    
			ObjectOutputStream osDVD = new ObjectOutputStream(fichierDVD);
			
			FileOutputStream fichierLivre = new FileOutputStream("livre.ser");    
			ObjectOutputStream osLivre = new ObjectOutputStream(fichierLivre);

			FileOutputStream fichierPeriodique = new FileOutputStream("periodique.ser");    
			ObjectOutputStream osPeriodique = new ObjectOutputStream(fichierPeriodique);
			
			

			
			/*FileOutputStream fichierAdherent = new FileOutputStream("adhérent.ser");    
			ObjectOutputStream osAdherent = new ObjectOutputStream(fichierAdherent);
			
			FileOutputStream fichierPrepose = new FileOutputStream("preposé.ser");    
			ObjectOutputStream osPrepose = new ObjectOutputStream(fichierPrepose);
			
			FileOutputStream fichierPret = new FileOutputStream("prêt.ser");    
			ObjectOutputStream osPret = new ObjectOutputStream(fichierPret);*/
			
			
			
			
			
			
			
			
			
			
			
			
			/*int intNombrePrepose =  LectureDesFichiers.intNombreDesPreposés;
			
			for (int i = 0; i < intNombrePrepose; i++){
				Prepose pre = new Prepose(lstPrepose.get(i).getStrNom(), lstPrepose.get(i).getStrPrenom(), lstPrepose.get(i).getStrAdresse(), lstPrepose.get(i).getStrTelephone(), lstPrepose.get(i).getStrNoPrepose(), lstPrepose.get(i).getStrPassword());
				
				osPrepose.writeObject(pre);
			}
			
			osPrepose.close();*/
			
			
			/*int intNombreAdherent =  LectureDesFichiers.intNombreDesAdhérents;
			
			for (int i = 0; i < intNombreAdherent; i++){
				Adherent adh = new Adherent(lstAdherent.get(i).getStrNom(), lstAdherent.get(i).getStrPrenom(), lstAdherent.get(i).getStrAdresse(), lstAdherent.get(i).getStrTelephone(), lstAdherent.get(i).getStrNoAdherent(), lstAdherent.get(i).getStrPassword());
				
				osAdherent.writeObject(adh);
			}
			
			osAdherent.close();*/
			
			
			
			int intNombreDVD =  lstDVD.size();
			System.out.println(intNombreDVD);
			
			for (int i = 0; i < intNombreDVD; i++){
				Document doc = new Document(lstDVD.get(i).getNoDoc(),lstDVD.get(i).getTitre(),lstDVD.get(i).getDateParution(),lstDVD.get(i).getEtat(),lstDVD.get(i).getMotsclés());
				DVD dvd = new DVD(lstDVD.get(i).getNoDoc(),lstDVD.get(i).getTitre(),lstDVD.get(i).getDateParution(),lstDVD.get(i).getEtat(),lstDVD.get(i).getMotsclés(),lstDVD.get(i).getNbDisque(),lstDVD.get(i).getRealisateur());
				
				osDoc.writeObject(doc);
				osDVD.writeObject(dvd);
			}
			
			osDVD.close();
			
			
			int intNombreLivre =  lstLivre.size();
			
			for (int i = 0; i < intNombreLivre; i++){
				Document doc = new Document(lstLivre.get(i).getNoDoc(),lstLivre.get(i).getTitre(),lstLivre.get(i).getDateParution(),lstLivre.get(i).getEtat(),lstLivre.get(i).getMotsclés());
				Livre livre = new Livre(lstLivre.get(i).getNoDoc(),lstLivre.get(i).getTitre(),lstLivre.get(i).getDateParution(),lstLivre.get(i).getEtat(),lstLivre.get(i).getMotsclés(),lstLivre.get(i).getAuteur());
				
				osDoc.writeObject(doc);
				osLivre.writeObject(livre);
			}
			
			osLivre.close();
			
			
			int intNombrePeriodique =  lstPeriodique.size();
			
			for (int i = 0; i < intNombrePeriodique; i++){
				Document doc = new Document(lstPeriodique.get(i).getNoDoc(),lstPeriodique.get(i).getTitre(),lstPeriodique.get(i).getDateParution(),lstPeriodique.get(i).getEtat(),lstPeriodique.get(i).getMotsclés());
				Periodique periodique = new Periodique(lstPeriodique.get(i).getNoDoc(),lstPeriodique.get(i).getTitre(),lstPeriodique.get(i).getDateParution(),lstPeriodique.get(i).getEtat(),lstPeriodique.get(i).getMotsclés(),lstPeriodique.get(i).getNoVolume(),lstPeriodique.get(i).getNoPeriodique());
				
				osDoc.writeObject(doc);
				osPeriodique.writeObject(periodique);
			}
			
			osPeriodique.close();
			osDoc.close();
			
		}catch (IOException e) { 
		     
		e.printStackTrace(); 
		    
		} 
	}
	
	public static Serialisation getInstance() {
		  if (instance == null) 
			  instance = new Serialisation();
		  return instance; 
	  }

}
