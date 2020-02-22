package fr.thetilerteam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carreau;

class CarreauTest {

	private static Carreau c;

	@BeforeEach
	void setUp() {
		c = new Carreau(1, 1, 't');
	}

	@Test
	void testNegatif() {
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(1, -1, 't');
		}, "Problème de gestion du négatif dans la déclaration carreaux");

		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(-1, 1, 't');
		}, "Problème de gestion du négatif dans la déclaration carreaux");
	}

	@Test
	void testNull() {
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(1, 0, 't');
		}, "Problème de gestion du null dans la déclaration carreaux");

		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(0, 1, 't');
		}, "Problème de gestion du null dans la déclaration carreaux");
	}

	@Test
	void testGetHauteur() {
		assertTrue("Problème getHauteur", c.getHauteur() == 1);
	}

	@Test
	void testGetLargeur() {
		assertTrue("Problème getLargeur", c.getLargeur() == 1);
	}

	@Test
	void testGetLettre() {
		assertEquals("Problème getLettre" + c.getLettre(), c.getLettre(), 't');
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

	@Test
	void testMettreLettreEnMaj() {
		c.mettreLettreEnMaj();
		assertEquals("Problème mettreLettreEnMaj", c.getLettre(), 'T');
	}

	@Test
	void testCarteTestCarreau() {

		// 1

		c = new Carreau(1, 3, 't');
		assertTrue("Problème test taille largeur", c.carteTestCarreau('1'));

		c = new Carreau(3, 1, 't');
		assertTrue("Problème test taille hauteur", c.carteTestCarreau('1'));

		c = new Carreau(2, 3, 't');
		assertFalse("Problème test taille false", c.carteTestCarreau('1'));

		// 2

		c = new Carreau(2, 3, 't');
		assertTrue("Problème test taille largeur", c.carteTestCarreau('2'));

		c = new Carreau(3, 2, 't');
		assertTrue("Problème test taille hauteur", c.carteTestCarreau('2'));

		c = new Carreau(1, 3, 't');
		assertFalse("Problème test taille false", c.carteTestCarreau('2'));

		// 3

		c = new Carreau(3, 1, 't');
		assertTrue("Problème test taille largeur", c.carteTestCarreau('3'));

		c = new Carreau(1, 3, 't');
		assertTrue("Problème test taille hauteur", c.carteTestCarreau('3'));

		c = new Carreau(2, 1, 't');
		assertFalse("Problème test taille false", c.carteTestCarreau('3'));

		// R

		c = new Carreau(3, 1, 'T');
		assertTrue("Problème test couleur rouge", c.carteTestCarreau('R'));

		c = new Carreau(2, 1, 't');
		assertFalse("Problème test couleur rouge false", c.carteTestCarreau('R'));

		// B

		c = new Carreau(3, 1, 't');
		assertTrue("Problème test couleur bleu", c.carteTestCarreau('B'));

		c = new Carreau(2, 1, 'T');
		assertFalse("Problème test couleur bleu", c.carteTestCarreau('B'));

	}

}
