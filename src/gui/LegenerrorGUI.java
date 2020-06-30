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
		centerFrame();
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

	public void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}
}
