package fr.thetilerteam.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carreau;
import fr.thetilerteam.logique.Mur;

class MurTest {

	private static Mur m;
	private static Carreau c;

	@BeforeEach
	void setUp() {
		m = new Mur();
	}

	@Test
	void testGetMur() {
		m.setMur(0, 0, 't');
		assertEquals('t', m.getMur(0, 0));
	}

	@Test
	void testAppartientAuMur() {
		m.ajoutLigne();
		assertTrue(m.appartientAuMur(1, 1));
		assertFalse(m.appartientAuMur(1, 2));
	}

	@Test
	void testNombreNiveauComplet() {
		m.setMur(0, 0, 't');
		m.setMur(1, 0, 't');
		m.setMur(2, 0, 't');
		m.setMur(3, 0, 't');
		m.setMur(4, 0, 't');
		assertEquals(1, m.nombreNiveauComplet());
	}

	@Test
	void testCaseVide() {
		c = new Carreau(1, 1, 't');
		m.setMur(0, 0, 't');
		assertFalse(m.caseVide(0, 0, c), "La case ne devrait pas etre vide");
		assertTrue(m.caseVide(1, 0, c), "La case devrait etre vide");
	}

	@Test
	void testCarreauAdjacent() {
		c = new Carreau(1, 1, 't');
		m.setMur(0, 0, 's');
		assertTrue(m.carreauAdjacent(1, 0, c));
		assertFalse(m.carreauAdjacent(4, 0, c));
	}

	@Test
	void testCarreauReposeSurBase() {
		c = new Carreau(3, 1, 't');
		m.setMur(0, 0, 's');
		m.setMur(2, 0, 's');
		assertFalse(m.carreauReposeSurBase(0, 1, c));
		m.setMur(1, 0, 's');
		assertTrue(m.carreauReposeSurBase(0, 1, c));
	}

	@Test
	void testCarreauClone() {
		c = new Carreau(3, 1, 't');
		m.setMur(0, 0, 's');
		m.setMur(2, 0, 's');
		m.setMur(1, 0, 's');
		assertFalse(m.carreauClone(0, 1, c));
		c = new Carreau(2, 1, 't');
		assertTrue(m.carreauClone(0, 1, c));
	}

}
