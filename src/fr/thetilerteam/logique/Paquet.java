/**
  * @file Paquet.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Paquet 
 */

package fr.thetilerteam.logique;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	private ArrayList<Carte> paquet;
	private int cartesEcartees;

	public Paquet() {
		cartesEcartees = 0;
		final int NB_CRT_COUL =  9;
		final int NB_CRT_TAILLE = 5;
		final int TAILLE_MIN = 1;
		final int TAILLE_MAX = 3;

		paquet = new ArrayList<>();

		for (int i = 0; i < NB_CRT_COUL; ++i) {
			paquet.add(new Carte(Couleur.BLEU));
			paquet.add(new Carte(Couleur.ROUGE));
		}
		for (int i = 0; i < NB_CRT_TAILLE; ++i)
			for (int taille = TAILLE_MIN; taille <= TAILLE_MAX; ++taille)
				paquet.add(new Carte(taille));

		// ON MELANGE LES CARTES
		melanger();

	}

	// POUR MELANGER L'ARRAYLIST

	private void melanger() {
		Collections.shuffle(this.paquet);
	}

	// PIOCHE
	public Carte piocher() throws Exception {
		if (paquet.size() == 0)
			throw new Exception("Plus de carte dans le paquet fin de la partie");
		Carte c = this.paquet.get(paquet.size() - 1);
		this.paquet.remove(paquet.size() - 1);
		return c;
	}

	public int getCartesEcartees() {
		return cartesEcartees;
	}

	public void ajouteCarteEcartee() {
		++this.cartesEcartees;
	}

}
