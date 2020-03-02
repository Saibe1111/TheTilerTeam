/**
  * @file Appli.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 4 - 20/02/2020
  * @brief 	Main avec classe Appli
 */

package fr.thetilerteam.appli;

import java.util.Scanner;

import fr.thetilerteam.logique.Carreau;
import fr.thetilerteam.logique.Carte;
import fr.thetilerteam.logique.Jeu;

public class Appli {

	public static void main(String[] args) {

		// ON DECLARE UN NOUVEAU SCANNER ET STRING BUFFER
		Scanner in = new Scanner(System.in);

		// ON DECLARE UN NOUVEAU JEUX
		boolean FinJeux = true;
		Jeu j = new Jeu();

		// s.append(FinJeux);
		// TANT QUE LE JEUX N'EST PAS FINI ON BOUCLE
		while (FinJeux) {
			boolean CommandeValide = false;
			// ON AFFICHE LE MUR (ZONE A CARRELER)
			System.out.println(j.toStringMur() + "\n");
			Carte c = null;
			try {
				// ON PIOCHE UNE CARTE
				c = j.piocher();
			} catch (Exception e) {
				FinJeux = false;
				System.err.println(e.getMessage());
				System.out.println("Merci d'avoir joué :) \nVotre score: " + j.getScore() + " points !");
				break;
			}

			// ON AFFICHE LA CARTE PIOCHEE
			System.out.println(c.toString());
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
					String text = commande(c, in.nextLine(), j);
					// ON AFFICHE LE RETURN DANS LA CONSOLE
					System.out.println(text);
					// ON SET LA COMMANDE DANS LA POSITION OU ELLE EST VALIDE
					CommandeValide = true;
					// SI TEXT CONTIENT MERCI C'EST QUE LE JEUX EST FINI, ON QUITE DONC LA BOUCLE
					// FinJeux
					assert text != null;
					if (text.contains("Merci"))
						FinJeux = false;
					// SI LA COMMANDE PRECEDENTE DE PEUX PAS S'EXECUTER, ON AFFICHE LE MESSAGE
					// D'ERREUR
				} catch (Exception e) {
					//e.printStackTrace();
					System.err.println(e.getMessage());
					// ON SET LA COMMANDE DANS LA POSITION OU ELLE EST NON VALIDE
					CommandeValide = false;
				}
			}
		}
		// ON FERME LE SCANNER
		in.close();
	}

	public static String commande(Carte c, String chaine, Jeu j) throws Exception {
		String[] chaineArr = chaine.split("\\s", 3);
		// VIRER LE SCANNER - STINGBUFFER
		String test = chaineArr[0];

		if (test.equals("next")) {
			j.ecarteeCarte();
			return ("Carte écartée");
		} else if (test.equals("stop")) {
			return ("Merci d'avoir joué :) \nVotre score: " + j.getScore() + " points !");
		} else {
			int X = Integer.parseInt(chaineArr[1]);
			int Y = Integer.parseInt(chaineArr[2]);
			Carreau carreau = j.retrouverCarreau(test.charAt(0), j.carreauxJouables(c));
			// ON VERIFIE SI LA COMMANDE EST POSSIBLE
			if (!j.lettreJouable(j.carreauxJouables(c), test.charAt(0)))
				throw new Exception("Lettre pas dans la liste !");
			if (j.murPeutRecevoir(X, Y, carreau))
				try {
					j.placerCarreau(test.charAt(0), X - 1, Y - 1, j.carreauxJouables(c));
					j.retirerCarreaux(test.charAt(0));
					return ("Carreaux placée");
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new Exception("Impossible vous sortez du tableau !");
				}
		}
		return null;
	}
}
