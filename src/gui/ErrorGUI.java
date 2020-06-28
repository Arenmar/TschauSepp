package gui;

import javax.swing.*;
import java.awt.*;

/**
 * gui.ErrorGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 28-06-2020
 */

public class ErrorGUI extends JDialog {

	private JPanel mainPanel;

	private JLabel message;

	public ErrorGUI(JFrame parent) {

		mainPanel = new JPanel();

		message = new JLabel("Bitte einen Namen eingeben");

		init();
		pack();
		setVisible(true);
	}

	public void init() {
		getContentPane().add(mainPanel);

		mainPanel.setLayout(new GridLayout(1,1));
		mainPanel.add(message);
	}
}
