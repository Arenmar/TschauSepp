package gui;

import javax.swing.*;
import java.awt.*;

/**
 * gui.ErrorGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 28 -06-2020
 */
public class ErrorGUI extends JDialog {

	private JPanel mainPanel;

	private JLabel message;

	private GridBagConstraints gbc;

	/**
	 * Instantiates a new Error gui.
	 *
	 * @param parent the parent
	 */
	public ErrorGUI(JFrame parent) {

		init();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initializes elements of the ErrorGUI.
	 */
	public void init() {

		mainPanel = new JPanel();

		message = new JLabel("Bitte einen Namen eingeben");

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(1,1,1,1);

		getContentPane().add(mainPanel);

		mainPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(message);
	}
}

