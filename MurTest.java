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

		Mur mur = new Mur();
		char c = 't';
		mur.setMur(2, 10, c);
		FonctionMur.afficherMur(mur);
	}

}
