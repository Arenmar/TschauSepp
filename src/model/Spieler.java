package model;

import java.util.Vector;

/**
 * model.model.Spieler
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27 -06-2020
 */
public class Spieler {

	private String name;
	private Vector<Karte> hand = new Vector<Karte>();
	private boolean hatTschau;
	private boolean hatSepp;

	/**
	 * Instantiates a new Spieler.
	 *
	 * @param name the name
	 */
	public Spieler(String name) {
		this.name = name;
	}

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds card to the hand of the player.
	 *
	 * @param karte the card
	 */
	public void fuegeKarteZuHandHinzu(Karte karte) {
		hand.add(karte);
	}

	/**
	 * Removes card from players hand.
	 *
	 * @param karte the card
	 */
	public void entferneKarte(Karte karte) {
		hand.remove(karte);
	}

	/**
	 * Gets hand.
	 *
	 * @return the hand
	 */
	public Vector<Karte> getHand() {
		return hand;
	}

	/**
	 * Sets tschau true to the player.
	 *
	 * @param hatTschau the hat tschau
	 */
	public void setHatTschau(boolean hatTschau) {
		this.hatTschau = hatTschau;
	}

	/**
	 * Gets tschaustatus from player.
	 *
	 * @return the boolean
	 */
	public boolean isHatTschau() {
		return hatTschau;
	}

	/**
	 * Sets sepp true to the player.
	 *
	 * @param hatSepp the hat sepp
	 */
	public void setHatSepp(boolean hatSepp) {
		this.hatSepp = hatSepp;
	}

	/**
	 * Gets seppstatus to the player.
	 *
	 * @return the boolean
	 */
	public boolean isHatSepp() {
		return hatSepp;
	}
}
