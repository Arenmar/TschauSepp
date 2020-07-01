package gui;

import javax.swing.*;
import java.awt.*;

/**
 * gui.KeineKarteErrorGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 01 -07-2020
 */
public class KeineKarteErrorGUI extends JDialog {

	private JPanel mainPanel;

	private JLabel message;

	/**
	 * Instantiates a new KeineKarteError gui.
	 *
	 * @param parent the parent
	 */
	public KeineKarteErrorGUI(PlayerGUI parent) {

		init();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initializes elements of the KeineKarteErrorGUI.
	 */
	public void init() {

		mainPanel = new JPanel();

		message = new JLabel("Keine Karte zum Legen ausgewählt");

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(message);
	}
}
