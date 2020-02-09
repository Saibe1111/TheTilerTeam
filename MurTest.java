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
		mur.setMur(1, 10, "c");
		mur.setMur(2, 2, "c");
		//FonctionMur.afficherMur(mur);
		System.out.println(mur.ToStringMur());
	}

}
