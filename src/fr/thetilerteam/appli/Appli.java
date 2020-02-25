/**
  * @file Appli.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 4 - 20/02/2020
  * @brief 	Main avec classe Appli
 */

package fr.thetilerteam.appli;

import java.util.Scanner;

import fr.thetilerteam.logique.Carte;
import fr.thetilerteam.logique.Jeux;

public class Appli {

	public static void main(String[] args) {

		// ON DECLARE UN NOUVEAU SCANNER ET STRING BUFFER
		Scanner in = new Scanner(System.in);

		// ON DECLARE UN NOUVEAU JEUX
		boolean FinJeux = true;
		Jeux j = new Jeux();

		// s.append(FinJeux);
		// TANT QUE LE JEUX N'EST PAS FINI ON BOUCLE
		while (FinJeux) {
			boolean CommandeValide = false;
			// ON AFFICHE LE MUR (ZONE A CARRELER)
			System.out.println(j.getMur().toStringMur() + "\n");
			Carte c = null;
			try {
				// ON PIOCHE UNE CARTE
				c = j.getPaquet().piocher();
			} catch (Exception e) {
				FinJeux = false;
				System.err.println(e.getMessage());
				System.out.println("Merci d'avoir joué :) \nVotre score: " + j.getScore() + " points !");
				break;
			}

			// ON AFFICHE LA CARTE PIOCHEE
			System.out.println("Carte piochée: " + c.getNomCarte() + "\nVoici la liste des carreaux utilisable:");
			// ON AFFICHE LES CARREAUX DESIGNES PAR LA CARTE
			String string = j.toStringCarreauJouable(c);
			if (string.contentEquals("Carte écarté, aucun carreau jouable"))
				CommandeValide = true;
			System.out.println(string);
			// TANT QUE LA COMMANDE N'EST PAS VALIDE
			while (!CommandeValide) {
				// ON ESSAYE DE FAIRE LA COMMANDE
				try {
					// ON EXECUTE LA COMMANDE ET SON RETURN DANS LA VARIABLE TEXT
					String text = j.commande(c, in.nextLine());
					// ON AFFICHE LE RETURN DANS LA CONSOLE
					System.out.println(text);
					// ON SET LA COMMANDE DANS LA POSITION OU ELLE EST VALIDE
					CommandeValide = true;
					// SI TEXT CONTIENT MERCI C'EST QUE LE JEUX EST FINI, ON QUITE DONC LA BOUCLE
					// FinJeux
					if (text.contains("Merci"))
						FinJeux = false;
					// SI LA COMMANDE PRECEDENTE DE PEUX PAS S'EXECUTER, ON AFFICHE LE MESSAGE
					// D'ERREUR
				} catch (Exception e) {
					// e.printStackTrace();
					System.err.println(e.getMessage());
					// ON SET LA COMMANDE DANS LA POSITION OU ELLE EST NON VALIDE
					CommandeValide = false;
				}
			}
		}
		// ON FERME LE SCANNER
		in.close();
	}

}
