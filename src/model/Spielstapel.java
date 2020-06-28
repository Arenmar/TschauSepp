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
		karten.add(new Karte("Eichel_6", 6, getClass().getResource("../Karten/eichel6.gif")));
		karten.add(new Karte("Eichel_7", 7, getClass().getResource("../Karten/eichel7.gif")));
		karten.add(new Karte("Eichel_8", 8, getClass().getResource("../Karten/eichel8.gif")));
		karten.add(new Karte("Eichel_9", 9, getClass().getResource("../Karten/eichel9.gif")));
		karten.add(new Karte("Eichel_10", 10, getClass().getResource("../Karten/eichel10.gif")));
		karten.add(new Karte("Eichel_Under", 20, getClass().getResource("../Karten/eichel11.gif")));
		karten.add(new Karte("Eichel_Ober", 3, getClass().getResource("../Karten/eichel12.gif")));
		karten.add(new Karte("Eichel_König", 4, getClass().getResource("../Karten/eichel13.gif")));
		karten.add(new Karte("Eichel_Ass", 11, getClass().getResource("../Karten/eichel14.gif")));

		karten.add(new Karte("Rose_6", 6, getClass().getResource("../Karten/rose6.gif")));
		karten.add(new Karte("Rose_7", 7, getClass().getResource("../Karten/rose7.gif")));
		karten.add(new Karte("Rose_8", 8, getClass().getResource("../Karten/rose8.gif")));
		karten.add(new Karte("Rose_9", 9, getClass().getResource("../Karten/rose9.gif")));
		karten.add(new Karte("Rose_10", 10, getClass().getResource("../Karten/rose10.gif")));
		karten.add(new Karte("Rose_Under", 20, getClass().getResource("../Karten/rose11.gif")));
		karten.add(new Karte("Rose_Ober", 3, getClass().getResource("../Karten/rose12.gif")));
		karten.add(new Karte("Rose_König", 4, getClass().getResource("../Karten/rose13.gif")));
		karten.add(new Karte("Rose_Ass", 11, getClass().getResource("../Karten/rose14.gif")));

		karten.add(new Karte("Schelle_6", 6, getClass().getResource("../Karten/schelle6.gif")));
		karten.add(new Karte("Schelle_7", 7, getClass().getResource("../Karten/schelle7.gif")));
		karten.add(new Karte("Schelle_8", 8, getClass().getResource("../Karten/schelle8.gif")));
		karten.add(new Karte("Schelle_9", 9, getClass().getResource("../Karten/schelle9.gif")));
		karten.add(new Karte("Schelle_10", 10, getClass().getResource("../Karten/schelle10.gif")));
		karten.add(new Karte("Schelle_Under", 20, getClass().getResource("../Karten/schelle11.gif")));
		karten.add(new Karte("Schelle_Ober", 3, getClass().getResource("../Karten/schelle12.gif")));
		karten.add(new Karte("Schelle_König", 4, getClass().getResource("../Karten/schelle13.gif")));
		karten.add(new Karte("Schelle_Ass", 11, getClass().getResource("../Karten/schelle14.gif")));

		karten.add(new Karte("Schilten_6", 6, getClass().getResource("../Karten/schliten6.gif")));
		karten.add(new Karte("Schilten_7", 7, getClass().getResource("../Karten/schliten7.gif")));
		karten.add(new Karte("Schilten_8", 8, getClass().getResource("../Karten/schliten8.gif")));
		karten.add(new Karte("Schilten_9", 9, getClass().getResource("../Karten/schliten9.gif")));
		karten.add(new Karte("Schilten_10", 10, getClass().getResource("../Karten/schliten10.gif")));
		karten.add(new Karte("Schilten_Under", 20, getClass().getResource("../Karten/schliten11.gif")));
		karten.add(new Karte("Schilten_Ober", 3, getClass().getResource("../Karten/schliten12.gif")));
		karten.add(new Karte("Schilten_König", 4, getClass().getResource("../Karten/schliten13.gif")));
		karten.add(new Karte("Schilten_Ass", 11, getClass().getResource("../Karten/schliten14.gif")));
	}

	public Karte zufaelligeKarte() {
		int wert = (int) Math.random() * karten.size();

		Karte temp = karten.get(wert);
		karten.remove(wert);

		return temp;
	}
}
