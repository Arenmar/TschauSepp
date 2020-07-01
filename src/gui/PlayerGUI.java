package gui;

import model.Karte;
import model.Spiel;
import model.Spieler;

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
	private LegenerrorGUI legenerrorGUI;

	private int index;

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
		buttonPanel = new JPanel(new GridLayout(4, 1));

		legen = new JButton("Legen");
		legen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (spiel.checkMove(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex())) {
					spiel.spieleKarte(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex());
					if (onSepp()) {
						spiel.beendeSpiel(spiel.getEinzelnerSpieler());
					}
					spiel.setNextPlayer();
				} else {
					legenerrorGUI = new LegenerrorGUI(this);
				}
			}

		});

		ziehen = new JButton("Ziehen");
		ziehen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.neuesDeck();
				spiel.zieheKarten(spiel.getEinzelnerSpieler());
				onZiehen();
				spiel.beendeSpiel(spiel.getEinzelnerSpieler());
				spiel.setNextPlayer();
			}
		});

		rufeTschau = new JButton("Tschau");
		rufeTschau.setForeground(Color.RED);
		rufeTschau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rufeTschau.setForeground(Color.GREEN);
			}
		});

		rufeSepp = new JButton("Sepp");
		rufeSepp.setForeground(Color.RED);
		rufeSepp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSepp();
			}
		});

		name = new JLabel(spiel.getAlleSpieler().get(index).getName());

		defaultListModel = new DefaultListModel();
		kartenListe = new JList(defaultListModel);
		kartenListe.setVisibleRowCount(1);
		kartenListe.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		scrollPane = new JScrollPane(kartenListe);
		scrollPane.setPreferredSize(new Dimension(370, 250));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		for (Karte karte : spiel.getAlleSpieler().get(index).getHand()) {
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

	@Override
	public void update(Observable o, Object arg) {

		defaultListModel.removeAllElements();
		for (Karte karte : spiel.getAlleSpieler().get(index).getHand()) {
			ImageIcon imageIcon = new ImageIcon(karte.getPfad());
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			defaultListModel.addElement(imageIcon);
		}
		kartenListe.updateUI();
	}

	public void renderPlayerGUI() {
		mainPanel.setBackground(Color.RED);
		legen.setEnabled(true);
		rufeTschau.setEnabled(spiel.getEinzelnerSpieler().getHand().size() == 2);
		rufeSepp.setEnabled(spiel.getEinzelnerSpieler().getHand().size() == 1);
		ziehen.setEnabled(spiel.checkPlayable(spiel.getEinzelnerSpieler()));
		repaint();
	}

	public void unrenderPlayerGUI() {
		mainPanel.setBackground(null);
		legen.setEnabled(false);
		rufeTschau.setEnabled(false);
		rufeSepp.setEnabled(false);
		ziehen.setEnabled(false);
		repaint();
	}

	public void onZiehen() {

		defaultListModel.removeAllElements();
		for (Karte karte : spiel.getAlleSpieler().get(index).getHand()) {
			ImageIcon imageIcon = new ImageIcon(karte.getPfad());
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(150, 225, Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			defaultListModel.addElement(imageIcon);
		}
	}

	private Boolean onSepp() {
		rufeSepp.setForeground(Color.GREEN);
		return true;
	}
}
