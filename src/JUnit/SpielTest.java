package JUnit;

import app.TSApp;
import gui.GameGUI;
import gui.PlayerGUI;
import gui.StartGUI;
import model.Karte;
import model.Spiel;
import model.Spieler;
import model.Stapel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpielTest {

	private TSApp app;
	private Spiel spiel;
	private Spieler spieler;
	private StartGUI startGUI;
	private Stapel stapel;
	private PlayerGUI playerGUI;
	private GameGUI gameGUI;

	@Before
	public void starteSpiel() {

		spiel = new Spiel();

		startGUI = new StartGUI(spiel);

		gameGUI = new GameGUI(spiel);

		spiel.setSpieler(new Spieler("Testspieler"));

		playerGUI = new PlayerGUI(spiel.getAlleSpieler().size(), spiel);
	}

	@Test
	public void JT1() {
		spieler = new Spieler("Martin");
		Assert.assertEquals("Martin", spieler.getName());
	}

	@Test
	public void JT2() {
		spieler = new Spieler("Martinnnnnnnnnnnnnnnn");

	}

	/*
	@Test
	public void JT3() {
		int temp1;
		int temp2;

		Karte karte1 = new Karte(6, "Eichel", "6", getClass().getResource("../Cards/eichel6.gif"));
		Karte karte2 = new Karte(7, "Rose", "7", getClass().getResource("../Cards/rosen7.gif"));

		playerView = gameview.getCurrentPlayerPlayerView();

		gameview.getRound().setLastPlayedCard(card2);
		playerView.getPlayer().removeAllCards();
		playerView.getPlayer().addCard(card1);

		temp1 = playerView.getPlayer().getCardsSize();

		playerView.loadCards();

		playerView.getCardJList().setSelectedIndex(1);

		playerView.layCard();

		temp2 = playerView.getPlayer().getCardsSize();

		Assert.assertEquals(temp1, temp2);
	}
	*/

	@Test
	public void JT5() {

		startGUI.setNameText("Testspieler");

		startGUI.onSpielerHinzufuegen();

		startGUI.onSpielStarten();

		Karte karte1 = new Karte("Schilten", "6", 6, getClass().getResource("../cards/schilten6.gif"));
		Karte karte2 = new Karte("Eichel", "7", 7, getClass().getResource("../cards/eichel7.gif"));

		spiel.getEinzelnerSpieler();

		spiel.setZuletztGelegteKarte(karte2);
		spiel.getEinzelnerSpieler().entferneAlleKarten();
		spiel.getEinzelnerSpieler().fuegeKarteZuHandHinzu(karte1);

		int temp1 = spiel.getEinzelnerSpieler().getHand().size();

		playerGUI.loadImages();
		playerGUI.onZiehen();

		System.out.println(spiel.getEinzelnerSpieler().getHand().size());

		int temp2 = spiel.getEinzelnerSpieler().getHand().size();

		Assert.assertEquals(temp1 + 1, temp2);

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

		}
	}

	@Test
	public void JT9() {

		Karte karte1 = new Karte("Schilten", "6", 6, getClass().getResource("../cards/schilten6.gif"));
		Karte karte2 = new Karte("Eichel", "7", 7, getClass().getResource("../cards/eichel7.gif"));

		spiel.checkPlayable(spiel.getEinzelnerSpieler());
		

	}
}