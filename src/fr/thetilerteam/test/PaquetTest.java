package fr.thetilerteam.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	void testPiocherTestPaquet() throws Exception {

	}

	@Test
	void testPaquetVide() throws Exception {
		Carte c;
		for (int i = 0; i < 33; ++i)
			c = p.piocher();
		try {
			c = p.piocher();
			fail("Paquet vide sans d�clancher l'exeption");
		} catch (Exception e) {

		}

	}

	@Test
	void testGetCartesEcarteesEtTestAjouteCarteEcartee() {
		p.ajouteCarteEcartee();
		assertTrue("Probl�me lorsque les cartes sont �cart�es", p.getCartesEcartees() == 1);
	}

}
