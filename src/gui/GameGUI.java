package gui;

import model.Karte;
import model.Spiel;
import model.Spieler;
import model.Stapel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * gui.GameGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27-06-2020
 */

public class GameGUI extends JDialog {

	private Spiel spiel;
	private Spieler spieler;
	private JButton legen, ziehen, aussetzen, rufeTschau, rufeSepp;

	private JPanel mainPanel, kartenPanel, spielstapelPanel, ablagestapelPanel;

	private JLabel obersteKarte, backside;

	public GameGUI (JFrame parent, Spiel spiel, Vector<Spieler> spielerVector, Stapel spielstapel) {

		legen = new JButton();
		ziehen = new JButton();
		aussetzen = new JButton();
		rufeTschau = new JButton();
		rufeSepp = new JButton();

		mainPanel = new JPanel();
		kartenPanel = new JPanel();
		spielstapelPanel = new JPanel();
		ablagestapelPanel = new JPanel();

		obersteKarte = new JLabel();
		backside = new JLabel();

		playerSetup(spielerVector, spielstapel);
		init();
		gameSetup();
		pack();
		setVisible(true);
	}

	public void init() {

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3,3));

		kartenPanel.setLayout(new GridLayout(1,2));
		kartenPanel.add(ablagestapelPanel);
		kartenPanel.add(spielstapelPanel);

		ablagestapelPanel.add(obersteKarte);

		obersteKarte.setIcon(gameSetup());

		spielstapelPanel.add(backside);

		backside.setIcon(getBackside());
	}

	public void playerSetup(Vector<Spieler> spielerVector, Stapel spielstapel) {

		switch (spielerVector.size()) {
			case 1:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				break;
			case 2:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(1, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				break;
			case 3:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(1, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(2, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				break;
			case 4:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(1, spielerVector, spielstapel));
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(2, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(3, spielerVector, spielstapel));
				mainPanel.add(new JPanel());
				break;
		}
	}

	public ImageIcon gameSetup() {

		Stapel stapel = new Stapel();

		return stapel.getObersteKarte();
	}

	public ImageIcon getBackside() {

		Stapel stapel = new Stapel();

		return stapel.getBackside();
	}
}
