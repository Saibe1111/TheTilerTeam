package fr.thetilerteam.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carreau;

class CarreauTest {

	private static Carreau c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Carreau(1, 1, 't');

	}

	@Test
	void testNegatif() {
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(1, -1, 't');
		});

		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(-1, 1, 't');
		});
	}

	@Test
	void testNull() {
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(0, 1, 't');
		});
		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(1, 0, 't');
		});

		Assertions.assertThrows(AssertionError.class, () -> {
			c = new Carreau(0, 1, 't');
		}, "Problème de gestion du null dans la déclaration carreaux");
	}

	@Test
	void testGetHauteur() {
		assertTrue("Problème GetHauteur", c.getHauteur() == );
	}

	@Test
	void testGetLargeur() {
	}

	@Test
	void testGetLettre() {
	}

	@Test
	void testCarreauTailleN() {
	}

	@Test
	void testMettreLettreEnMaj() {
	}

	@Test
	void testCarteTestCarreau() {
	}

}
