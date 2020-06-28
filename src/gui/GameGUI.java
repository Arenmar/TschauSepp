package gui;

import model.Spiel;
import model.Spieler;

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

	private JPanel mainPanel;

	public GameGUI (JFrame parent, Spiel spiel, Vector<Spieler> spielerVector) {

		legen = new JButton();
		ziehen = new JButton();
		aussetzen = new JButton();
		rufeTschau = new JButton();
		rufeSepp = new JButton();

		mainPanel = new JPanel();

		init();

		for (int i = 0; i < 9; i++) {

			if (i == 0) {
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(i, spielerVector));
			} else if (i == 1) {
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(i, spielerVector));
			} else if (i == 2) {
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(i, spielerVector));
			} else if (i == 3) {
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(i, spielerVector));
				mainPanel.add(new JPanel());
			}
		}

		setSize(500,500);
		setVisible(true);
	}

	public void init() {
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3,3));

	}
}
