package Objet;

import java.io.Serializable;

public class Periodique extends Document implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String noVolume;
	private final String noPeriodique;

	public Periodique(String noDoc, String titre, String dateParution, String etat, String motsclés, String noVolume,
			String noPeriodique) {
		super(noDoc, titre, dateParution, etat, motsclés);
		this.noVolume = noVolume;
		this.noPeriodique = noPeriodique;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNoVolume() {
		return noVolume;
	}

	public String getNoPeriodique() {
		return noPeriodique;
	}

}
