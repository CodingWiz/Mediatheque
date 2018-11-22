package Objet;

import java.io.Serializable;

public class Pret implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	String dateDePret;
	String dateRetourPreveu;
	String dateEffectiveRetour;
	Adherent Adherent;
	Document noDoc;
	String dbAmende;

	public Pret(String dateDePret, String dateRetourPreveu, String dateEffectiveRetour, Adherent Adherent,
			Document noDoc, String dbAmende) {
		super();
		this.dateDePret = dateDePret;
		this.dateRetourPreveu = dateRetourPreveu;
		this.dateEffectiveRetour = dateEffectiveRetour;
		this.Adherent = Adherent;
		this.noDoc = noDoc;
		this.dbAmende = dbAmende;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDateDePret() {
		return dateDePret;
	}

	public String getDateRetourPreveu() {
		return dateRetourPreveu;
	}

	public String getDateEffectiveRetour() {
		return dateEffectiveRetour;
	}

	public Adherent getAdherent() {
		return Adherent;
	}

	public Document getNoDoc() {
		return noDoc;
	}

	public String getDbAmende() {
		return dbAmende;
	}

	public void setDateDePret(String dateDePret) {
		this.dateDePret = dateDePret;
	}

	public void setDateRetourPreveu(String dateRetourPreveu) {
		this.dateRetourPreveu = dateRetourPreveu;
	}

	public void setDateEffectiveRetour(String dateEffectiveRetour) {
		this.dateEffectiveRetour = dateEffectiveRetour;
	}

	public void setAdherent(Adherent Adherent) {
		this.Adherent = Adherent;
	}

	public void setNoDoc(Document noDoc) {
		this.noDoc = noDoc;
	}

	public void setDbAmende(String dbAmende) {
		this.dbAmende = dbAmende;
	}

	@Override
	public String toString() {
		return "Pret [dateDePret=" + dateDePret + ", dateRetourPreveu=" + dateRetourPreveu + ", dateEffectiveRetour="
				+ dateEffectiveRetour + ", Adherent=" + Adherent + ", noDoc=" + noDoc + ", dbAmende=" + dbAmende + "]";
	}

}
