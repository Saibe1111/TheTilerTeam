package fr.thetilerteam.test;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fr.thetilerteam.Carte;
import fr.thetilerteam.Jeux;

class JeuxTest {

	@Test
	void test() {
		Jeux j = new Jeux();
		System.out.println(j.getMur().toStringMur() + "\n");
		Carte c = j.getPaquet().piocher();
		System.out.println("Carte pioché " + c.getNomCarte() + "\n");
		System.out.println(j.toStringCarreauJouable(j.carreauxJouable(c)));
		System.out.println("Quel carte voulez vous jouer (Lettre) et où (Position coin droit) ? ");
		Scanner sc = new Scanner(System.in);
		j.placerCarreau(sc.next().charAt(0), sc.nextInt(), sc.nextInt(), j.carreauxJouable(c));
		System.out.println(j.getMur().toStringMur() + "\n");
		sc.close();
	}

}
