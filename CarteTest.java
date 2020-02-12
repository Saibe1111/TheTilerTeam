package fr.thetilerteam;

import org.junit.jupiter.api.Test;

class CarteTest {

	@Test
	void test() {
		// ArrayList<Paquet> paquetCarte = Paquet.getCarte();
		// for (Paquet p : paquetCarte) {
		// System.out.println(Paquet.AfficherCarte());
		// }
		Paquet p = new Paquet();
		System.out.println(Paquet.piocher().afficherCarte());
		System.out.println(Paquet.piocher().afficherCarte());
		System.out.println(Paquet.piocher().afficherCarte());
		System.out.println(Paquet.piocher().afficherCarte());

	}
}
