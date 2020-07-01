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

	public void fuegeKarteZuHandHinzu(Karte karte) {
		hand.add(karte);
	}

	public void entferneKarte(Karte karte) {
		hand.remove(karte);
	}

	public Vector<Karte> getHand() {
		return hand;
	}

	public void setHatTschau(boolean hatTschau) {
		this.hatTschau = hatTschau;
	}

	public boolean isHatTschau() {
		return hatTschau;
	}

	public void setHatSepp(boolean hatSepp) {
		this.hatSepp = hatSepp;
	}

	public boolean isHatSepp() {
		return hatSepp;
	}
}
