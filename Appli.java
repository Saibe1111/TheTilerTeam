package fr.thetilerteam;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Appli {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Carreau> carreauxBleu = FonctionCarreau.getCarreaux();
		ArrayList<Carreau> carreauxRouge = FonctionCarreau.getCarreaux();
		FonctionCarreau.MettreLettreEnMaj(carreauxRouge);
		ArrayList<Carte> paquetCarte = FonctionCarte.getCarte();
		Mur mur = new Mur();
		System.out.println(mur.getMur(6, 0));
		System.out.println(mur.getMur(5, 0));
	}

}
