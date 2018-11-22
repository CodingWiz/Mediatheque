package Objet;

import java.io.Serializable;

public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	private String noDoc;
	private String titre;
	private String dateParution;
	private String etat;
	private String motscl�s;

	public Document(String noDoc, String titre, String dateParution, String etat, String motscl�s) {
		super();
		this.noDoc = noDoc;
		this.titre = titre;
		this.dateParution = dateParution;
		this.etat = etat;
		this.motscl�s = motscl�s;
	}

	public void setNoDoc(String noDoc) {
		this.noDoc = noDoc;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDateParution(String dateParution) {
		this.dateParution = dateParution;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public void setMotscl�s(String motscl�s) {
		this.motscl�s = motscl�s;
	}

	public String getNoDoc() {
		return noDoc;
	}

	public String getTitre() {
		return titre;
	}

	public String getDateParution() {
		return dateParution;
	}

	public String getEtat() {
		return etat;
	}

	public String getMotscl�s() {
		return motscl�s;
	}

	public String toString() {
		return (noDoc);
	}

}
