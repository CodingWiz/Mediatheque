package vue_et_controlleur;

import Objet.ListeDVD;
import Objet.ListeLivre;
import Objet.ListePeriodique;
import Objet.ListePrepose;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Objet.Adherent;
import Objet.DVD;
import Objet.Document;
import Objet.ListDocument;
import Objet.ListeAdherant;
import Objet.Livre;
import Objet.Periodique;
import Objet.Prepose;

public class Deserialization {
	public Deserialization() {

	}

	/*
	 * public static void DeserialiserPret(){ FileInputStream fichier = null; try {
	 * fichier = new FileInputStream("prêt.ser"); } catch (FileNotFoundException e1)
	 * { // TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * ObjectInputStream is = null; try { is = new ObjectInputStream(fichier); }
	 * catch (IOException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } Pret pret;
	 * 
	 * try {
	 * 
	 * while( (pret = (Pret) is.readObject())!=null){ ListePret.ajouterPret(pret);
	 * 
	 * } } catch (IOException e) {
	 * 
	 * // fin de fichier ou fichier introuvable.
	 * 
	 * 
	 * }
	 * 
	 * catch (ClassNotFoundException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	@SuppressWarnings("resource")
	public static void DeserialiserDVD() {
		/*File fileDVD = new File("DVD.ser");
		if (fileDVD.exists()) {
			fileDVD.delete();
		}
		try {
			new ObjectOutputStream(new FileOutputStream("DVD.ser"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		FileInputStream fichier = null;
		try {
			fichier = new FileInputStream("DVD.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fichier);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DVD dvd;
		try {
			while ((dvd = (DVD) is.readObject()) != null) {
				ListeDVD.ajouterDVD(dvd);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void DeserialiserLivre() {
		
		/*File fileLivre = new File("livre.ser");
		if (fileLivre.exists()) {
			fileLivre.delete();
		}
		try {
			new ObjectOutputStream(new FileOutputStream("livre.ser"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		*/
		FileInputStream fichier = null;
		try {
			fichier = new FileInputStream("livre.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fichier);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Livre livre;
		try {
			while ((livre = (Livre) is.readObject()) != null) {
				ListeLivre.ajouterLivre(livre);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static void DeserialiserPeriodique() {
		/*
		File filePer = new File("periodique.ser");
		if (filePer.exists()) {
			filePer.delete();
		}
		try {
			new ObjectOutputStream(new FileOutputStream("periodique.ser"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		FileInputStream fichier = null;
		try {
			fichier = new FileInputStream("periodique.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fichier);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Periodique periodique;
		try {
			while ((periodique = (Periodique) is.readObject()) != null) {
				ListePeriodique.ajouterPeriodique(periodique);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("resource")
	public static void DeserialiserDocument() {
		/*
		File fileDocument = new File("document.ser");
		if (fileDocument.exists()) {
			fileDocument.delete();
		}
		try {
			new ObjectOutputStream(new FileOutputStream("document.ser"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		FileInputStream fichier = null;
		try {
			fichier = new FileInputStream("document.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fichier);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document document;
		try {
			while ((document = (Document) is.readObject()) != null) {
				ListDocument.ajouterDocument(document);;
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@SuppressWarnings("resource")
	public static void DeserialiserAdherant() {
		/*
		File fileAdhrant = new File("adherant.ser");
		if (fileAdhrant.exists()) {
			fileAdhrant.delete();
		}
		try {
			new ObjectOutputStream(new FileOutputStream("adherant.ser"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		FileInputStream fichier = null;
		try {
			fichier = new FileInputStream("adherant.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fichier);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Adherent adherant;
		try {
			while ((adherant = (Adherent) is.readObject()) != null) {
				ListeAdherant.ajouterAdherant(adherant);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@SuppressWarnings("resource")
	public static void DeserialiserPrepose() {
		/*
		File filePrepose = new File("prepose.ser");
		if (filePrepose.exists()) {
			filePrepose.delete();
		}

		
		
		try {
			new ObjectOutputStream(new FileOutputStream("prepose.ser"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		FileInputStream fichier = null;
		try {
			fichier = new FileInputStream("prepose.ser");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(fichier);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Prepose prepose;
		try {
			while ((prepose = (Prepose) is.readObject()) != null) {
				ListePrepose.ajouterPrepose(prepose);
				System.out.println(prepose);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void DeserialiserAdherent(){ FileInputStream fichier = null;
	 * try { fichier = new FileInputStream("adhérent.ser"); } catch
	 * (FileNotFoundException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); }
	 * 
	 * ObjectInputStream is = null; try { is = new ObjectInputStream(fichier); }
	 * catch (IOException e1) { // TODO Auto-generated catch block
	 * e1.printStackTrace(); } Adherent adherent; try { while( (adherent =
	 * (Adherent) is.readObject())!=null){ ListeAdherent.ajouterAdherent(adherent);
	 * } } catch (IOException e) { } catch (ClassNotFoundException e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 */

	public static void main(String[] args) {

	}
}
