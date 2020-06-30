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

	public void karteLegen(Spieler spieler, Vector<Karte> hand) {

		if (karte.getType().equals(game.getObersteKarte().getType()) || card.getCardValue() == game.getObersteKarte().getCardValue()){
			if (card.getEventNr() != -1){
				card.specialEvent(game);
			}
			this.card.remove(card);
			game.getAblagestapel().add(card);
			if (card.getCardValue() != 20){
				game.setObersteKarte(card);
			}

			setChanged();
			notifyObservers(this.card);
			game.nextPlayer();
		}

		if (this.card.size() == 0){
			game.endRound(this);
		}
	}

	public void entferneAlleKarten() {

	}

	public int getPunkte() {
		return punkte;
	}

	public void fuegePunkteHinzu(Spieler spieler, int punkte) {

	}

	public Vector<Karte> getKarten() {
		return hand;
	}

	/*
	public String toString() {
		//TODO
	}
	 */

}
