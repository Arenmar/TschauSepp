package gui;

import model.Karte;
import model.Spiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * gui.PlayerGUI
 *
 * @Author: Martin Arendar
 * @Version: 1.0
 * @Date: 28-06-2020
 */

public class PlayerGUI extends JPanel implements Observer {

	private Spiel spiel;
	private int index;

	private boolean istAktuellerSpieler;

	private JPanel mainPanel, kartenPanel, buttonPanel;

	private JButton legen, ziehen, rufeTschau, rufeSepp;

	private JLabel name;

	private JScrollPane scrollPane;

	private JList kartenListe;

	private DefaultListModel defaultListModel;

	public PlayerGUI(int index, Spiel spiel) {

		this.index = index;

		this.spiel = spiel;

		spiel.addObserver(this);

		mainPanel = new JPanel(new BorderLayout());
		kartenPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(4,1));

		legen = new JButton("Legen");
		legen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.ersterSpieler(0);
				spiel.spieleKarte(spiel.getAktuellerSpieler(), kartenListe.getSelectedIndex());
				spiel.setNextPlayer(spiel.getAktuellerSpieler());
			}
		});

		ziehen = new JButton("Ziehen");
		ziehen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.zieheKarten(spiel.getAktuellerSpieler());
			}
		});

		rufeTschau = new JButton("Tschau");
		rufeSepp = new JButton("Sepp");

		name = new JLabel(spiel.getSpieler().get(index).getName());

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

	@Override
	public void update(Observable o, Object arg) {

		defaultListModel.removeAllElements();
		for (Karte karte : spiel.getSpieler().get(index).getHand()) {
			ImageIcon imageIcon = new ImageIcon(karte.getPfad());
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			defaultListModel.addElement(imageIcon);
		}
		kartenListe.updateUI();
	}
}
