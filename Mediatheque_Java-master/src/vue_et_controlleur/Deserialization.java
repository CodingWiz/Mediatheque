package vue_et_controlleur;

import Objet.ListeDVD;
import Objet.ListeLivre;
import Objet.ListePeriodique;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Objet.DVD;
import Objet.Document;
import Objet.ListDocument;
import Objet.Livre;
import Objet.Periodique;

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

	public static void DeserialiserDVD() {
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

	public static void DeserialiserLivre() {
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

	public static void DeserialiserPeriodique() {
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
	
	
	public static void DeserialiserDocument() {
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
