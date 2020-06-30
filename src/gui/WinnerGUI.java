package gui;

import model.Spieler;

import javax.swing.*;
import java.awt.*;

/**
 * gui.WinnerGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 30-06-2020
 */

public class WinnerGUI extends JFrame {

	private JLabel message;

	private GridBagConstraints gbc;

	private JPanel mainPanel;

	public WinnerGUI(Spieler spieler, Dimension sizeGameWindow) {

		super("Gewinner");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		init(spieler);
		setSize(sizeGameWindow);
		centerFrame();
		setVisible(true);
	}

	public void init(Spieler spieler) {

		message = new JLabel("Der Gewinner ist: " + spieler.getName());

		gbc = new GridBagConstraints();
		gbc.insets = new Insets(1,1,1,1);

		mainPanel = new JPanel();

		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(message, gbc);
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
