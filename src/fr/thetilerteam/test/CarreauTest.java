package fr.thetilerteam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carreau;
import fr.thetilerteam.logique.Couleur;

class CarreauTest {

	private static Carreau c;

	@BeforeEach
	void setUp() {
		c = new Carreau(1, 1, 't', Couleur.BLEU);
	}

	@Test
	void testNegatif() {
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(1, -1, 't', Couleur.BLEU);
		}, "Problème de gestion du négatif dans la déclaration carreaux");

		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(-1, 1, 't', Couleur.BLEU);
		}, "Problème de gestion du négatif dans la déclaration carreaux");
	}

	@Test
	void testNull() {
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(1, 0, 't', Couleur.BLEU);
		}, "Problème de gestion du null dans la déclaration carreaux");

		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(0, 1, 't', Couleur.BLEU);
		}, "Problème de gestion du null dans la déclaration carreaux");
	}

	@Test
	void testGetHauteur() {
		assertEquals("Problème getHauteur ", 1, c.getHauteur());
	}

	@Test
	void testGetLargeur() {
		assertEquals("Problème getLargeur ", 1, c.getLargeur());
	}

	@Test
	void testGetLettre() {
		assertEquals("Problème getLettre " + c.getLettre(), c.getLettre(), 't');
	}

	@Test
	void testGetCouleur() {
		assertEquals("Problème getLettre " + c.getCouleur(), c.getCouleur(), Couleur.BLEU);
	}

	@Test
	void testCarreauTailleN() {
		assertTrue("Problème carreauTailleN", c.carreauTailleN(1));

		Assertions.assertThrows(AssertionError.class, () -> {
			c.carreauTailleN(-1);
		}, "Problème de gestion du négatif dans CarreauTailleN");

		Assertions.assertThrows(AssertionError.class, () -> {
			c.carreauTailleN(0);
		}, "Problème de gestion du null dans CarreauTailleN");
	}

}
