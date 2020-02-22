package fr.thetilerteam.test;

import static org.junit.Assert.assertTrue;

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
	void testPiocherTestPaquet() {
		Carte c = p.piocher();
		assertTrue("Problème de carte / de pioche", c.getTypeCarte() == 'B' || c.getTypeCarte() == 'R'
				|| c.getTypeCarte() == '1' || c.getTypeCarte() == '2' || c.getTypeCarte() == '3');
	}

	@Test
	void testGetCartesEcarteesEtTestAjouteCarteEcartee() {
		p.ajouteCarteEcartee();
		assertTrue("Problème lorsque les cartes sont écartées", p.getCartesEcartees() == 1);
	}

}
