package fr.thetilerteam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
	public static ArrayList<Carreau> lireCarreau(String nomFichier) throws FileNotFoundException {

		ArrayList<Carreau> carreau = new ArrayList<>();
		Scanner in = new Scanner(new FileInputStream(nomFichier));
		while (in.hasNextLine()) {
			Scanner lsc = new Scanner(in.nextLine());
			Carreau c = new Carreau();
			c.EnregistrerCarreau(lsc.nextInt(), lsc.nextInt(), lsc.next().charAt(0));
			carreau.add(c);
			lsc.close();
		}
		in.close();
		return carreau;
	}
}
