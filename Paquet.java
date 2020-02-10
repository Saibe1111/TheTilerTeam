package fr.thetilerteam;

import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
	// static car on aura un seul paquet de carte
	private static ArrayList<Carte> paquet;

	public Paquet() {
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
				Paquet.paquet.add(new Carte(taille[1], taille[2].charAt(0)));

		// ON MELANGE LES CARTES
		Melanger();

	}

	// POUR MELANGER L'ARRAYLIST

	public static void Melanger() {
		Collections.shuffle(Paquet.paquet);
	}

	// PIOCHE
	public static Carte Piocher() {
		Carte c = Paquet.paquet.get(0);
		Paquet.paquet.remove(0);
		return c;
	}

}
