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
 * @Date: 27-06-2020
 */

public class StartGUI extends JFrame {

	private Spiel spiel;
	private GameGUI gameGUI;
	private ErrorGUI errorGUI;
	private ZuWenigSpielerError zuWenigSpielerError;

	private JTextField name;

	private JButton spielerHinzufuegen, spielStarten;

	private JPanel mainPanel, spielerHinzufuegenPanel, alleSpielerPanel;

	public StartGUI(Spiel spiel) {

		super("Tschau Sepp");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.spiel = spiel;

		init();
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void init() {

		mainPanel = new JPanel();
		spielerHinzufuegenPanel = new JPanel();
		alleSpielerPanel = new JPanel();

		name = new JTextField();

		spielerHinzufuegen = new JButton("+");
		spielerHinzufuegen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSpielerHinzufuegen(e);
			}
		});

		spielStarten = new JButton("Start");
		spielStarten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSpielStarten(e);
			}
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

	public void onSpielerHinzufuegen(ActionEvent e) {

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

		/* Zum Debuggen, gibt Namen aller Spieler im Spielervector aus
		int i = 0;
		System.out.println(spiel.getSpieler().get(i).getName());
		i++;
		*/
	}

	public void onSpielStarten(ActionEvent e) {

		if (spiel.getAlleSpieler().size() > 0) {
			gameGUI = new GameGUI(spiel);
			spiel.setGameGUI(gameGUI);
			spiel.activatePlayerGUI();
			setVisible(false);
		} else {
			zuWenigSpielerError = new ZuWenigSpielerError(this);
		}
	}
}
