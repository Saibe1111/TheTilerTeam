package fr.thetilerteam.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carreau;
import fr.thetilerteam.logique.Carte;
import fr.thetilerteam.logique.Couleur;

class CarteTest {

	private static Carte cCouleur;
	private static Carte cTaille;

	@BeforeEach
	void setUp() {
		cCouleur = new Carte(Couleur.BLEU);
		cTaille = new Carte(1);
	}

	@Test
	void testCorrespondA() {
		Carreau c1 = new Carreau(1, 1, 'a', Couleur.BLEU);
		Carreau c2 = new Carreau(2, 2, 'a', Couleur.ROUGE);
		assertTrue("Pb correspondance carte ", cCouleur.correspondA(c1));
		assertFalse("Pb correspondance carte ", cCouleur.correspondA(c2));
		assertTrue("Pb correspondance carte ", cTaille.correspondA(c1));
		assertFalse("Pb correspondance carte ", cTaille.correspondA(c2));
	}

}
