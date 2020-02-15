package fr.thetilerteamTest;

import org.junit.jupiter.api.Test;

import fr.thetilerteam.ListeCarreaux;

class CarreauTest {

	@Test
	void test() {
		ListeCarreaux lc = new ListeCarreaux();
		lc.MettreLettreEnMaj();
		System.out.println(lc.nbCarreaux());
		System.out.println(lc.getCarreau(1).afficherCarreau());
		System.out.println(lc.getCarreau(2).afficherCarreau());
		System.out.println(lc.getCarreau(3).afficherCarreau());
		System.out.println(lc.nbCarreaux());
	}
}
