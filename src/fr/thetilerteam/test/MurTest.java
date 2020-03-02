package fr.thetilerteam.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Mur;

class MurTest {

	private static Mur m;

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
	void testNombreNiveauComplet() {
		m.setMur(0, 0, 't');
		m.setMur(1, 0, 't');
		m.setMur(2, 0, 't');
		m.setMur(3, 0, 't');
		m.setMur(4, 0, 't');
		assertEquals(1, m.nombreNiveauComplet());
	}

	@Test
	void testPeutRecevoir() throws Exception {
		// CLONAGE
//		try {
//
//			m.peutRecevoir(3, 0, c2);
//			fail("Carreau impossible a placer Clonnage");
//		} catch (Exception e) {
//		}

	}

}
