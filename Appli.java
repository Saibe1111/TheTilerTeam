package fr.thetilerteam;

import java.util.Scanner;

public class Appli {

	public static void main(String[] args) {

		// ON DECLARE UN NOUVEAU JEUX

		boolean FinJeux = false;
		Jeux j = new Jeux();

		// On joue les tours tant que il n'y a pas de raison d'arrêt
		// while (FinJeux == false) {
		System.out.println(j.getMur().toStringMur() + "\n");
		Carte c = Paquet.piocher();
		System.out.println("Carte piochée: " + c.nomCarte + "\nVoici la liste des carreaux utilisable:");
		System.out.println(j.toStringCarreauJouable(j.carreauJouable(c)));
		System.out.println("Quel carte voulez vous jouer (Lettre) et où (Position coin droit) ? ou tapez \"ecartée\" ");
		Scanner sc = new Scanner(System.in);
		j.placerCarreau(sc.next().charAt(0), sc.nextInt(), sc.nextInt(), j.carreauJouable(c));
		System.out.println(j.getMur().toStringMur() + "\n");
		sc.close();
		// }

	}

}
