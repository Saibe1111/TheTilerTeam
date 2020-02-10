package fr.thetilerteam;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Carreau> carreauxBleu = Carreau.getCarreaux();
		ArrayList<Carreau> carreauxRouge = Carreau.getCarreaux();
		Carreau.MettreLettreEnMaj(carreauxRouge);
		ArrayList<Paquet> paquetCarte = Paquet.getCarte();

	}

}
