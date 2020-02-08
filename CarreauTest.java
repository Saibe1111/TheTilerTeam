package fr.thetilerteam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CarreauTest {

	@Test
	void test() {
		ArrayList<Carreau> carreauxTest = FonctionCarreau.getCarreaux();
		FonctionCarreau.MettreLettreEnMaj(carreauxTest);
		assertEquals(carreauxTest.get(0).getHauteur(), 1);
		assertEquals(carreauxTest.get(0).getLargeur(), 1);
		assertEquals(carreauxTest.get(0).getLettre(), 'A');
	}
}
