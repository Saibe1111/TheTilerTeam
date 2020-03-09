/*
  @file Jeux.java
 * @author Iris CHAIX
 * @author Sébastien CUVELLIER
 * @version version 1 - 20/02/2020
 * @brief Classe Jeux
 */

package fr.thetilerteam.logique;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {
	// ON DEFINIT LES ATTRIBUT DE LA CLASSE JEU
	private Paquet paquet;
	private ListeCarreaux carreauxListe;
	private Mur mur;
	private int score;

	/**
	 * CONSTRUCTEUR QUI PERMET D'INITALISER UNE PARTIE
	 */
	public Jeu() {
		// ON DECLARE: UNE PAQUET, LES CARREAUXROUGES, LES CARREAUX BLEU ET NOTRE
		// PLATEAU (MUR)
		score = 0;
		paquet = new Paquet();
		carreauxListe = new ListeCarreaux();
		mur = new Mur();
		// ON GENERE UN NOMBRE ALEATOIRE
		Random r = new Random();
		// ON STOCK CE NOMBRE ALEATOIRE COMPRIS ENTRE 0 ET 3 DANS UNE VARIABLE VALEUR
		int valeur = r.nextInt(4);
		// CHAQUE NUMERO CORESPOND A UNE POSITION DU CARREAU VERT
		switch (valeur) {
		case 0:
			Carreau carreauVert = new Carreau(1, 3, 'x', Couleur.VERT);
			mur.placerCarreauSurMur(0, 0, carreauVert);
			break;
		case 1:
			Carreau carreauVert1 = new Carreau(3, 1, 'x', Couleur.VERT);
			mur.placerCarreauSurMur(0, 0, carreauVert1);
			break;
		case 2:
			Carreau carreauVert2 = new Carreau(1, 3, 'x', Couleur.VERT);
			mur.placerCarreauSurMur(4, 0, carreauVert2);
			break;
		case 3:
			Carreau carreauVert3 = new Carreau(3, 1, 'x', Couleur.VERT);
			mur.placerCarreauSurMur(2, 0, carreauVert3);
			break;
		}
	}

	/**
	 * NOUS DONNE LA LISTE DES CARREAUX JOUANLE EN FONCTION D'UNE CARTE
	 * 
	 * @param carte, carte en fonction de laquel on determine les carreaux jouables
	 * @return ArrayList<Carreau> des carreaux qui corresponde a la carte
	 */
	public ArrayList<Carreau> carreauxJouables(Carte carte) {

		ArrayList<Carreau> listeCarreauJouable = new ArrayList<>();
		for (int i = 0; i < carreauxListe.nbCarreaux(); ++i)
			if (carte.correspondA(carreauxListe.getCarreau(i)))
				listeCarreauJouable.add(this.carreauxListe.getCarreau(i));

		return listeCarreauJouable;
	}

	/**
	 * ON REGARDE SI LA LETTRE DONNEE PAR LE JOUEUR APPARTIENT A LA LISTE DES
	 * CARREAUX JOUABLE
	 * 
	 * @param ArrayList<Carreau>, liste des carreaux jouables
	 * @param lettre,lettre       qui est un char
	 * @return boolean, return true si la lettre appartient a la liste des carreaux
	 *         jouables
	 */
	public boolean lettreJouable(ArrayList<Carreau> listeCarreauJouable, char lettre) {
		boolean test = false;
		for (Carreau carreau : listeCarreauJouable)
			if (carreau.getLettre() == lettre) {
				test = true;
				break;
			}
		return test;
	}

	/**
	 * ON DETERMINE LE PLUS GRAND CARREAU DE LA LISTE
	 * 
	 * @return int nb, return un int qui correspond a la plus grande valeur de
	 *         largeur ou hauteur possible
	 */
	private int plusGrandCarreau() {
		int nb = 0;
		ListeCarreaux lc = new ListeCarreaux();
		for (int i = 0; i < lc.nbCarreaux(); ++i) {
			if (nb < lc.getCarreau(i).getHauteur()) {
				nb = lc.getCarreau(i).getHauteur();
			} else if (nb < lc.getCarreau(i).getLargeur()) {
				nb = lc.getCarreau(i).getLargeur();
			}
		}
		return nb;
	}

	/**
	 * PERMET D'AFFICHER LA LISTE DES CARREAUX JOUABLE
	 * 
	 * @param carte, carte qui a été tiré
	 * @return String, qui correspond a l'affichage des carreaux qui peuvent êtres
	 *         joué
	 */
	public String toStringCarreauJouable(Carte carte) {
		ArrayList<Carreau> listeCarreauJouable = this.carreauxJouables(carte);
		if (listeCarreauJouable.size() == 0) {
			paquet.ajouteCarteEcartee();
			return "Carte écarté, aucun carreau jouable";
		}

		StringBuilder sb = new StringBuilder();
		ArrayList<char[]> tab;
		tab = new ArrayList<>();
		int r = 0;
		for (Carreau carreau : listeCarreauJouable) {
			for (int k = 0; carreau.getLargeur() > k; ++k) {
				tab.add(new char[plusGrandCarreau()]);
				for (int j = 0; carreau.getHauteur() > j; ++j)
					tab.get(r)[j] = carreau.getLettre();
				r++;
			}
			r++;
			tab.add(new char[plusGrandCarreau()]);
		}
		// STRING BUILDER
		for (int i = tab.get(0).length - 1; i >= 0; --i) {
			for (char[] chars : tab) {
				sb.append(chars[i]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * PERMET DE RETIRE IN CARREAU
	 * 
	 * @param lettre, lettre de la carte qu'on veut retirer
	 */
	public void retirerCarreaux(char lettre) {
		carreauxListe.retirerCareauListe(lettre);
	}

	/**
	 * PERMET DE RETIRE IN CARREAU
	 * 
	 * @param lettre,lettre        de la carte qu'on veut retirer
	 * @param positionX,position   X ou on veut poser le carreau
	 * @param positionY,position   Y ou on veut poser le carreau
	 * @param listeCarreauJouable, liste des carreaux possible
	 */
	public void placerCarreau(char lettre, int positionX, int positionY, ArrayList<Carreau> listeCarreauJouable) {
		mur.placerCarreauSurMur(positionX, positionY, this.retrouverCarreau(lettre, listeCarreauJouable));
		// ON RETIRE LE CARREAU JOUER DE LA LISTE
		this.retirerCarreaux(lettre);
	}

	/**
	 * PERMET DE RETROUVER UN CARREAU DANS UNE LISTE
	 * 
	 * @param lettre,lettre        de la carte qu'on veut retirer
	 * @param listeCarreauJouable, liste des carreaux possible
	 * @return Carreau, qui correspond a la lettre
	 */
	public Carreau retrouverCarreau(char lettre, ArrayList<Carreau> listeCarreauJouable) {
		for (Carreau carreau : listeCarreauJouable)
			if (carreau.getLettre() == lettre)
				return carreau;
		return null;
	}

	/**
	 * PERMET D'AFFICHER LE MUR
	 * 
	 * @return String, du mur
	 */
	public String toStringMur() {
		return mur.toString();
	}

	/**
	 * PERMET DE PIOCHER UNE CARTE
	 * 
	 * @return String, de la carte
	 */
	public Carte piocher() throws Exception {
		return paquet.piocher();
	}

	/**
	 * PERMET DE CALCULER LE SCORE DU JOUEUR
	 * 
	 * @return String, du mur
	 */
	public int getScore() {
		this.calculerCarteEcartee(paquet);
		this.calculerPointCarreauxPasPoseListe(carreauxListe);
		this.calculerPointNiveauComplet(mur);
		return score;
	}

	/**
	 * PERMET DE CALCULER LE SCORE DU JOUEUR POUR LES NIVEAUX COMPLET
	 * 
	 * @param m, mur sur lequel on veut compter les points
	 */
	private void calculerPointNiveauComplet(Mur m) {
		final int NB_POINT_NIVEAU_COMPLET = 5;
		this.score += NB_POINT_NIVEAU_COMPLET * m.nombreNiveauComplet();
	}

	/**
	 * PERMET DE CALCULER LE SCORE DU JOUEUR POUR LES CARREAUX NON POSEE
	 * 
	 * @param l, liste a partir de laquel on veut compter les points
	 */
	private void calculerPointCarreauxPasPoseListe(ListeCarreaux l) {
		this.score -= l.nbCarreaux();
	}

	/**
	 * PERMET DE CALCULER LE SCORE DU JOUEUR POUR LES CARTES ECARTEE
	 * 
	 * @param p, paquet a partir du quel on compte les cartes ecartee
	 */
	private void calculerCarteEcartee(Paquet p) {
		this.score -= p.getCartesEcartees();
	}

	/**
	 * PERMET D'ECARTEE UNE CARTE
	 * 
	 */
	public void ecarteeCarte() { paquet.ajouteCarteEcartee(); }

	/**
	 * PERMET D'ECARTEE UNE CARTE
	 * 
	 * @param X,       position X a tester
	 * @param Y,       position Y a tester
	 * @param carreau, carreau que l'on veut placer
	 * @return boolean, true si le mur peut recevoir le carreau
	 */
	public boolean murPeutRecevoir(int X, int Y, Carreau carreau) throws Exception {
		return mur.peutRecevoir(X, Y, carreau);
	}

}
