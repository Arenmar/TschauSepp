package gui;

import model.Karte;
import model.Spiel;
import model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Vector;

/**
 * gui.PlayerGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 28-06-2020
 */

public class PlayerGUI extends JPanel {

	private int index;

	private JPanel mainPanel, kartenPanel, buttonPanel;

	private JButton legen, ziehen, rufeTschau, rufeSepp;

	private JLabel punkte, name, karte;

	private JScrollPane scrollPane;

	private JList kartenListe;

	private DefaultListModel defaultListModel;

	public PlayerGUI(int index, Vector<Spieler> spielerVector) {

		this.index = index;

		mainPanel = new JPanel(new BorderLayout());
		kartenPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(4,1));

		legen = new JButton("Legen");
		ziehen = new JButton("Ziehen");
		rufeTschau = new JButton("Tschau");
		rufeSepp = new JButton("Sepp");

		punkte = new JLabel(String.valueOf(spielerVector.get(index).getPunkte()));
		name = new JLabel(spielerVector.get(index).getName());
		karte = new JLabel();

		scrollPane = new JScrollPane();

		defaultListModel = new DefaultListModel();
		kartenListe = new JList(defaultListModel);

		for (Karte karte : spielerVector.get(index).getKarten()) {
			ImageIcon imageIcon = new ImageIcon(karte.getPfad());
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			defaultListModel.addElement(imageIcon);
		}

		init();
	}

	public void init() {

		this.add(mainPanel);

		mainPanel.add(kartenPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.EAST);
		mainPanel.add(name, BorderLayout.NORTH);
		mainPanel.add(punkte, BorderLayout.SOUTH);

		kartenPanel.add(scrollPane);
		scrollPane.add(kartenListe);

		buttonPanel.add(legen);
		buttonPanel.add(ziehen);
		buttonPanel.add(rufeTschau);
		buttonPanel.add(rufeSepp);
	}
}
