package Objet;

public class Adherent extends Personne {

	private static final long serialVersionUID = 2L;

	
	public Adherent(String strNom, String strPrenom, String strAdresse, String strTelephone) {
		super(strNom, strPrenom, strAdresse, strTelephone);
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
