package model;

import java.net.URL;

/**
 * model.model.Karte
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27 -06-2020
 */
public class Karte {

	private String bezeichnung, zahl;
	private URL pfad;

	/**
	 * Instantiates a new Karte.
	 *
	 * @param bezeichnung the bezeichnung
	 * @param zahl        the zahl
	 * @param pfad        the pfad
	 */
	public Karte(String bezeichnung, String zahl, int wert, URL pfad) {
		this.bezeichnung = bezeichnung;
		this.zahl = zahl;
		this.pfad = pfad;
	}

	/**
	 * Gets bezeichnung.
	 *
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}

	/**
	 * Gets pfad.
	 *
	 * @return the pfad
	 */
	public URL getPfad() {
		return pfad;
	}

	/**
	 * Gets zahl.
	 *
	 * @return the zahl
	 */
	public String getZahl() {
		return zahl;
	}
}
