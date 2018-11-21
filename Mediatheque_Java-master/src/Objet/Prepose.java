package Objet;

public class Prepose extends Personne {
/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
private String strNoPrepose;
private String strPassword;
	public Prepose(String strNom, String strPrenom, String strAdresse, String strTelephone,String strNoPrepose,String strPassword) {
		super(strNom, strPrenom, strAdresse, strTelephone);
		// TODO Auto-generated constructor stub
		this.strNoPrepose = strNoPrepose;
		this.strPassword = strPassword;
	}
	
	public void seconnecter(){
		
	}

	public String getStrNoPrepose() {
		return strNoPrepose;
	}

	public void setStrNoPrepose(String strNoPrepose) {
		this.strNoPrepose = strNoPrepose;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	@Override
	public String toString() {
		return "No Prepose : " + strNoPrepose + "\nPassword :" + strPassword;
	}

}
