package fr.thetilerteam.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.thetilerteam.logique.Carreau;
import fr.thetilerteam.logique.Couleur;
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
	void testPeutRecevoir() {

		Carreau c = new Carreau(2, 1, 'a', Couleur.BLEU);

		m.setMur(1, 0, 't');
		m.setMur(2, 0, 't');

		// TEST SORTIE TAB
		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(1, 6, c);
		}, "Problème Sortie tableau");

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(7, 1, c);
		}, "Problème Sortie tableau");

		// TEST CASE NON VIDE

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(1, 1, c);
		}, "PB Case non vide");

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(1, 1, new Carreau(2, 10, 'c', Couleur.ROUGE));
		}, "PB Case non vide");

	}

	@Test
	void testPeutRecevoirAdjacence() throws Exception {

		m.setMur(1, 0, 't');
		// TEST ADJACENCE

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(4, 1, new Carreau(1, 1, 'c', Couleur.ROUGE));
		}, "PB  adjacence");
		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(4, 2, new Carreau(1, 5, 'c', Couleur.ROUGE));
		}, "PB  adjacence");

		m.setMur(2, 0, 't');
		m.peutRecevoir(2, 2, new Carreau(1, 2, 'c', Couleur.ROUGE));
		m.peutRecevoir(1, 1, new Carreau(1, 2, 'c', Couleur.ROUGE));
		m.peutRecevoir(4, 1, new Carreau(1, 2, 'c', Couleur.ROUGE));

	}

	@Test
	void testPlacerCarreaux() {
		Carreau c = new Carreau(2, 2, 'c', Couleur.ROUGE);

		m.placerCarreauSurMur(0, 0, c);
		assertEquals(m.getMur(0, 0), 'c');
		assertEquals(m.getMur(1, 0), 'c');
		assertEquals(m.getMur(1, 1), 'c');
		assertEquals(m.getMur(0, 1), 'c');
	}

	@Test
	void testPeutRecevoirReposeSurBase() {
		m.setMur(1, 0, 't');
		// TEST BASE

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(1, 2, new Carreau(2, 1, 'c', Couleur.ROUGE));
		}, "PB  base");
	}

	@Test
	void testPeutRecevoirClone() {
		m.setMur(1, 0, 'e');
		// TEST CLONE

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(1, 1, new Carreau(1, 1, 'c', Couleur.ROUGE));
		}, "PB  Clone");
		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(3, 1, new Carreau(1, 1, 'c', Couleur.ROUGE));
		}, "PB  Clone");

		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(2, 2, new Carreau(1, 1, 'c', Couleur.ROUGE));
		}, "PB  Clone");
		m.setMur(1, 1, 't');
		m.setMur(0, 0, 't');
		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(1, 2, new Carreau(1, 2, 'c', Couleur.ROUGE));
		}, "PB  Clone");

		m.setMur(4, 0, 't');
		m.setMur(3, 0, 't');
		m.setMur(3, 1, 'e');
		// System.out.println(m.toString());
		Assertions.assertThrows(Exception.class, () -> {
			m.peutRecevoir(5, 2, new Carreau(1, 1, 'c', Couleur.ROUGE));
		}, "PB  Clone");
	}

	@Test
	void testToString() {
		m.setMur(0, 0, 'a');
		m.setMur(1, 0, 'b');
		m.setMur(2, 0, 'c');
		m.setMur(3, 0, 'd');
		m.setMur(4, 0, 'e');
		m.setMur(0, 1, 'f');
		m.setMur(1, 1, 'g');
		m.setMur(2, 1, 'h');
		m.setMur(3, 1, 'i');
		m.setMur(4, 1, 'j');

		assertEquals(" 3     \n" + " 2fghij\n" + " 1abcde\n" + "  12345", m.toString());

	}

}
