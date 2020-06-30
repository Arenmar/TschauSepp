package model;

import java.util.Vector;

/**
 * model.model.Spieler
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class Spieler {

	private String name;
	private Vector<Karte> hand = new Vector<Karte>();
	private int punkte;
	private boolean hatTschau;
	private boolean hatSepp;
	private boolean aktuellerSpieler;

	public Spieler(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAnzKarten(Spieler spieler) {
		return hand.size();
	}

	public void fuegeKarteZuHandHinzu(Karte karte) {
		hand.add(karte);
	}

	public void entferneAlleKarten() {

	}

	public void entferneKarte(Karte karte) {
		hand.remove(karte);
	}

	public int getPunkte() {
		return punkte;
	}

	public void fuegePunkteHinzu(Spieler spieler, int punkte) {

	}

	public Vector<Karte> getHand() {
		return hand;
	}

	public boolean isAktuellerSpieler() {
		if (aktuellerSpieler) {
			return true;
		}
		return false;
	}

	public void setAktuellerSpieler(boolean aktuellerSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
	}
}
