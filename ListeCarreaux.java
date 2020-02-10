package fr.thetilerteam;

import java.util.ArrayList;

public class ListeCarreaux {
	// pqs static car on aura deux liste de carreaux
	private ArrayList<Carreau> listeCarreaux;

	public ListeCarreaux() {
		// ici on spécifie la lettre du premier carreau,
		// les autres prendront les lettres qui suivent
		char c = 'a';
		// ici on spécifie la taille de chaque carreau
		// on peut en ajouter, en supprimer, changer les tailles,
		// ou même changer l'ordre (et donc changer la lettre)
		int[][] tailles = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 1 }, { 2, 2 }, { 2, 3 }, { 3, 1 }, { 3, 2 }, { 3, 3 } };
		// on construit la liste de carreaux
		ArrayList<Carreau> listeCarreaux = new ArrayList<>();
		for (int[] taille : tailles)
			listeCarreaux.add(new Carreau(taille[0], taille[1], c++));

	}

	// METTRE EN MAJUSCULE LES LETTRE (POUR LES CARREAUX ROUGE)

	public ArrayList<Carreau> MettreLettreEnMaj() {
		for (Carreau car : this.listeCarreaux)
			car.MettreLettreEnMaj();
		return this.listeCarreaux;
	}
}
