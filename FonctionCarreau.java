package fr.thetilerteam;

import java.util.ArrayList;

public class FonctionCarreau {

	// PERMET DE STOCKER LES CARREAUX DE CONFIG

	public static ArrayList<Carreau> getCarreaux() {
		// ici on spécifie la lettre du premier carreau,
		// les autres prendront les lettres qui suivent
		char c = 'a';
		// ici on spécifie la taille de chaque carreau
		// on peut en ajouter, en supprimer, changer les tailles,
		// ou même changer l'ordre (et donc changer la lettre)
		int[][] tailles = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 3, 1 }, { 3, 2 }, { 3, 3 } };
		// on construit la liste de carreaux
		ArrayList<Carreau> carreaux = new ArrayList<>();
		for (int[] taille : tailles)
			carreaux.add(new Carreau(taille[0], taille[1], c++));
		return carreaux;

	}

	// METTRE EN MAJUSCULE LES LETTRE (POUR LES CARREAUX ROUGE

	public static ArrayList<Carreau> MettreLettreEnMaj(ArrayList<Carreau> Carreau) {
		for (Carreau car : Carreau) {
			car.MettreLettreEnMaj();
		}
		return Carreau;

	}

}
