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
			// CHANGER LE SWITCH PAR DES TEST CAR IMPOSSIBLE, PB DE GESTION DE LA POSE DE
			// CARREAUX
			String test = sc.next();
			boolean commandeNonValide = true;
			while(commandeNonValide) {	
				if (test.equals("next")) {
					j.getPaquet().ajouteCarteEcartee();
					commandeNonValide = false;
				} else if (test.equals("stop")) {
					System.out.println("Merci d'avoir joué :) \nVotre score: " +  j.getScore() + " points !");
				// ON ARRETE LES BOUCLES
					commandeNonValide = false;
					FinJeux = false;
				} else {
					int X = sc.nextInt();				
					int Y = sc.nextInt();	
					//ON VERIFIE SI LA  COMMANDE EST POSSIBLE
					if (j.getMur().appartientAuMur(X, Y)  ) {
						if (j.lettreJouable(j.carreauxJouable(c), test.charAt(0))) {
							if (j.getMur().caseVide(X - 1, Y - 1,
									j.retrouverCarreau(test.charAt(0), X, Y, j.carreauxJouable(c)))) {
								// ON PLACE LE CARREAU
								try {
									j.placerCarreau(test.charAt(0), X - 1, Y - 1, j.carreauxJouable(c));
									commandeNonValide = false;
									// ON RETIRE LE CARREAU JOUER DE LA LISTE
									j.retirerCarreaux(test.charAt(0));
								} catch(ArrayIndexOutOfBoundsException e) {
									System.out.println("Impossible vous sorté du tableau !");
									test = sc.next();
								}
							} else {
									System.out.println("La case n'est pas vide !");
									test = sc.next();
								}
						} else {
							System.out.println("Lettre pas dans la liste !");
							test = sc.next();
						}
					}else {
						System.out.println("La position n'appartient pas au mur !");
						test = sc.next();
					}
				}
			}

		}
		// ON FERME LE SCANNER
		sc.close();
	}

}
