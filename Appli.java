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
			// ON LANCE UNE ACTION EN FONCTION DE LA SAISIE DU JOUEUR
			switch (sc.next()) {
			case "next":
				// ON AFFICHE LE MUR (ZONE A CARRELER)
				System.out.println(j.getMur().toStringMur() + "\n");
				// ON PIOCHE UNE CARTE
				Carte c = Paquet.piocher();
				// ON AFFICHE LA CARTE PIOCHEE
				System.out.println("Carte piochée: " + c.nomCarte + "\nVoici la liste des carreaux utilisable:");
				// ON AFFICHE LES CARREAUX DESIGNES PAR LA CARTE
				System.out.println(j.toStringCarreauJouable(j.carreauxJouables(c)));
				// ANNONCE DE LA DEMANDE DE SAISIE
				System.out.println(
						"Quel carte voulez vous jouer (Lettre) et où (X, Y de position coin bas gauche) ? ou tapez \"ecartée\" ");
				// ON STOCK LA LETTRE ENTREE
				char lettre = sc.next().charAt(0);
				// ON PLACE LE CARREAU
				j.placerCarreau(lettre, sc.nextInt(), sc.nextInt(), j.carreauxJouables(c));
				// ON RETIRE LE CARREAU JOUER DE LA LISTE
				j.retirerCarreaux(lettre);
				break;
			case "stop":
				System.out.println("Merci d'avoir joué :) \nVotre score: " + "Score");
				// ON ARRETE LA BOUCLE
				FinJeux = false;
				break;
			default:
				// ON AFFICHE UN MESSAGE D'ERREUR
				System.out.println(
						"Commande inconnue \nLes commandes disponibles sont:\nstop : Affiche le score et arrete la partie \nnext : passer au tour suivant");
				break;
			}
		}
		// ON FERME LE SCANNER
		sc.close();
	}

}
