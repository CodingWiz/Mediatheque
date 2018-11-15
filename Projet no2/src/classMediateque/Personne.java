package classMediateque;

import java.io.Serializable;

public class Personne implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
private String strNom;
private String strPrenom;
private String strAdresse;
private String strTelephone;



public Personne(String strNom, String strPrenom, String strAdresse, String strTelephone) {

	this.strNom = strNom;
	this.strPrenom = strPrenom;
	this.strAdresse = strAdresse;
	this.strTelephone = strTelephone;
}



public void ajouter() {
}

public String getStrNom() {
	return strNom;
}



public void setStrNom(String strNom) {
	this.strNom = strNom;
}



public String getStrPrenom() {
	return strPrenom;
}



public void setStrPrenom(String strPrenom) {
	this.strPrenom = strPrenom;
}



public String getStrAdresse() {
	return strAdresse;
}



public void setStrAdresse(String strAdresse) {
	this.strAdresse = strAdresse;
}



public String getStrTelephone() {
	return strTelephone;
}



public void setStrTelephone(String strTelephone) {
	this.strTelephone = strTelephone;
}



public void modifer() {	
}

public void supprimer() {
	
}



}
