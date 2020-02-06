package fr.thetilerteam;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Carreau> carreauxBleu = FonctionCarreau.getCarreaux();
		ArrayList<Carreau> carreauxRouge = FonctionCarreau.getCarreaux();
		FonctionCarreau.MettreLettreEnMaj(carreauxRouge);
		ArrayList<Carte> paquetCarte = FonctionCarte.getCarte();
		for (Carte car : paquetCarte) {
			System.out.println(car.AfficherCarte());
		}

		for (Carreau car : carreauxBleu) {
			System.out.println(car.AfficherCarreau());
		}
		for (Carreau care : carreauxRouge) {
			System.out.println(care.AfficherCarreau());
		}

	}

}
