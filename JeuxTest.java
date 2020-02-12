package fr.thetilerteam;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class JeuxTest {

	@Test
	void test() {
		Jeux j = new Jeux();
		System.out.println(j.getMur().toStringMur() + "\n");
		Carte c = Paquet.piocher();
		System.out.println("Carte pioché " + c.nomCarte + "\n");
		System.out.println(j.toStringCarreauJouable(j.carreauJouable(c)));
		System.out.println("Quel carte voulez vous jouer (Lettre) et où (Position coin droit) ? ");
		Scanner sc = new Scanner(System.in);
		j.placerCarreau(sc.next().charAt(0), sc.nextInt(), sc.nextInt(), j.carreauJouable(c));
		System.out.println(j.getMur().toStringMur() + "\n");
		sc.close();
	}

}
