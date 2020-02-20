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
		this.hauteur = hauteur;
	}

	// LONGUEUR

	public int getLargeur() {
		return this.largeur;
	}

	private void setLargeur(int largeur) {
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
		return n == this.getLargeur() || n == this.getHauteur();
	}

	// METTRE EN MAJUSCULE LES LETTRE (POUR LES CARREAUX ROUGE

	public void mettreLettreEnMaj() {
		this.lettre = Character.toUpperCase(this.lettre);
	}

	public boolean testCareau(char c) {
		switch (c) {
		case 'B':
			if (Character.isUpperCase(this.lettre))
				return false;
			else
				return true;
		case 'R':
			if (Character.isUpperCase(this.lettre))
				return true;
			else
				return false;
		case '1':
			if (this.carreauTailleN(1))
				return true;
			else
				return false;
		case '2':
			if (this.carreauTailleN(2))
				return true;
			else
				return false;
		case '3':
			if (this.carreauTailleN(3))
				return true;
			else
				return false;
		default:
			return false;
		}

	}
}