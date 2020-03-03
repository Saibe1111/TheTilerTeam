package fr.thetilerteam.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carte;
import fr.thetilerteam.logique.Paquet;

class PaquetTest {

	private static Paquet p;

	@BeforeEach
	void setUp() {
		p = new Paquet();
	}

	@Test
	void testPaquetVide() throws Exception {
		Carte c;
		for (int i = 0; i < 33; ++i)
			c = p.piocher();
		Assertions.assertThrows(Exception.class, () -> {
			Carte c1 = p.piocher();
		}, "Problème Paquet vide");

	}

	@Test
	void testGetCartesEcarteesEtTestAjouteCarteEcartee() {
		p.ajouteCarteEcartee();
		assertTrue("Problï¿½me lorsque les cartes sont ï¿½cartï¿½es", p.getCartesEcartees() == 1);
	}

}
