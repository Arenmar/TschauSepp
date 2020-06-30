package model;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Vector;

/**
 * model.model.Stapel
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class Stapel {

	private Vector<Karte> karten;

	public Stapel() {

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

		karten.add(new Karte("Rose", "6", 6, getClass().getResource("../cards/rosen6.gif")));
		karten.add(new Karte("Rose", "7", 7, getClass().getResource("../cards/rosen7.gif")));
		karten.add(new Karte("Rose", "8", 8, getClass().getResource("../cards/rosen8.gif")));
		karten.add(new Karte("Rose", "9", 9, getClass().getResource("../cards/rosen9.gif")));
		karten.add(new Karte("Rose", "10", 10, getClass().getResource("../cards/rosen10.gif")));
		karten.add(new Karte("Rose", "Under", 20, getClass().getResource("../cards/rosen11.gif")));
		karten.add(new Karte("Rose", "Ober", 3, getClass().getResource("../cards/rosen12.gif")));
		karten.add(new Karte("Rose", "König", 4, getClass().getResource("../cards/rosen13.gif")));
		karten.add(new Karte("Rose", "Ass", 11, getClass().getResource("../cards/rosen14.gif")));

		karten.add(new Karte("Schelle", "6", 6, getClass().getResource("../cards/schellen6.gif")));
		karten.add(new Karte("Schelle", "7", 7, getClass().getResource("../cards/schellen7.gif")));
		karten.add(new Karte("Schelle", "8", 8, getClass().getResource("../cards/schellen8.gif")));
		karten.add(new Karte("Schelle", "9", 9, getClass().getResource("../cards/schellen9.gif")));
		karten.add(new Karte("Schelle", "10", 10, getClass().getResource("../cards/schellen10.gif")));
		karten.add(new Karte("Schelle", "Under", 20, getClass().getResource("../cards/schellen11.gif")));
		karten.add(new Karte("Schelle", "Ober", 3, getClass().getResource("../cards/schellen12.gif")));
		karten.add(new Karte("Schelle", "König", 4, getClass().getResource("../cards/schellen13.gif")));
		karten.add(new Karte("Schelle", "Ass", 11, getClass().getResource("../cards/schellen14.gif")));

		karten.add(new Karte("Schilten", "6", 6, getClass().getResource("../cards/schilten6.gif")));
		karten.add(new Karte("Schilten", "7", 7, getClass().getResource("../cards/schilten7.gif")));
		karten.add(new Karte("Schilten", "8", 8, getClass().getResource("../cards/schilten8.gif")));
		karten.add(new Karte("Schilten", "9", 9, getClass().getResource("../cards/schilten9.gif")));
		karten.add(new Karte("Schilten", "10", 10, getClass().getResource("../cards/schilten10.gif")));
		karten.add(new Karte("Schilten", "Under", 20, getClass().getResource("../cards/schilten11.gif")));
		karten.add(new Karte("Schilten", "Ober", 3, getClass().getResource("../cards/schilten12.gif")));
		karten.add(new Karte("Schilten", "König", 4, getClass().getResource("../cards/schilten13.gif")));
		karten.add(new Karte("Schilten", "Ass", 11, getClass().getResource("../cards/schilten14.gif")));
	}

	public Karte zufaelligeKarte() {

		int wert = (int) Math.random() * karten.size();

		Karte temp = karten.get(wert);
		karten.remove(wert);

		return temp;
	}

	public ImageIcon getObersteKarte() {

		ImageIcon imageIcon = new ImageIcon(karten.get(0).getPfad());
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		return imageIcon;
	}

	public ImageIcon getBackside() {

		URL url = getClass().getResource("../cards/back.jpg");

		ImageIcon imageIcon = new ImageIcon(url);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		return imageIcon;
	}

	/* Zum Debugen (gibt den Pfad aller Karten aus:
	public static void main(String[] args) {


		Stapel spielstapel = new Stapel();
		spielstapel.print();
	}

	public void print() {
		for (Karte karte : karten) {
			System.out.println(karte.getPfad());
		}
	}
	*/

	public Vector<Karte> getKarten() {

		return karten;
	}
}
