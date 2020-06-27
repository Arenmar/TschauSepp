import java.util.Vector;

/**
 * model.Spieler
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

	public void fuegeKarteZuHandHinzu(Spieler spieler, Vector<Karte> hand) {

	}

	public void entferneKarteAusHand(Spieler spieler, Vector<Karte> hand) {

	}

	public void entferneAlleKarten() {

	}

	public int getPunkte() {
		return punkte;
	}

	public void fuegePunkteHinzu(Spieler spieler, int punkte) {

	}

	/*
	public String toString() {
		//TODO
	}
	 */

}
