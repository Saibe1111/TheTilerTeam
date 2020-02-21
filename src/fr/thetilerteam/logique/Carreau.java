/**
  * @file Carreau.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Carreau
 */

package fr.thetilerteam.logique;

public class Carreau {

	private int hauteur;
	private int largeur;
	private char lettre;

	// CONSTRUCTEUR
	public Carreau(int largeur, int hauteur, char lettre) {
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setLettre(lettre);
	}

	// HAUTEUR

	public int getHauteur() {
		return this.hauteur;
	}

	private void setHauteur(int hauteur) {
		assert hauteur > 0 : "Impossible que la hauteur soit null ou négatif";
		this.hauteur = hauteur;
	}

	// LONGUEUR

	public int getLargeur() {
		return this.largeur;
	}

	private void setLargeur(int largeur) {
		assert largeur > 0 : "Impossible que la largeur soit null ou négatif";
		this.largeur = largeur;
	}

	// LETTRE
	public char getLettre() {
		return this.lettre;
	}
	private void setLettre(char lettre) {
		this.lettre = lettre;
	}

	// CARREAU DE TAILLE N
	public boolean carreauTailleN(int n) {
		assert n > 0 : "Impossible que n soit null ou négatif";
		return n == this.getLargeur() || n == this.getHauteur();
	}

	// METTRE EN MAJUSCULE LES LETTRE (POUR LES CARREAUX ROUGE
	public void mettreLettreEnMaj() {
		this.lettre = Character.toUpperCase(this.lettre);
	}

	public boolean carteTestCarreau(char c) {
		switch (c) {
		case 'B':
			return !Character.isUpperCase(this.lettre);
		case 'R':
			return Character.isUpperCase(this.lettre);
		case '1':
			return this.carreauTailleN(1);
		case '2':
			return this.carreauTailleN(2);
		case '3':
			return this.carreauTailleN(3);
		default:
			return false;
		}

	}
}