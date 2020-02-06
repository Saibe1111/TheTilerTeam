package fr.thetilerteam;

import java.util.ArrayList;

public class FonctionCarte {
	public static ArrayList<Carte> getCarte() {

		String[][] tailles = { { String.valueOf(9), "Bleu", "B" }, { String.valueOf(9), "Rouge", "R" },
				{ String.valueOf(5), "Taille 1", "1" }, { String.valueOf(5), "Taille 2", "2" },
				{ String.valueOf(5), "Taille 3", "3" } };
		// on construit la liste de carreaux
		ArrayList<Carte> carte = new ArrayList<>();
		for (String[] taille : tailles)
			for (int i = 0; i < Integer.parseInt(taille[0]); ++i)
				carte.add(new Carte(taille[1], taille[2].charAt(0)));
		return carte;

	}
}
