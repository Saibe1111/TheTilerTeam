/**
 * @file CarteTest.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Test de la classe Carte 
 */

package fr.thetilerteam.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carte;

class CarteTest {

	private static Carte c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Carte("test", 't');
	}

	@Test
	void testGetNomCarte() {
		assertTrue("Problème getNomCarte", c.getNomCarte() == "test");
	}

	@Test
	void testGetTypeCarte() {
		assertTrue("Problème getTypeCarte", c.getTypeCarte() == 't');
	}

}
