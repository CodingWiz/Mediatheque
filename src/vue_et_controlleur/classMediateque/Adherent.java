package vue_et_controlleur.classMediateque;

public class Adherent extends Personne {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String strNoAdherent;
	private String strPassword;
	
	public Adherent(String strNom, String strPrenom, String strAdresse, String strTelephone, String strNoAdherent, String strPassword) {
		super(strNom, strPrenom, strAdresse, strTelephone);
		this.strNoAdherent = strNoAdherent;
		this.strPassword = strPassword;
		
		// TODO Auto-generated constructor stub
	}

	public String getStrNoAdherent() {
		return strNoAdherent;
	}

	public void setStrNoAdherent(String strNoAdherent) {
		this.strNoAdherent = strNoAdherent;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
