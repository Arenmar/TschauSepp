package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * gui.KeineKarteErrorGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 01 -07-2020
 */
public class LegenErrorGUI extends JDialog {

	private JPanel mainPanel;

	private JLabel message;

	private GridBagConstraints gbc;

	/**
	 * Instantiates a new LegenError gui.
	 *
	 * @param parent the parent
	 */
	public LegenErrorGUI(PlayerGUI parent) {

		init();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initializes elements of the LegenErrorGUI.
	 */
	public void init() {

		mainPanel = new JPanel();

		message = new JLabel("Die ausgewählte Karte kann nicht gelegt werden");

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(1,1,1,1);

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(message);
	}
}
