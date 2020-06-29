package model;

import java.net.URL;

/**
 * model.model.Karte
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class Karte {

	private String bezeichnung, zahl;
	private int wert;
	private URL pfad;

	public Karte(String bezeichnung, String zahl, int wert, URL pfad) {
		this.bezeichnung = bezeichnung;
		this.zahl = zahl;
		this.wert = wert;
		this.pfad = pfad;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	public URL getPfad() {
		return pfad;
	}

	public void setPfad(URL pfad) {
		this.pfad = pfad;
	}

	public String getZahl() {
		return zahl;
	}
}
