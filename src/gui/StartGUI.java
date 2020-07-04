package gui;

import model.Karte;
import model.Spiel;
import model.Spieler;
import model.Stapel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * gui.StartGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 27 -06-2020
 */
public class StartGUI extends JFrame {

	private Spiel spiel;
	private GameGUI gameGUI;
	private ErrorGUI errorGUI;
	private ZuWenigSpielerError zuWenigSpielerError;

	private JTextField name;

	private JButton spielerHinzufuegen, spielStarten;

	private JPanel mainPanel, spielerHinzufuegenPanel, alleSpielerPanel;

	/**
	 * Instantiates a new Start gui.
	 *
	 * @param spiel the spiel
	 */
	public StartGUI(Spiel spiel) {

		super("Tschau Sepp");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.spiel = spiel;

		init();
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initializes elements of the StartGUI.
	 */
	public void init() {

		mainPanel = new JPanel();
		spielerHinzufuegenPanel = new JPanel();
		alleSpielerPanel = new JPanel();

		name = new JTextField(20);

		spielerHinzufuegen = new JButton("+");
		spielerHinzufuegen.addActionListener(e -> {
			onSpielerHinzufuegen();
		});

		spielStarten = new JButton("Start");
		spielStarten.addActionListener(e ->  {
			onSpielStarten();
		});

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(alleSpielerPanel, BorderLayout.CENTER);
		mainPanel.add(spielerHinzufuegenPanel, BorderLayout.NORTH);
		mainPanel.add(spielStarten, BorderLayout.SOUTH);

		alleSpielerPanel.setLayout(new GridLayout(4,1));

		spielerHinzufuegenPanel.setLayout(new BorderLayout());
		spielerHinzufuegenPanel.add(spielerHinzufuegen, BorderLayout.CENTER);
		spielerHinzufuegenPanel.add(name, BorderLayout.NORTH);
	}

	/**
	 * Is activated when "Start" is pressed.
	 *
	 * @param e the ActionEvent
	 */
	public void onSpielStarten() {

		if (spiel.getAlleSpieler().size() > 0) {
			gameGUI = new GameGUI(spiel);
			spiel.setGameGUI(gameGUI);
			spiel.activatePlayerGUI();
			setVisible(false);
		} else {
			zuWenigSpielerError = new ZuWenigSpielerError(this);
		}
	}

	/**
	 * Is activated when "+" is pressed.
	 */
	public void onSpielerHinzufuegen() {

		if (name.getText().equals("")) {
			errorGUI = new ErrorGUI(this);
		} else {
			Spieler spieler = new Spieler(name.getText());
			spiel.setSpieler(spieler);
			alleSpielerPanel.add(new JLabel(name.getText()));
			name.setText(null);
			alleSpielerPanel.revalidate();

			for (int i = 0; i < 7; i++) {
				spieler.fuegeKarteZuHandHinzu(spiel.getSpielstapel().getDeck().get(0));
				spiel.getSpielstapel().getDeck().remove(0);
				//System.out.println(austeilstapel.zufaelligeKarte().getPfad()); <-- Zum debuggen, gibt Pfad der Karten aus welche zu Spielerhand hinzugefügt werden
			}
		}
	}

	public void setNameText(String text) {
		name.setText(text);
	}
}
