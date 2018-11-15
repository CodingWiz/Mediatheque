package vue_et_controlleur.classMediateque;

import java.io.Serializable;

public class Pret  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	String noPret;
	String dateDuJour;
	String dateRetourPreveu;
	String dateEffectiveRetour;
	String noAdherent;
	String noDoc;
	String dbAmende;
	
	
	public Pret(String noPret, String dateDuJour, String dateRetourPreveu, String dateEffectiveRetour,
			String noAdherent, String noDoc, String dbAmende) {
		super();
		this.noPret = noPret;
		this.dateDuJour = dateDuJour;
		this.dateRetourPreveu = dateRetourPreveu;
		this.dateEffectiveRetour = dateEffectiveRetour;
		this.noAdherent = noAdherent;
		this.noDoc = noDoc;
		this.dbAmende = dbAmende;
	}


	

	public String getNoPret() {
		return noPret;
	}




	public void setNoPret(String noPret) {
		this.noPret = noPret;
	}




	public String getDateDuJour() {
		return dateDuJour;
	}




	public void setDateDuJour(String dateDuJour) {
		this.dateDuJour = dateDuJour;
	}




	public String getDateRetourPreveu() {
		return dateRetourPreveu;
	}




	public void setDateRetourPreveu(String dateRetourPreveu) {
		this.dateRetourPreveu = dateRetourPreveu;
	}




	public String getDateEffectiveRetour() {
		return dateEffectiveRetour;
	}




	public void setDateEffectiveRetour(String dateEffectiveRetour) {
		this.dateEffectiveRetour = dateEffectiveRetour;
	}




	public String getNoAdherent() {
		return noAdherent;
	}




	public void setNoAdherent(String noAdherent) {
		this.noAdherent = noAdherent;
	}




	public String getNoDoc() {
		return noDoc;
	}




	public void setNoDoc(String noDoc) {
		this.noDoc = noDoc;
	}




	@Override
	public String toString() {
		return "Pret [noPret=" + noPret + ", dateDuJour=" + dateDuJour + ", dateRetourPreveu=" + dateRetourPreveu
				+ ", dateEffectiveRetour=" + dateEffectiveRetour + ", noAdherent=" + noAdherent + ", noDoc=" + noDoc
				+ ", dbAmende=" + dbAmende + ", getNoPret()=" + getNoPret() + ", getDateDuJour()=" + getDateDuJour()
				+ ", getDateRetourPreveu()=" + getDateRetourPreveu() + ", getDateEffectiveRetour()="
				+ getDateEffectiveRetour() + ", getNoAdherent()=" + getNoAdherent() + ", getNoDoc()=" + getNoDoc()
				+ ", getDbAmende()=" + getDbAmende() + ", getDette()=" + getDette() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}




	public String getDbAmende() {
		return dbAmende;
	}




	public void setDbAmende(String dbAmende) {
		this.dbAmende = dbAmende;
	}




	public double getDette() {
		double intDette = 0;
		
		
		return intDette;
	}

	
}
