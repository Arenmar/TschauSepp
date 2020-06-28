package gui;

import model.Karte;
import model.Spiel;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * gui.PlayerGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 28-06-2020
 */

public class PlayerGUI extends JPanel {

	private Spiel spiel;
	private int index;

	private JPanel mainPanel, kartenPanel, buttonPanel;

	private JButton legen, ziehen, rufeTschau, rufeSepp;

	private JLabel punkte, name, karte;

	private JScrollPane scrollPane;

	private JList cardList;

	private Vector<Karte> karten;

	private DefaultListModel defaultListModel;

	public PlayerGUI(Spiel spiel, int index) {

		this.spiel = spiel;
		this.index = index;

		mainPanel = new JPanel(new BorderLayout());
		kartenPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(4,1));

		legen = new JButton("Legen");
		ziehen = new JButton("Ziehen");
		rufeTschau = new JButton("Tschau");
		rufeSepp = new JButton("Sepp");

		punkte = new JLabel();
		name = new JLabel();
		karte = new JLabel();

		defaultListModel = new DefaultListModel();
		cardList = new JList(defaultListModel);

		for (Karte karte : spiel.getSpieler().get(index).getKarten()) {

			ImageIcon imageIcon = new ImageIcon(karte)
		}
	}
}
