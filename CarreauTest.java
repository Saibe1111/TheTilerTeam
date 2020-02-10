package fr.thetilerteam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CarreauTest {

	@Test
	void test() {
		ArrayList<Carreau> carreauxBleu = Carreau.getCarreaux();
		ArrayList<Carreau> carreauxRouge = Carreau.getCarreaux();
		Carreau.MettreLettreEnMaj(carreauxRouge);
		assertEquals(carreauxRouge.get(0).getHauteur(), 1);
		assertEquals(carreauxRouge.get(0).getLargeur(), 1);
		assertEquals(carreauxRouge.get(0).getLettre(), 'A');
		for (Carreau c : carreauxBleu) {
			System.out.println(c.AfficherCarreau());
		}
	}
}
