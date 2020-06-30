package gui;

import javax.swing.*;
import java.awt.*;

/**
 * gui.ZuWenigSpielerError
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 01-07-2020
 */

public class ZuWenigSpielerError extends JDialog {

	private JLabel message;

	private GridBagConstraints gbc;

	private JPanel mainPanel;

	public ZuWenigSpielerError(JFrame parent) {

		init();
		pack();
		centerFrame();
		setVisible(true);
	}

	public void init() {

		mainPanel = new JPanel();

		message = new JLabel("Bitte mindestens 1 Spieler hinzufügen");

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(1,1,1,1);

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(message);
	}

	public void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}
}
