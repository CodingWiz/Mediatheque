package vue_et_controlleur.gererDocument;

import java.util.ArrayList;

import classMediateque.Document;

public class ListDocument {
public static	ArrayList<Document> lstAllDocument = new ArrayList<Document>();
	
	
	public static void ajouterDocument(Document document){
		lstAllDocument.add(document);
	}
	
	public static void supprimerDocument(Document document){
		lstAllDocument.remove(document);
	}

	public static ArrayList<Document> getLstAllDocument() {
		return lstAllDocument;
	}

	public static void setLstAllDocument(ArrayList<Document> lstAllDocument) {
		ListDocument.lstAllDocument = lstAllDocument;
	}
}
