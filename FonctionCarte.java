package fr.thetilerteam;

import java.util.ArrayList;
import java.util.Collections;

public class FonctionCarte {
	public static ArrayList<Carte> getCarte() {
		// ici on spécifie le nombre de carte, leur appélation et leur dénomination pour
		// le programme
		// on peut en ajouter, en supprimer, changer les appélation.
		String[][] tailles = { { String.valueOf(9), "Bleu", "B" }, { String.valueOf(9), "Rouge", "R" },
				{ String.valueOf(5), "Taille 1", "1" }, { String.valueOf(5), "Taille 2", "2" },
				{ String.valueOf(5), "Taille 3", "3" } };
		// on construit la liste de carte
		ArrayList<Carte> carte = new ArrayList<>();
		for (String[] taille : tailles)
			for (int i = 0; i < Integer.parseInt(taille[0]); ++i)
				carte.add(new Carte(taille[1], taille[2].charAt(0)));
		// On mélange les cartes
		Collections.shuffle(carte);
		// on renvoie la liste des cartes
		return carte;
	}
}
