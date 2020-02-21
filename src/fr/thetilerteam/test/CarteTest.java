/**
 * @file CarteTest.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Test de la classe Carte 
 */

package fr.thetilerteam.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carte;

import static org.junit.Assert.*;

class CarteTest {

	private static Carte c;

	@BeforeEach
	void setUp() {
		c = new Carte("test", 't');
	}

	@Test
	void testGetNomCarte() {
		assertSame("Problème getNomCarte", "test", c.getNomCarte());
	}

	@Test
	void testGetTypeCarte() {
		assertEquals("Problème getTypeCarte", 't', c.getTypeCarte());
	}

}
