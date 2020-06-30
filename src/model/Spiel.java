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
	private Spieler spieler;
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

	public void getAktuellerSpieler() {

	}

	public void getGueltigeZüge() {

	}

	public void zieheKarten(Spieler spieler, int anzahlKarten) {

	}

	public void spieleKarte(Spieler spieler, int index) {

		if (spieler.isAktuellerSpieler()) {

			Karte karte = spieler.getHand().get(index);

			if (ablagestapel.getObersteKarte().getBezeichnung().equalsIgnoreCase(karte.getBezeichnung()) ||
				ablagestapel.getObersteKarte().getZahl().equalsIgnoreCase(karte.getZahl())) {

				spieler.entferneKarte(karte);
				ablagestapel.karteHinzufuegen(karte);
				gameGUI.karteAnzeigen();
			}
		}

		setChanged();
		notifyObservers(this.spieler.getHand());
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

	public void nextPlayer() {

		for (int i = 0; i < spielerListe.size(); i++) {
			if(spielerListe.get(i).equals(spielerListe.get(i).isAktuellerSpieler())){
				if (spielerListe.size() == i+1){
					spielerListe.get(0).setAktuellerSpieler(true);
				}else{
					spielerListe.get(i+1).setAktuellerSpieler(true);
				}
				break;
			}
		}
	}

	public void ersterSpieler() {
		spielerListe.get(0).setAktuellerSpieler(true); //(int) Math.random() * (spielerListe.size() - 1) + 1
	}
}
