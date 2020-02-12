package fr.thetilerteam;

import java.util.Scanner;

public class Appli {

	public static void main(String[] args) {

		// ON DECLARE UN NOUVEAU JEUX
		boolean FinJeux = true;
		Jeux j = new Jeux();
		Scanner sc = new Scanner(System.in);
		while (FinJeux) {
			switch (sc.next()) {
			case "next":
				System.out.println(j.getMur().toStringMur() + "\n");
				Carte c = Paquet.piocher();
				System.out.println("Carte piochée: " + c.nomCarte + "\nVoici la liste des carreaux utilisable:");
				System.out.println(j.toStringCarreauJouable(j.carreauJouable(c)));
				System.out.println(
						"Quel carte voulez vous jouer (Lettre) et où (Position coin droit) ? ou tapez \"ecartée\" ");
				char lettre = sc.next().charAt(0);
				j.placerCarreau(lettre, sc.nextInt(), sc.nextInt(), j.carreauJouable(c));
				j.retirerCarreaux(lettre);
				break;
			case "stop":
				System.out.println("Merci d'avoir joué :) \nVotre score: " + "Score");
				FinJeux = false;
				// in.close();
				break;
			default:
				// in.close();
				System.out.println(
						"Commande inconnue \nLes commandes disponibles sont:\nstop : Affiche le score et arrete la partie \nnext : passer au tour suivant");
				break;
			}
		}
		sc.close();
	}

}
