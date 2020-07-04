package gui;

import model.Spiel;
import model.Spieler;
import model.Stapel;

import javax.swing.*;
import java.awt.*;

/**
 * gui.GameGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27 -06-2020
 */
public class GameGUI extends JFrame {

	private Spiel spiel;
	private WinnerGUI winnerGUI;

	private JPanel mainPanel, kartenPanel, spielstapelPanel, ablagestapelPanel;

	private JLabel obersteKarte, backside;

	/**
	 * Instantiates a new Game gui.
	 *
	 * @param spiel the spiel
	 */
	public GameGUI(Spiel spiel) {

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.spiel = spiel;

		mainPanel = new JPanel();
		kartenPanel = new JPanel();
		spielstapelPanel = new JPanel();
		ablagestapelPanel = new JPanel();

		obersteKarte = new JLabel();
		backside = new JLabel();

		playerSetup(spiel);
		init();
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Initializes elements of the GameGUI.
	 */
	public void init() {

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3, 3));
		kartenPanel.setLayout(new GridLayout(1, 2));

		kartenPanel.add(ablagestapelPanel);
		ablagestapelPanel.setBackground(Color.RED);
		ablagestapelPanel.setLayout(new BorderLayout());
		ablagestapelPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
		ablagestapelPanel.add(obersteKarte, BorderLayout.CENTER);
		karteAnzeigen();

		kartenPanel.add(spielstapelPanel);
		spielstapelPanel.setBackground(Color.BLACK);
		spielstapelPanel.setLayout(new BorderLayout());
		spielstapelPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0));
		spielstapelPanel.add(backside, BorderLayout.CENTER);
		backside.setIcon(getBackside());
	}

	/**
	 * Creates the PlayerGUIs.
	 *
	 * @param spiel the game
	 */
	public void playerSetup(Spiel spiel) {

		switch (spiel.getAlleSpieler().size()) {
			case 1:
				mainPanel.add(new JPanel());
				PlayerGUI gui1 = new PlayerGUI(0, spiel);
				mainPanel.add(gui1);
				spiel.addPlayerGUIs(gui1);
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
				PlayerGUI gui21 = new PlayerGUI(0, spiel);
				mainPanel.add(gui21);
				spiel.addPlayerGUIs(gui21);
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				PlayerGUI gui22 = new PlayerGUI(1, spiel);
				mainPanel.add(gui22);
				spiel.addPlayerGUIs(gui22);
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				break;
			case 3:
				mainPanel.add(new JPanel());
				PlayerGUI gui31 = new PlayerGUI(0, spiel);
				mainPanel.add(gui31);
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				PlayerGUI gui32 = new PlayerGUI(2, spiel);
				mainPanel.add(gui32);
				mainPanel.add(new JPanel());
				PlayerGUI gui33 = new PlayerGUI(1, spiel);
				mainPanel.add(gui33);
				mainPanel.add(new JPanel());
				spiel.addPlayerGUIs(gui31);
				spiel.addPlayerGUIs(gui33);
				spiel.addPlayerGUIs(gui32);
				break;
			case 4:
				mainPanel.add(new JPanel());
				PlayerGUI gui41 = new PlayerGUI(0, spiel);
				mainPanel.add(gui41);
				mainPanel.add(new JPanel());
				PlayerGUI gui42 = new PlayerGUI(3, spiel);
				mainPanel.add(gui42);
				mainPanel.add(kartenPanel);
				PlayerGUI gui43 = new PlayerGUI(1, spiel);
				mainPanel.add(gui43);
				mainPanel.add(new JPanel());
				PlayerGUI gui44 = new PlayerGUI(2, spiel);
				mainPanel.add(gui44);
				mainPanel.add(new JPanel());
				spiel.addPlayerGUIs(gui41);
				spiel.addPlayerGUIs(gui43);
				spiel.addPlayerGUIs(gui44);
				spiel.addPlayerGUIs(gui42);
				break;
		}
	}

	/**
	 * Gets backside of a card.
	 *
	 * @return the backside
	 */
	public ImageIcon getBackside() {

		Stapel stapel = new Stapel();

		return stapel.getBackside();
	}

	/**
	 * Loads an image of a card.
	 */
	public void karteAnzeigen() {

		ImageIcon imageIcon = new ImageIcon(spiel.getAblagestapel().zuletztGelegteKarteURL());
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);

		obersteKarte.setIcon(imageIcon);
	}

	/**
	 * Ends the game.
	 *
	 * @param spieler the player
	 */
	public void spielende(Spieler spieler) {

		winnerGUI = new WinnerGUI(spieler, getSize());
		setVisible(false);
	}
}