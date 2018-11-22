package Objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LectureDesFichiers {
	public static int intNombreDesDocuments = 0;
	public static int intNombreDesDVD = 0;
	public static int intNombreDesLivres = 0;
	public static int intNombreDesPeriodiques = 0;

	public static ArrayList<DVD> LireFichierDVD(String strNomFichier) {

		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erreur, aucun fichier trouver avec ce nom : " + e.toString());
		}
		String strLigne;
		StringTokenizer st;
		int index = 0;
		try {
			while ((strLigne = brFichier.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				ListeDVD.getLstDVDATrouver().add(new DVD(st.nextToken().trim(), st.nextToken().trim(),
						st.nextToken().trim(), "Disponible", "", st.nextToken().trim(), st.nextToken().trim()));
				ListDocument.getLstAllDocument()
						.add(new Document(ListeDVD.getLstDVDATrouver().get(index).getNoDoc(),
								ListeDVD.getLstDVDATrouver().get(index).getTitre(),
								ListeDVD.getLstDVDATrouver().get(index).getDateParution(), "Disponible", ""));
				intNombreDesDVD++;
				intNombreDesDocuments++;
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListeDVD.getLstDVDATrouver();
	}

	public static ArrayList<Livre> LireFichierLivres(String strNomFichier) {

		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erreur, aucun fichier trouver avec ce nom : " + e.toString());
		}
		String strLigne;
		StringTokenizer st;
		int index = 0;
		try {
			while ((strLigne = brFichier.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				ListeLivre.getLstLivreATrouver().add(new Livre(st.nextToken().trim(), st.nextToken().trim(),
						st.nextToken().trim(), "Disponible", "", st.nextToken().trim()));
				ListDocument.getLstAllDocument()
						.add(new Document(ListeLivre.getLstLivreATrouver().get(index).getNoDoc(),
								ListeLivre.getLstLivreATrouver().get(index).getTitre(),
								ListeLivre.getLstLivreATrouver().get(index).getDateParution(), "Disponible", ""));
				intNombreDesLivres++;
				intNombreDesDocuments++;
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListeLivre.getLstLivreATrouver();
	}

	public static ArrayList<Periodique> LireFichierPeriodique(String strNomFichier) {

		BufferedReader brFichier = null;
		try {
			brFichier = new BufferedReader(new FileReader(strNomFichier));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erreur, aucun fichier trouver avec ce nom : " + e.toString());
		}
		String strLigne;
		StringTokenizer st;
		int index = 0;
		try {
			while ((strLigne = brFichier.readLine()) != null) {
				st = new StringTokenizer(strLigne, ",");
				ListePeriodique.getLstPeriodiqueATrouver()
						.add(new Periodique(st.nextToken().trim(), st.nextToken().trim(), st.nextToken().trim(),
								"Disponible", "", st.nextToken().trim(), st.nextToken().trim()));
				ListDocument.getLstAllDocument()
						.add(new Document(ListePeriodique.getLstPeriodiqueATrouver().get(index).getNoDoc(),
								ListePeriodique.getLstPeriodiqueATrouver().get(index).getTitre(),
								ListePeriodique.getLstPeriodiqueATrouver().get(index).getDateParution(), "Disponible",
								""));
				intNombreDesPeriodiques++;
				intNombreDesDocuments++;
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ListePeriodique.getLstPeriodiqueATrouver();
	}

}
