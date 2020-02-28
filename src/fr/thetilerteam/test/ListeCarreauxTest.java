package fr.thetilerteam.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.ListeCarreaux;

class ListeCarreauxTest {

	private static ListeCarreaux lc;

	@BeforeEach
	void setUp() {
		lc = new ListeCarreaux();
	}

	@Test
	void testListeCarreauxEtTestGetCarreau() {
		assertTrue("Liste de carreau mal initialisé (hauteur)", lc.getCarreau(0).getHauteur() == 1);
		assertTrue("Liste de carreau mal initialisé (hauteur)", lc.getCarreau(6).getHauteur() == 2);

		assertTrue("Liste de carreau mal initialisé (largeur)", lc.getCarreau(0).getLargeur() == 1);
		assertTrue("Liste de carreau mal initialisé (largeur)", lc.getCarreau(6).getLargeur() == 2);

		assertTrue("Liste de carreau mal initialisé (lettre)", lc.getCarreau(0).getLettre() == 'a');
		assertTrue("Liste de carreau mal initialisé (lettre)", lc.getCarreau(6).getLettre() == 'd');
		assertTrue("Liste de carreau mal initialisé (lettre)", lc.getCarreau(1).getLettre() == 'A');
		assertTrue("Liste de carreau mal initialisé (lettre)", lc.getCarreau(7).getLettre() == 'D');
	}

	@Test
	void testNbCarreaux() {
		assertTrue("Problème dans le nombre de carreaux", lc.nbCarreaux() == 18);
	}

	@Test
	void testRetirerCareauListe() {
		lc.retirerCareauListe('a');
		assertFalse("Carreau mal retiré", lc.getCarreau(0).getLettre() == 'a');
		assertTrue("Problème dans le nombre de carreaux", lc.nbCarreaux() == 17);
	}

}
