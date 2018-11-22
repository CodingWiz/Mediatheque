package Objet;

import java.io.Serializable;
import java.util.ArrayList;

public class ListDocument implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	public static ArrayList<Document> lstAllDocument = new ArrayList<Document>();

	public static void ajouterDocument(Document document) {
		lstAllDocument.add(document);
	}

	public static void supprimerDocument(Document document) {
		lstAllDocument.remove(document);
	}

	public static ArrayList<Document> getLstAllDocument() {
		return lstAllDocument;
	}

	public static void setLstAllDocument(ArrayList<Document> lstAllDocument) {
		ListDocument.lstAllDocument = lstAllDocument;
	}
}
