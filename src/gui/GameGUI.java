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

	private JPanel mainPanel, kartenPanel;

	public GameGUI (JFrame parent, Spiel spiel, Vector<Spieler> spielerVector) {

		legen = new JButton();
		ziehen = new JButton();
		aussetzen = new JButton();
		rufeTschau = new JButton();
		rufeSepp = new JButton();

		mainPanel = new JPanel();
		kartenPanel = new JPanel();
		kartenPanel.setBackground(Color.CYAN);

		init();

		switch (spielerVector.size()) {
			case 1:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector));
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
				mainPanel.add(new PlayerGUI(0, spielerVector));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(1, spielerVector));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				break;
			case 3:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector));
				mainPanel.add(new JPanel());
				mainPanel.add(new JPanel());
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(1, spielerVector));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(2, spielerVector));
				mainPanel.add(new JPanel());
				break;
			case 4:
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(0, spielerVector));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(1, spielerVector));
				mainPanel.add(kartenPanel);
				mainPanel.add(new PlayerGUI(2, spielerVector));
				mainPanel.add(new JPanel());
				mainPanel.add(new PlayerGUI(3, spielerVector));
				mainPanel.add(new JPanel());
				break;
		}

		pack();
		setVisible(true);
	}

	public void init() {
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3,3));
	}
}
