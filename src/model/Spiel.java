package model;

import gui.GameGUI;
import gui.PlayerGUI;

import java.util.Observable;
import java.util.Vector;

/**
 * model.model.Spiel
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class Spiel extends Observable {

	private int anzSpieler, anzKartenZuZiehen;
	private Spieler aktuellerSpieler;
	private Stapel spielstapel, ablagestapel;
	private Karte letzteKarte;
	private Vector<Spieler> spielerListe;
	private GameGUI gameGUI;
	private PlayerGUI playerGUI;

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

	public boolean getAktuellerSpieler() {

		for (int i = 0; i < spielerListe.size(); i++) {
			if (spielerListe.get(i).isAktuellerSpieler()) {
				System.out.println("Aktueller Spieler:" + spielerListe.get(i).getName());
				return spielerListe.get(i).isAktuellerSpieler();
			} else {
				return null;
			}
		}
	}



	public void zieheKarten(Spieler spieler) {

	}

	public void spieleKarte(Spieler spieler, int selectedIndex) {

		if (spieler.isAktuellerSpieler()) {

			Karte karte = spieler.getHand().get(selectedIndex);

			System.out.println(ablagestapel.getObersteKarte().getBezeichnung());
			System.out.println(ablagestapel.getObersteKarte().getZahl());
			System.out.println(karte.getBezeichnung());
			System.out.println(karte.getZahl());
			if (ablagestapel.getObersteKarte().getBezeichnung().equalsIgnoreCase(karte.getBezeichnung()) ||
				ablagestapel.getObersteKarte().getZahl().equalsIgnoreCase(karte.getZahl())) {

				spieler.entferneKarte(karte);
				ablagestapel.karteHinzufuegen(karte);
				gameGUI.karteAnzeigen();
			}
		}
		setChanged();
		notifyObservers();
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

	public void setGameGUI(GameGUI gameGUI) {
		this.gameGUI = gameGUI;
	}

	public void setCurrentPlayer(Spieler aktuellerSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
	}

	public Spieler getCurrentPlayer() {
		return aktuellerSpieler;
	}

	public void setNextPlayer() {

		for (int i = 0; i < spielerListe.size(); i++) {
			if (spielerListe.get(i).equals(aktuellerSpieler)) {
				if (i == 3) {
					setCurrentPlayer(spielerListe.get(0));
				} else {
					setCurrentPlayer(spielerListe.get(i + 1));
				}
				break;
			}
		}
	}

	public Spieler ersterSpieler(int index) {
		spielerListe.get(index).setAktuellerSpieler(true); //(int) Math.random() * (spielerListe.size() - 1) + 1
		return spielerListe.get(0);
	}
}
