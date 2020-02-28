/**
 * @file CarteTest.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Test de la classe Carte 
 */

package fr.thetilerteam.test;

import org.junit.jupiter.api.BeforeEach;

import fr.thetilerteam.logique.Carte;
import fr.thetilerteam.logique.Couleur;

class CarteTest {

	private static Carte c;

	@BeforeEach
	void setUp() {
		c = new Carte(Couleur.BLEU);
	}

}
