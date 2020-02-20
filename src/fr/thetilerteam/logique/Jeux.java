/**
  * @file Jeux.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Jeux
 */

package fr.thetilerteam.logique;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jeux {
	private Paquet paquet;
	private ListeCarreaux carreauxRouge;
	private ListeCarreaux carreauxBleu;
	private Mur mur;
	private Score score;

	// CONSTRUCTEUR QUI PERMET D'INITALISER UNE PARTIE

	public Jeux() {
		// ON DECLARE: UNE PAQUET, LES CARREAUXROUGES, LES CARREAUX BLEU ET NOTRE
		// PLATEAU (MUR)
		score = new Score();
		paquet = new Paquet();
		carreauxRouge = new ListeCarreaux();
		carreauxRouge.MettreLettreEnMaj();
		carreauxBleu = new ListeCarreaux();
		mur = new Mur();
		// ON GENERE UN NOMBRE ALEATOIRE
		Random r = new Random();
		// ON STOCK CE NOMBRE ALEATOIRE COMPRIS ENTRE 0 ET 3 DANS UNE VARIABLE VALEUR
		int valeur = r.nextInt(4);
		// CHAQUE NUMERO CORESPOND A UNE POSITION DU CARREAU VERT
		switch (valeur) {
		case 0:
			Carreau carreauVert = new Carreau(1, 3, 'x');
			mur.placerCarreauSurMur(0, 0, carreauVert);
			break;
		case 1:
			Carreau carreauVert1 = new Carreau(3, 1, 'x');
			mur.placerCarreauSurMur(0, 0, carreauVert1);
			break;
		case 2:
			Carreau carreauVert2 = new Carreau(1, 3, 'x');
			mur.placerCarreauSurMur(4, 0, carreauVert2);
			break;
		case 3:
			Carreau carreauVert3 = new Carreau(3, 1, 'x');
			mur.placerCarreauSurMur(2, 0, carreauVert3);
			break;
		}
	}

	// PERMET DE RECUPERER LE MUR

	public Mur getMur() {
		return mur;
	}

	// PERMET DE RECUPERER LE MUR

	public Paquet getPaquet() {
		return paquet;
	}

	// NOUS DONNE LA LISTE DES CARREAUX JOUANLE EN FONCTION D'UNE CARTE

	public ArrayList<Carreau> carreauxJouable(Carte carte) {
		ArrayList<Carreau> listeCarreauJouable = new ArrayList<Carreau>();
		for (int i = 0; i < carreauxBleu.nbCarreaux(); ++i) {
			if (carreauxBleu.getCarreau(i).carteTestCarreau(carte.getTypeCarte())) {
				listeCarreauJouable.add(this.carreauxBleu.getCarreau(i));
			}
		}
		for (int i = 0; i < carreauxRouge.nbCarreaux(); ++i) {
			if (carreauxRouge.getCarreau(i).carteTestCarreau(carte.getTypeCarte())) {
				listeCarreauJouable.add(this.carreauxRouge.getCarreau(i));
			}
		}
		return listeCarreauJouable;

	}

	private boolean lettreJouable(ArrayList<Carreau> listeCarreauJouable, char lettre) {
		boolean test = false;
		for (int i = 0; i < listeCarreauJouable.size(); i++)
			if (listeCarreauJouable.get(i).getLettre() == lettre)
				test = true;

		return test;
	}

	// PERMET D'AFFICHER LA LISTE DES CARREAUX JOUABLE DETERMINEE PAR LA FONCTION
	// PRECEDENTE

	public String toStringCarreauJouable(ArrayList<Carreau> listeCarreauJouable) {
		StringBuilder sb = new StringBuilder();
		ArrayList<char[]> tab;
		tab = new ArrayList<char[]>();
		int r = 0;
		for (int i = 0; i < listeCarreauJouable.size(); ++i) {
			for (int k = 0; listeCarreauJouable.get(i).getLargeur() > k; ++k) {
				tab.add(new char[3]);
				for (int j = 0; listeCarreauJouable.get(i).getHauteur() > j; ++j) {
					tab.get(r)[j] = listeCarreauJouable.get(i).getLettre();
				}
				r++;
			}
			r++;
			tab.add(new char[3]);
		}

		// STRING BUILDER

		for (int i = tab.get(0).length - 1; i >= 0; --i) {
			for (int j = 0; j < tab.size(); ++j) {
				sb.append(tab.get(j)[i]);
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	// PERMET DE RETIRE IN CARREAU

	public void retirerCarreaux(char lettre) {
		carreauxBleu.retirerCareauListe(lettre);
		carreauxRouge.retirerCareauListe(lettre);
	}

	public void placerCarreau(char lettre, int positionX, int positionY, ArrayList<Carreau> listeCarreauJouable) {

		mur.placerCarreauSurMur(positionX, positionY, this.retrouverCarreau(lettre, listeCarreauJouable));
		// ON RETIRE LE CARREAU JOUER DE LA LISTE
		this.retirerCarreaux(lettre);
	}

	private Carreau retrouverCarreau(char lettre, ArrayList<Carreau> listeCarreauJouable) {
		for (int i = 0; i < listeCarreauJouable.size(); i++)
			if (listeCarreauJouable.get(i).getLettre() == lettre)
				return listeCarreauJouable.get(i);
		return null;
	}

	private int getScore() {
		return score.getScore(carreauxRouge, carreauxBleu, paquet, mur);
	}

	public String commande(Carte c, Scanner sc) throws Exception {
		// VIRER LE SCANNER - STINGBUFFER
		String test = sc.next();
		if (test.equals("next")) {
			getPaquet().ajouteCarteEcartee();
			return ("Carte écartée");
		} else if (test.equals("stop")) {
			return ("Merci d'avoir joué :) \nVotre score: " + getScore() + " points !");
		} else {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			Carreau carreau = retrouverCarreau(test.charAt(0), carreauxJouable(c));
			// ON VERIFIE SI LA COMMANDE EST POSSIBLE
			try {
				if (!getMur().appartientAuMur(X, Y))
					throw new Exception("La position n'appartient pas au mur !");
				if (!lettreJouable(carreauxJouable(c), test.charAt(0)))
					throw new Exception("Lettre pas dans la liste !");
				if (!getMur().caseVide(X - 1, Y - 1, carreau))
					throw new Exception("La case n'est pas vide !");
				if (!getMur().carreauAdjacent(X - 1, Y - 1, carreau))
					throw new Exception("Pas de carreau adajcent !");
				if (!getMur().carreauReposeSurBase(X - 1, Y - 1, carreau))
					throw new Exception(
							"Toute la base du carreau repose soit sur le bas de la zone à carreler, soit sur d’autres cartons.");
				if (!getMur().carreauClone(X - 1, Y - 1, carreau))
					throw new Exception("Le carreau ne doit pas cloner un autre carreau");
				placerCarreau(test.charAt(0), X - 1, Y - 1, carreauxJouable(c));
				// ON RETIRE LE CARREAU JOUER DE LA LISTE
				retirerCarreaux(test.charAt(0));
				return ("Carreaux placée");
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new Exception("Impossible vous sortez du tableau !");
			}
		}
	}

}
