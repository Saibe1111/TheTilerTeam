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
	private Paquet paquet;
	private ListeCarreaux carreauxListe;
	private Mur mur;
	private int score;

	// CONSTRUCTEUR QUI PERMET D'INITALISER UNE PARTIE
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
	// NOUS DONNE LA LISTE DES CARREAUX JOUANLE EN FONCTION D'UNE CARTE

	public ArrayList<Carreau> carreauxJouables(Carte carte) {

		ArrayList<Carreau> listeCarreauJouable = new ArrayList<>();
		for (int i = 0; i < carreauxListe.nbCarreaux(); ++i)
			if (carte.correspondA(carreauxListe.getCarreau(i)))
				listeCarreauJouable.add(this.carreauxListe.getCarreau(i));

		return listeCarreauJouable;
	}

	public boolean lettreJouable(ArrayList<Carreau> listeCarreauJouable, char lettre) {
		boolean test = false;
		for (Carreau carreau : listeCarreauJouable)
			if (carreau.getLettre() == lettre) {
				test = true;
				break;
			}
		return test;
	}

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

	// PERMET D'AFFICHER LA LISTE DES CARREAUX JOUABLE DETERMINEE PAR LA FONCTION
	// PRECEDENTE
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

	// PERMET DE RETIRE IN CARREAU
	public void retirerCarreaux(char lettre) {
		carreauxListe.retirerCareauListe(lettre);
	}

	public void placerCarreau(char lettre, int positionX, int positionY, ArrayList<Carreau> listeCarreauJouable) {
		mur.placerCarreauSurMur(positionX, positionY, this.retrouverCarreau(lettre, listeCarreauJouable));
		// ON RETIRE LE CARREAU JOUER DE LA LISTE
		this.retirerCarreaux(lettre);
	}

	public Carreau retrouverCarreau(char lettre, ArrayList<Carreau> listeCarreauJouable) {
		for (Carreau carreau : listeCarreauJouable)
			if (carreau.getLettre() == lettre)
				return carreau;
		return null;
	}

	public String toStringMur() {
		return mur.toString();
	}

	public Carte piocher() throws Exception {
		return paquet.piocher();
	}

	public int getScore() {
		this.calculerCarteEcartee(paquet);
		this.calculerPointCarreauxPasPoseListe(carreauxListe);
		this.calculerPointNiveauComplet(mur);
		return score;
	}

	private void calculerPointNiveauComplet(Mur m) {
		final int NB_POINT_NIVEAU_COMPLET = 5;
		this.score += NB_POINT_NIVEAU_COMPLET * m.nombreNiveauComplet();
	}

	private void calculerPointCarreauxPasPoseListe(ListeCarreaux l) {
		this.score -= l.nbCarreaux();
	}

	private void calculerCarteEcartee(Paquet p) {
		this.score -= p.getCartesEcartees();
	}

	public void ecarteeCarte() {
		this.ecarteeCarte();
	}

	public boolean murPeutRecevoir(int X, int Y, Carreau carreau) throws Exception {
		return mur.peutRecevoir(X, Y, carreau);
	}

}
