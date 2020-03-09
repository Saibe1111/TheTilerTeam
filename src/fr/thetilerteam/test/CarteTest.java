package fr.thetilerteam.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

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
		Carte cCouleur2 = new Carte(Couleur.ROUGE);
		Carreau c1 = new Carreau(1, 1, 'a', Couleur.BLEU);
		Carreau c2 = new Carreau(2, 2, 'a', Couleur.ROUGE);

		assertTrue("Pb correspondance carte ", cCouleur.correspondA(c1));
		assertFalse("Pb correspondance carte ", cCouleur.correspondA(c2));
		assertTrue("Pb correspondance carte ", cCouleur2.correspondA(c2));
		assertFalse("Pb correspondance carte ", cCouleur2.correspondA(c1));
		assertTrue("Pb correspondance carte ", cTaille.correspondA(c1));
		assertFalse("Pb correspondance carte ", cTaille.correspondA(c2));

	}

	@Test
	void testToString() {
		assertEquals("Carte piochée: BLEU\nVoici la liste des carreaux utilisable:", cCouleur.toString());
		assertEquals("Carte piochée: Taille 1\nVoici la liste des carreaux utilisable:", cTaille.toString());
	}

}
