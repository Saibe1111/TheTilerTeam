package fr.thetilerteam;

import java.util.Scanner;

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
			Carte c = Paquet.piocher();
			// ON AFFICHE LA CARTE PIOCHEE
			System.out.println("Carte piochée: " + c.nomCarte + "\nVoici la liste des carreaux utilisable:");
			// ON AFFICHE LES CARREAUX DESIGNES PAR LA CARTE
			System.out.println(j.toStringCarreauJouable(j.carreauxJouables(c)));
			// CHANGER LE SWITCH PAR DES TEST CAR IMPOSSIBLE, PB DE GESTION DE LA POSE DE
			// CARREAUX
			String test = sc.next();
			boolean commandeNonValide = true;
			while(commandeNonValide) {	
				if (test.equals("next")) {

					System.out.println("Next ok");
					commandeNonValide = false;
					
				} else if (test.equals("stop")) {

					System.out.println("Merci d'avoir joué :) \nVotre score: " + "Score");
				// ON ARRETE LES BOUCLES
					commandeNonValide = false;
					FinJeux = false;

				} else {
					int X = sc.nextInt();				
					int Y = sc.nextInt();
					if (X > 0 && X < j.getMur().tailleXTableau() + 1 && Y > 0 && Y < j.getMur().tailleYTableau() + 1) {
						// ON PLACE LE CARREAU
						j.placerCarreau(test.charAt(0), X - 1 , Y - 1, j.carreauxJouables(c));
						// ON RETIRE LE CARREAU JOUER DE LA LISTE
						j.retirerCarreaux(test.charAt(0));
						commandeNonValide = false;
					}else {
						System.out.println("Commande inconnue !!");
					}
				}
			}

		}
		// ON FERME LE SCANNER
		sc.close();
	}

}
