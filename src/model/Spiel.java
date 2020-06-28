package model;

import java.util.Vector;

/**
 * model.model.Spiel
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class Spiel {

	private int aktuellerSpieler, anzSpieler, anzKartenZuZiehen;
	private Spieler spieler;
	private Spielstapel spielstapel;
	private Karte letzteKarte;
	private Vector<Spieler> spielerListe;

	public Spiel() {
		spielerListe = new Vector<>();
	}

	public void naechsterSpieler() {

	}

	public void ladeSpiel() {

	}

	public void ladeRunde() {

	}

	public void fuelleKartenstapel() {

	}

	public void beendeSpiel() {

	}

	public void getAktuellerSpieler() {

	}

	public void getGueltigeZüge() {

	}

	public void zieheKarten(Spieler spieler, int anzahlKarten) {

	}

	public boolean spieleKarte(Spieler spieler, String symbol) {
		return true;
	}

	public void rufeTschau(Spieler spieler) {

	}

	public void rufeSepp() {

	}

	public int getAnzSpieler() {
		return anzSpieler;
	}

	public int getAnzKartenZuZiehen() {
		return anzKartenZuZiehen;
	}

	public Vector<Spieler> getSpieler() {
		return spielerListe;
	}

	public Spielstapel getSpielstapel() {
		return spielstapel;
	}

	public Karte getLetzteKarte() {
		return letzteKarte;
	}
}
