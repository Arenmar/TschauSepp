package gui;

import model.Karte;
import model.Spiel;
import model.Spieler;
import model.Stapel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private boolean istAktuellerSpieler;

	private JPanel mainPanel, kartenPanel, buttonPanel;

	private JButton legen, ziehen, rufeTschau, rufeSepp;

	private JLabel punkte, name;

	private JScrollPane scrollPane;

	private JList kartenListe;

	private DefaultListModel defaultListModel;

	public PlayerGUI(int index, Spiel spiel, int spielerCntr) {

		this.index = index;

		mainPanel = new JPanel(new BorderLayout());
		kartenPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(4,1));

		legen = new JButton("Legen");

		ziehen = new JButton("Ziehen");
		ziehen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.spieleKarte(spiel.getSpieler().get(spielerCntr), kartenListe.getSelectedIndex());
				nextPlayer(spiel.getSpieler(), spielerCntr);
			}
		});

		rufeTschau = new JButton("Tschau");
		rufeSepp = new JButton("Sepp");

		punkte = new JLabel(String.valueOf(spiel.getSpieler().get(index).getPunkte()));

		name = new JLabel(spiel.getSpieler().get(index).getName());
		if (spiel.getSpieler().get(spielerCntr).isAktuellerSpieler()) {
			name.setForeground(Color.GREEN);
		} else {
			name.setForeground(Color.BLACK);
		}

		defaultListModel = new DefaultListModel();
		kartenListe = new JList(defaultListModel);
		kartenListe.setVisibleRowCount(1);
		kartenListe.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		scrollPane = new JScrollPane(kartenListe);
		scrollPane.setPreferredSize(new Dimension(370,250));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		for (Karte karte : spiel.getSpieler().get(index).getHand()) {
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

		buttonPanel.add(legen);
		buttonPanel.add(ziehen);
		buttonPanel.add(rufeTschau);
		buttonPanel.add(rufeSepp);
	}

	public void setSpielerfarbe(Spiel spiel, int spielerCntr) {

		spiel.getSpieler().get(0).setAktuellerSpieler(true);
		if (spiel.getSpieler().get(0).isAktuellerSpieler()) {
			name.setForeground(Color.GREEN);
		} else {
			name.setForeground(Color.BLACK);
		}
	}

	private void nextPlayer(Vector<Spieler> spielerListe, int spielerCntr) {
		if (!(spielerCntr == spielerListe.size() - 1)) {
			spielerCntr++;
		}
	}
}
