package fr.thetilerteam.test;

import org.junit.jupiter.api.Test;

import fr.thetilerteam.Mur;

class MurTest {

	@Test
	void test() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		// FonctionMur.afficherMur(mur);
		Mur mur = new Mur();
		mur.setMur(4, 1, 'a');
		System.out.println(mur.toStringMur());

	}

}
