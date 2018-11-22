package vue_et_controlleur;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Objet.DVD;
import Objet.Document;
import Objet.LectureDesFichiers;
import Objet.Livre;
import Objet.Periodique;

public class FirstSerializerDocument {

	private static FirstSerializerDocument instance;
	// ArrayList<Prepose> lstPrepose =
	// LectureDesFichiers.LireFichierPrepose("Prepos�.txt");
	// ArrayList<Adherent> lstAdherent =
	// LectureDesFichiers.LireFichierAdh�rant("Adh�rent.txt");
	ArrayList<DVD> lstDVD = LectureDesFichiers.LireFichierDVD("DVD.txt");
	ArrayList<Livre> lstLivre = LectureDesFichiers.LireFichierLivres("Livres.txt");
	ArrayList<Periodique> lstPeriodique = LectureDesFichiers.LireFichierPeriodique("Periodiques.txt");

	/*
	 * public ArrayList<Prepose> getLstPrepose() { return lstPrepose; }
	 * 
	 * public void setLstPrepose(ArrayList<Prepose> lstPrepose) { this.lstPrepose =
	 * lstPrepose; }
	 * 
	 * public ArrayList<Adherent> getLstAdherent() { return lstAdherent; }
	 * 
	 * public void setLstAdherent(ArrayList<Adherent> lstAdherent) {
	 * this.lstAdherent = lstAdherent; }
	 * 
	 * public ArrayList<DVD> getLstDVD() { return lstDVD; }
	 * 
	 * public void setLstDVD(ArrayList<DVD> lstDVD) { this.lstDVD = lstDVD; }
	 * 
	 * public ArrayList<Livre> getLstLivre() { return lstLivre; }
	 * 
	 * public void setLstLivre(ArrayList<Livre> lstLivre) { this.lstLivre =
	 * lstLivre; }
	 * 
	 * public ArrayList<Periodique> getLstPeriodique() { return lstPeriodique; }
	 * 
	 * public void setLstPeriodique(ArrayList<Periodique> lstPeriodique) {
	 * this.lstPeriodique = lstPeriodique; }
	 */

	private FirstSerializerDocument() {
		// TODO Auto-generated method stub
		try {

			FileOutputStream fichierDocument = new FileOutputStream("document.ser");
			ObjectOutputStream osDoc = new ObjectOutputStream(fichierDocument);

			FileOutputStream fichierDVD = new FileOutputStream("DVD.ser");
			ObjectOutputStream osDVD = new ObjectOutputStream(fichierDVD);

			FileOutputStream fichierLivre = new FileOutputStream("livre.ser");
			ObjectOutputStream osLivre = new ObjectOutputStream(fichierLivre);

			FileOutputStream fichierPeriodique = new FileOutputStream("periodique.ser");
			ObjectOutputStream osPeriodique = new ObjectOutputStream(fichierPeriodique);

			FileOutputStream fichierAdherent = new FileOutputStream("adherant.ser");
			ObjectOutputStream osAdherent = new ObjectOutputStream(fichierAdherent);

			FileOutputStream fichierPrepose = new FileOutputStream("prepose.ser");
			ObjectOutputStream osPrepose = new ObjectOutputStream(fichierPrepose);

			/*
			 * FileOutputStream fichierPret = new FileOutputStream("pret.ser");
			 * ObjectOutputStream osPret = new ObjectOutputStream(fichierPret);
			 */

			FileOutputStream fichierPret = new FileOutputStream("pret.ser");
			ObjectOutputStream osPret = new ObjectOutputStream(fichierPret);

			/*
			 * int intNombrePret = ListePret.getLstPretATrouver().size();
			 * 
			 * for (int i = 0; i < intNombrePret; i++){ Pret pret = new
			 * Pret(ListePret.getLstPretATrouver().get(i).getNoPret(),
			 * ListePret.getLstPretATrouver().get(i).getDateDuJour(),
			 * ListePret.getLstPretATrouver().get(i).getDateRetourPreveu(),
			 * ListePret.getLstPretATrouver().get(i).getDateEffectiveRetour(),
			 * ListePret.getLstPretATrouver().get(i).getNoAdherent(),
			 * ListePret.getLstPretATrouver().get(i).getNoDoc(),ListePret.getLstPretATrouver
			 * ().get(i).getDbAmende()); osPret.writeObject(pret); }
			 * 
			 * osPret.close();
			 */

			/*
			 * int intNombrePrepose = LectureDesFichiers.intNombreDesPrepos�s;
			 * 
			 * for (int i = 0; i < intNombrePrepose; i++){ Prepose pre = new
			 * Prepose(lstPrepose.get(i).getStrNom(), lstPrepose.get(i).getStrPrenom(),
			 * lstPrepose.get(i).getStrAdresse(), lstPrepose.get(i).getStrTelephone(),
			 * lstPrepose.get(i).getStrNoPrepose(), lstPrepose.get(i).getStrPassword());
			 * 
			 * osPrepose.writeObject(pre); }
			 * 
			 * osPrepose.close();
			 */

			/*
			 * int intNombreAdherent = LectureDesFichiers.intNombreDesAdh�rents;
			 * 
			 * for (int i = 0; i < intNombreAdherent; i++){ Adherent adh = new
			 * Adherent(lstAdherent.get(i).getStrNom(), lstAdherent.get(i).getStrPrenom(),
			 * lstAdherent.get(i).getStrAdresse(), lstAdherent.get(i).getStrTelephone(),
			 * lstAdherent.get(i).getStrNoAdherent(), lstAdherent.get(i).getStrPassword());
			 * 
			 * osAdherent.writeObject(adh); }
			 * 
			 * osAdherent.close();
			 */

			int intNombreDVD = LectureDesFichiers.intNombreDesDVD;

			for (int i = 0; i < intNombreDVD; i++) {
				Document doc = new Document(lstDVD.get(i).getNoDoc(), lstDVD.get(i).getTitre(),
						lstDVD.get(i).getDateParution(), lstDVD.get(i).getEtat(), lstDVD.get(i).getMotscl�s());
				DVD dvd = new DVD(lstDVD.get(i).getNoDoc(), lstDVD.get(i).getTitre(), lstDVD.get(i).getDateParution(),
						lstDVD.get(i).getEtat(), lstDVD.get(i).getMotscl�s(), lstDVD.get(i).getNbDisque(),
						lstDVD.get(i).getRealisateur());

				osDoc.writeObject(doc);
				osDVD.writeObject(dvd);
			}

			osDVD.close();

			int intNombreLivre = LectureDesFichiers.intNombreDesLivres;

			for (int i = 0; i < intNombreLivre; i++) {
				Document doc = new Document(lstLivre.get(i).getNoDoc(), lstLivre.get(i).getTitre(),
						lstLivre.get(i).getDateParution(), lstLivre.get(i).getEtat(), lstLivre.get(i).getMotscl�s());
				Livre livre = new Livre(lstLivre.get(i).getNoDoc(), lstLivre.get(i).getTitre(),
						lstLivre.get(i).getDateParution(), lstLivre.get(i).getEtat(), lstLivre.get(i).getMotscl�s(),
						lstLivre.get(i).getAuteur());

				osDoc.writeObject(doc);
				osLivre.writeObject(livre);
			}

			osLivre.close();

			int intNombrePeriodique = LectureDesFichiers.intNombreDesPeriodiques;

			for (int i = 0; i < intNombrePeriodique; i++) {
				Document doc = new Document(lstPeriodique.get(i).getNoDoc(), lstPeriodique.get(i).getTitre(),
						lstPeriodique.get(i).getDateParution(), lstPeriodique.get(i).getEtat(),
						lstPeriodique.get(i).getMotscl�s());
				Periodique periodique = new Periodique(lstPeriodique.get(i).getNoDoc(), lstPeriodique.get(i).getTitre(),
						lstPeriodique.get(i).getDateParution(), lstPeriodique.get(i).getEtat(),
						lstPeriodique.get(i).getMotscl�s(), lstPeriodique.get(i).getNoVolume(),
						lstPeriodique.get(i).getNoPeriodique());

				osDoc.writeObject(doc);
				osPeriodique.writeObject(periodique);
			}

			osPeriodique.close();
			osDoc.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static FirstSerializerDocument getInstance() {
		if (instance == null)
			instance = new FirstSerializerDocument();
		return instance;
	}

}
