package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpielTest {

	@Test
	public void getName() {
		Spieler spieler = new Spieler("Martin");
		assertEquals("Martin", spieler.getName());
	}
}