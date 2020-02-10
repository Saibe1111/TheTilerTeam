package fr.thetilerteam;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PaquetTest {

	@Test
	void test() {
		ArrayList<Paquet> paquetCarte = Paquet.getCarte();
		for (Paquet p : paquetCarte) {
			System.out.println(p.AfficherCarte());
		}
	}

}
