package fr.thetilerteam;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CarteTest {

	@Test
	void test() {
		ArrayList<Carte> paquetCarte = Carte.getCarte();
		for (Carte p : paquetCarte) {
			System.out.println(p.AfficherCarte());
		}
	}

}
