package gui;

import model.Spiel;
import model.Spieler;
import model.Stapel;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
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
	private int spielerCntr;

	private JPanel mainPanel, kartenPanel, spielstapelPanel, ablagestapelPanel;

	private JLabel obersteKarte, backside;

	public GameGUI (JFrame parent, Spiel spiel) {

		spielerCntr = 0;

		this.spiel = spiel;

		mainPanel = new JPanel();
		kartenPanel = new JPanel();
		spielstapelPanel = new JPanel();
		ablagestapelPanel = new JPanel();

		obersteKarte = new JLabel();
		backside = new JLabel();

		playerSetup(spiel);
		init();
		gameSetup();
		pack();
		setResizable(false);
		setVisible(true);
	}

	public void init() {

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3,3));
		kartenPanel.setLayout(new GridLayout(1,2));

		kartenPanel.add(ablagestapelPanel);
		ablagestapelPanel.setBackground(Color.RED);
		ablagestapelPanel.setLayout(new BorderLayout());
		ablagestapelPanel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
		ablagestapelPanel.add(obersteKarte, BorderLayout.CENTER);
		obersteKarte.setIcon(gameSetup());

		kartenPanel.add(spielstapelPanel);
		spielstapelPanel.setBackground(Color.BLACK);
		spielstapelPanel.setLayout(new BorderLayout());
		spielstapelPanel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
		spielstapelPanel.add(backside, BorderLayout.CENTER);
		backside.setIcon(getBackside());
	}

	public void playerSetup(Spiel spiel) {

		switch (spiel.getSpieler().size()) {
			case 1:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spiel, spielerCntr));
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
				mainPanel.add(new PlayerGUI(0, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(1, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				break;
			case 3:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(1, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(2, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				break;
			case 4:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(1, spiel, spielerCntr));
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(2, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(3, spiel, spielerCntr));
				mainPanel.add(new JPanel());
				break;
		}
	}

	public ImageIcon gameSetup() {

		Stapel stapel = new Stapel();

		return stapel.getObersteKarteIcon();
	}

	public ImageIcon getBackside() {

		Stapel stapel = new Stapel();

		return stapel.getBackside();
	}

	public void karteAnzeigen() {

		ImageIcon imageIcon = new ImageIcon(spiel.getAblagestapel().zuletztGelegteKarte());
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		obersteKarte.setIcon(imageIcon);
	}
}