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
 * @Date: 28 -06-2020
 */
public class PlayerGUI extends JPanel implements Observer {

	private final Spiel spiel;
	private final int index;
	private final JPanel mainPanel;
	private final JPanel kartenPanel;
	private final JPanel buttonPanel;
	private final JButton legen;
	private final JButton ziehen;
	private final JButton rufeTschau;
	private final JButton rufeSepp;
	private final JLabel name;
	private final JScrollPane scrollPane;
	private final JList kartenListe;
	private final DefaultListModel defaultListModel;

	/**
	 * Instantiates a new Player gui.
	 *
	 * @param index the index
	 * @param spiel the spiel
	 */
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
			public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException {
				onLegen();
			}
		});

		ziehen = new JButton("Ziehen");
		ziehen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				spiel.neuesDeck();
				spiel.zieheKarten(spiel.getEinzelnerSpieler());
				onZiehen();
				spiel.setNextPlayer();
			}
		});

		rufeTschau = new JButton("Tschau");
		rufeTschau.setBackground(Color.RED);
		rufeTschau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onTschau(e);
			}
		});

		rufeSepp = new JButton("Sepp");
		rufeSepp.setBackground(Color.RED);
		rufeSepp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onSepp(e);
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

	/**
	 * Initializes elements of a PlayerGUI.
	 */
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

	/**
	 * Activates Buttons of a PlayerGUI and changes Color of the current Player.
	 */
	public void renderPlayerGUI() {

		mainPanel.setBackground(Color.RED);
		legen.setEnabled(true);
		rufeTschau.setEnabled(spiel.getEinzelnerSpieler().getHand().size() == 2);
		rufeSepp.setEnabled(spiel.getEinzelnerSpieler().getHand().size() == 1);
		ziehen.setEnabled(!spiel.checkPlayable(spiel.getEinzelnerSpieler()));
		repaint();
	}

	/**
	 * Deactivates Buttons of a PlayerGUI and changes Color to the next current Player.
	 */
	public void unrenderPlayerGUI() {

		mainPanel.setBackground(null);
		legen.setEnabled(false);
		rufeTschau.setEnabled(false);
		rufeSepp.setEnabled(false);
		ziehen.setEnabled(false);
		repaint();
	}

	/**
	 * Is activated when "legen" is pressed.
	 */
	public void onLegen() {

		try {
			if (spiel.checkMove(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex())) {

				if (!spiel.getEinzelnerSpieler().isHatSepp() && spiel.getEinzelnerSpieler().getHand().size() == 1) {

					spiel.spieleKarte(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex());

					for (int i = 0; i < 4; i++) {
						spiel.zieheKarten(spiel.getEinzelnerSpieler());
						onZiehen();
					}

					spiel.getEinzelnerSpieler().setHatSepp(false);
					spiel.setNextPlayer();
					rufeTschau.setBackground(Color.RED);

				} else if (spiel.getEinzelnerSpieler().isHatSepp()) {

					spiel.beendeSpiel(spiel.getEinzelnerSpieler());

				} else if (!spiel.getEinzelnerSpieler().isHatTschau() && spiel.getEinzelnerSpieler().getHand().size() == 2) {

					spiel.spieleKarte(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex());

					for (int i = 0; i < 2; i++) {
						spiel.zieheKarten(spiel.getEinzelnerSpieler());
						onZiehen();
					}

					spiel.getEinzelnerSpieler().setHatTschau(false);
					spiel.setNextPlayer();
					rufeTschau.setBackground(Color.RED);

				}  else if (spiel.getEinzelnerSpieler().isHatTschau() && spiel.getEinzelnerSpieler().getHand().size() == 2) {

					spiel.spieleKarte(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex());
					spiel.getEinzelnerSpieler().setHatTschau(false);
					spiel.setNextPlayer();
					rufeTschau.setBackground(Color.RED);

				} else {

					spiel.spieleKarte(spiel.getEinzelnerSpieler(), kartenListe.getSelectedIndex());
					spiel.setNextPlayer();
					rufeTschau.setBackground(Color.RED);
				}

			} else {
				LegenErrorGUI legenerrorGUI = new LegenErrorGUI(this);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			KeineKarteErrorGUI keineKarteErrorGUI = new KeineKarteErrorGUI(this);
		}
	}


	/**
	 * Is activated when "ziehen" is pressed.
	 */
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

	/**
	 * Is activated when "Tschau" is pressed.
	 *
	 * @Param e the ActionEvent
	 */
	private void onTschau(ActionEvent e) {
		rufeTschau.setBackground(Color.GREEN);
		spiel.getEinzelnerSpieler().setHatTschau(true);
	}

	/**
	 * Is activated when "Sepp" is pressed.
	 *
	 * @Param e the ActionEvent
	 */
	private void onSepp(ActionEvent e) {
		rufeSepp.setBackground(Color.GREEN);
		spiel.getEinzelnerSpieler().setHatSepp(true);
	}
}
