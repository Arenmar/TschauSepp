package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LegenerrorGUI extends JDialog {

	private JPanel mainPanel;

	private JLabel message;

	private GridBagConstraints gbc;

	public LegenerrorGUI(ActionListener parent) {

		init();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

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
