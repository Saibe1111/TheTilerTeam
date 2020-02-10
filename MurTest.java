package fr.thetilerteam;

import org.junit.jupiter.api.Test;

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

		mur.ajoutLigne();
		mur.setMur(4, 0, "a");
		System.out.println(mur.ToStringMur());

	}

}
