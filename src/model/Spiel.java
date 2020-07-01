package model;

import gui.GameGUI;
import gui.PlayerGUI;
import gui.WinnerGUI;

import java.util.Observable;
import java.util.Vector;

/**
 * model.model.Spiel
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27 -06-2020
 */
public class Spiel extends Observable {

	private int spielerCntr;
	private Stapel spielstapel, ablagestapel;
	private Vector<Spieler> spielerListe;
	private Vector<PlayerGUI> allePlayerGUIs;
	private GameGUI gameGUI;
	private PlayerGUI playerGUI;

	/**
	 * Instantiates a new Spiel.
	 */
	public Spiel() {

		spielerListe = new Vector<>();
		allePlayerGUIs = new Vector<>();

		spielstapel = new Stapel();
		ablagestapel = new Stapel();

		spielerCntr = 0;
	}

	/**
	 * Ends game.
	 *
	 * @param spieler the player
	 */
	public void beendeSpiel(Spieler spieler) {

		gameGUI.spielende(spieler);
	}

	/**
	 * Gets a card from Deck.
	 *
	 * @param spieler the spieler
	 * @return the karte
	 */
	public Karte zieheKarten(Spieler spieler) {

		Karte zugKarte = spielstapel.getObersteKarte();
		spieler.fuegeKarteZuHandHinzu(zugKarte);
		spielstapel.getDeck().remove(zugKarte);

		//System.out.println(spieler.getHand()); <-- Zum Debuggen, zeigt dass ein neues Objekt in der Hand des Spielers ist

		return zugKarte;
	}

	/**
	 * Puts a card from hand onto the deck.
	 *
	 * @param spieler       the player
	 * @param selectedIndex the index of the card
	 */
	public void spieleKarte(Spieler spieler, int selectedIndex) {

		Karte karte = spieler.getHand().get(selectedIndex);

		/* Zum Debuggen, zeigt in Konsole Karte auf Stapel & in Hand
		System.out.println("Karte auf Stapel: " +
							ablagestapel.getObersteKarte().getBezeichnung() +
							ablagestapel.getObersteKarte().getZahl());

		System.out.println("Abgelegte Karte: " + karte.getBezeichnung() + karte.getZahl());
		*/

		if (ablagestapel.getObersteKarte().getBezeichnung().equalsIgnoreCase(karte.getBezeichnung()) ||
			ablagestapel.getObersteKarte().getZahl().equalsIgnoreCase(karte.getZahl())) {

			spieler.entferneKarte(karte);
			ablagestapel.karteHinzufuegen(karte);
			gameGUI.karteAnzeigen();
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * Checks if the card is allowed to be layed.
	 *
	 * @param spieler       the player
	 * @param selectedIndex the selected index
	 * @return the boolean
	 */
	public Boolean checkMove(Spieler spieler, int selectedIndex) {

		Karte karte = spieler.getHand().get(selectedIndex);

		if (ablagestapel.getObersteKarte().getBezeichnung().equalsIgnoreCase(karte.getBezeichnung()) ||
			ablagestapel.getObersteKarte().getZahl().equalsIgnoreCase(karte.getZahl())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if any card on the players hand is allowed to be layed.
	 *
	 * @param spieler the spieler
	 * @return the boolean
	 */
	public Boolean checkPlayable(Spieler spieler) {

		boolean temp = false;

		for (int i = 0; i < spieler.getHand().size(); i++) {
			if (ablagestapel.getObersteKarte().getBezeichnung().equalsIgnoreCase(spieler.getHand().get(i).getBezeichnung()) ||
				ablagestapel.getObersteKarte().getZahl().equalsIgnoreCase(spieler.getHand().get(i).getZahl())) {

				temp = true;
			}
		}
		return temp;
	}

	/**
	 * Gets all players.
	 *
	 * @return the alleSpieler Vector
	 */
	public Vector<Spieler> getAlleSpieler() {
		return spielerListe;
	}

	/**
	 * Gets a single player from the Vector.
	 *
	 * @return the player
	 */
	public Spieler getEinzelnerSpieler() {
		return spielerListe.get(spielerCntr);
	}

	/**
	 * Gets the whole stack of cards.
	 *
	 * @return the spielstapel
	 */
	public Stapel getSpielstapel() {
		return spielstapel;
	}

	/**
	 * Gets whole stack of layed cards.
	 *
	 * @return the ablagestapel
	 */
	public Stapel getAblagestapel() {
		return ablagestapel;
	}

	/**
	 * Adds player to Vector.
	 *
	 * @param spieler the player
	 */
	public void setSpieler(Spieler spieler) {
		spielerListe.add(spieler);
	}

	/**
	 * Sets game gui.
	 *
	 * @param gameGUI the game gui
	 */
	public void setGameGUI(GameGUI gameGUI) {
		this.gameGUI = gameGUI;
	}

	/**
	 * Add playerGUIs to playerGUI Vector.
	 *
	 * @param playerGUI the playerGUI
	 */
	public void addPlayerGUIs(PlayerGUI playerGUI) {
		allePlayerGUIs.add(playerGUI);
	}

	/**
	 * Sets next player.
	 */
	public void setNextPlayer() {

		if (spielerCntr == (spielerListe.size() - 1)) {
			spielerCntr = 0;
		} else {
			spielerCntr++;
		}

		activatePlayerGUI();
	}

	/**
	 * Activate playerGUI.
	 */
	public void activatePlayerGUI() {

		for (int i = 0; i < allePlayerGUIs.size(); i++) {
			if (spielerCntr == i) {
				allePlayerGUIs.get(i).renderPlayerGUI();
			} else {
				allePlayerGUIs.get(i).unrenderPlayerGUI();
			}
		}
	}

	/**
	 * Creates a new stack of cards if current is empty.
	 */
	public void neuesDeck() {

		if (spielstapel.getDeck().size() == 0) {
			spielstapel.neuerStapel();
		}
	}
}
