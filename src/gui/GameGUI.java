package gui;

import model.Spiel;
import model.Spieler;

import javax.swing.*;
import java.awt.*;

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

	public GameGUI(JFrame parent, Spiel spiel, Spieler spieler) {

		legen = new JButton();
		ziehen = new JButton();
		aussetzen = new JButton();
		rufeTschau = new JButton();
		rufeSepp = new JButton();

		mainPanel = new JPanel();

		init();
		setSize(500,500);
		setVisible(true);
	}

	public void init() {
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3,3));

	}
}
