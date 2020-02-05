package fr.thetilerteam;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Carreau> carreauxBleu = Jeu.lireCarreau("Carreaux.txt");
		for (Carreau car : carreauxBleu) {
			System.out.println(car.AfficherCarreau());
		}

	}

}
