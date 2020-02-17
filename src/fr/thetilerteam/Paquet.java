package fr.thetilerteam;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	// static car on aura un seul paquet de carte
	private ArrayList<Carte> paquet;
	private int cartesEcartees;

	public Paquet() {
		cartesEcartees = 0;
		
		// ICI ON SPECIFIE LE NOMBRE DE CARTE, LEUR APPELATION ET LEUR DENOMINATION POUR
		// LE PROGRAMME
		// ON PEUT EN AJOUTER, EN SUPPRIMER, CHANGER LES APPELATION

		String[][] tailles = { { String.valueOf(9), "Bleu", "B" }, { String.valueOf(9), "Rouge", "R" },
				{ String.valueOf(5), "Taille 1", "1" }, { String.valueOf(5), "Taille 2", "2" },
				{ String.valueOf(5), "Taille 3", "3" } };

		// ON CONSTRUIT LA LISTE DES CARTES

		paquet = new ArrayList<>();
		for (String[] taille : tailles)
			for (int i = 0; i < Integer.parseInt(taille[0]); ++i)
				// paquet.add(new Carte(taille[1], taille[2].charAt(0)));
				this.paquet.add(new Carte(taille[1], taille[2].charAt(0)));

		// ON MELANGE LES CARTES
		melanger();

	}

	// POUR MELANGER L'ARRAYLIST

	public void melanger() {
		Collections.shuffle(this.paquet);
	}

	// PIOCHE
	public Carte piocher() {
		Carte c = this.paquet.get(0);
		this.paquet.remove(0);
		return c;
	}

	public int getCartesEcartees() {
		return cartesEcartees;
	}

	public void ajouteCarteEcartee() {
		++this.cartesEcartees;
	}

}
