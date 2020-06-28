package model;

import java.util.Collections;
import java.util.Vector;

/**
 * model.model.Spielstapel
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class Spielstapel {

	private Vector<Karte> karten;

	public Spielstapel () {
		karten = new Vector<Karte>();

		neuerStapel();
		neuerStapel();

		Collections.shuffle(karten);
	}

	public void neuerStapel() {
		karten.add(new Karte("Eichel", "6", 6, getClass().getResource("../cards/eichel6.gif")));
		karten.add(new Karte("Eichel", "7", 7, getClass().getResource("../cards/eichel7.gif")));
		karten.add(new Karte("Eichel", "8", 8, getClass().getResource("../cards/eichel8.gif")));
		karten.add(new Karte("Eichel", "9", 9, getClass().getResource("../cards/eichel9.gif")));
		karten.add(new Karte("Eichel", "10", 10, getClass().getResource("../cards/eichel10.gif")));
		karten.add(new Karte("Eichel", "Under", 20, getClass().getResource("../cards/eichel11.gif")));
		karten.add(new Karte("Eichel", "Ober", 3, getClass().getResource("../cards/eichel12.gif")));
		karten.add(new Karte("Eichel", "König", 4, getClass().getResource("../cards/eichel13.gif")));
		karten.add(new Karte("Eichel", "Ass", 11, getClass().getResource("../cards/eichel14.gif")));

		karten.add(new Karte("Rose", "6", 6, getClass().getResource("../cards/rose6.gif")));
		karten.add(new Karte("Rose", "7", 7, getClass().getResource("../cards/rose7.gif")));
		karten.add(new Karte("Rose", "8", 8, getClass().getResource("../cards/rose8.gif")));
		karten.add(new Karte("Rose", "9", 9, getClass().getResource("../cards/rose9.gif")));
		karten.add(new Karte("Rose", "10", 10, getClass().getResource("../cards/rose10.gif")));
		karten.add(new Karte("Rose", "Under", 20, getClass().getResource("../cards/rose11.gif")));
		karten.add(new Karte("Rose", "Ober", 3, getClass().getResource("../cards/rose12.gif")));
		karten.add(new Karte("Rose", "König", 4, getClass().getResource("../cards/rose13.gif")));
		karten.add(new Karte("Rose", "Ass", 11, getClass().getResource("../cards/rose14.gif")));

		karten.add(new Karte("Schelle", "6", 6, getClass().getResource("../cards/schelle6.gif")));
		karten.add(new Karte("Schelle", "7", 7, getClass().getResource("../cards/schelle7.gif")));
		karten.add(new Karte("Schelle", "8", 8, getClass().getResource("../cards/schelle8.gif")));
		karten.add(new Karte("Schelle", "9", 9, getClass().getResource("../cards/schelle9.gif")));
		karten.add(new Karte("Schelle", "10", 10, getClass().getResource("../cards/schelle10.gif")));
		karten.add(new Karte("Schelle", "Under", 20, getClass().getResource("../cards/schelle11.gif")));
		karten.add(new Karte("Schelle", "Ober", 3, getClass().getResource("../cards/schelle12.gif")));
		karten.add(new Karte("Schelle", "König", 4, getClass().getResource("../cards/schelle13.gif")));
		karten.add(new Karte("Schelle", "Ass", 11, getClass().getResource("../cards/schelle14.gif")));

		karten.add(new Karte("Schilten", "6", 6, getClass().getResource("../cards/schliten6.gif")));
		karten.add(new Karte("Schilten", "7", 7, getClass().getResource("../cards/schliten7.gif")));
		karten.add(new Karte("Schilten", "8", 8, getClass().getResource("../cards/schliten8.gif")));
		karten.add(new Karte("Schilten", "9", 9, getClass().getResource("../cards/schliten9.gif")));
		karten.add(new Karte("Schilten", "10", 10, getClass().getResource("../cards/schliten10.gif")));
		karten.add(new Karte("Schilten", "Under", 20, getClass().getResource("../cards/schliten11.gif")));
		karten.add(new Karte("Schilten", "Ober", 3, getClass().getResource("../cards/schliten12.gif")));
		karten.add(new Karte("Schilten", "König", 4, getClass().getResource("../cards/schliten13.gif")));
		karten.add(new Karte("Schilten", "Ass", 11, getClass().getResource("../cards/schliten14.gif")));
	}

	public Karte zufaelligeKarte() {
		int wert = (int) Math.random() * karten.size();

		Karte temp = karten.get(wert);
		karten.remove(wert);

		return temp;
	}
}
