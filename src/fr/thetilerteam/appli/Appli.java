package fr.thetilerteam.appli;

import java.util.Scanner;

import fr.thetilerteam.Carte;
import fr.thetilerteam.Jeux;

public class Appli {

	public static void main(String[] args) {

		// ON DECLARE UN NOUVEAU JEUX
		boolean FinJeux = true;
		Jeux j = new Jeux();
		// ON DECLARE UN NOUVEAU SCANNER
		Scanner sc = new Scanner(System.in);
		while (FinJeux) {

			// ON AFFICHE LE MUR (ZONE A CARRELER)
			System.out.println(j.getMur().toStringMur() + "\n");
			// ON PIOCHE UNE CARTE
			Carte c = j.getPaquet().piocher();
			// ON AFFICHE LA CARTE PIOCHEE
			System.out.println("Carte piochée: " + c.getNomCarte() + "\nVoici la liste des carreaux utilisable:");
			// ON AFFICHE LES CARREAUX DESIGNES PAR LA CARTE
			System.out.println(j.toStringCarreauJouable(j.carreauxJouable(c)));
			boolean CommandeNonValide = true;
			while (CommandeNonValide) {
				try {
					String text = j.commande(c, sc);
					System.out.println(text);
					CommandeNonValide = false;
					if (text.contains("Merci"))
						FinJeux = false;
				} catch (Exception e) {
					// e.printStackTrace();
					System.err.println(e.getMessage());
					CommandeNonValide = true;

				}

			}
		}
		sc.close();
	}

}
