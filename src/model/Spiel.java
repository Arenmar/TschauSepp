package model;

import gui.GameGUI;

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
	private Stapel spielstapel, ablagestapel;
	private Karte letzteKarte;
	private Vector<Spieler> spielerListe;

	public Spiel() {

		spielerListe = new Vector<>();
		spielstapel = new Stapel();
		ablagestapel = new Stapel();
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

	public void spieleKarte(Spieler spieler, int index) {

		Karte letzteKarte = ablagestapel.getObersteKarte();

		if (spieler.isAktuellerSpieler()) {

			Karte karte = spieler.getHand().get(index);

			if (ablagestapel.getObersteKarte().getBezeichnung().equalsIgnoreCase(karte.getBezeichnung()) ||
				ablagestapel.getObersteKarte().getZahl().equalsIgnoreCase(karte.getZahl())) {

				spieler.entferneKarte(karte);
				ablagestapel.karteHinzufuegen(karte);
			}
		}
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

	public Stapel getSpielstapel() {
		return spielstapel;
	}

	public Stapel getAblagestapel() {
		return ablagestapel;
	}

	public Karte getLetzteKarte() {
		return letzteKarte;
	}

	public void setSpieler(Spieler spieler) {
		spielerListe.add(spieler);
	}
}
