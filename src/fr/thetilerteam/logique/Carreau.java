/**
 * @file Carreau.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Carreau
 */

package fr.thetilerteam.logique;

public class Carreau {

	private Couleur couleur;
	private int hauteur;
	private int largeur;
	private char lettre;

	// CONSTRUCTEUR

	public Carreau(int largeur, int hauteur, char lettre, Couleur couleur) {
		if (largeur <= 0)
			throw new IllegalArgumentException();
		if (hauteur <= 0)
			throw new IllegalArgumentException();
		this.couleur = couleur;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.lettre = lettre;
	}

	// HAUTEUR

	public int getHauteur() {
		return this.hauteur;
	}

	// LONGUEUR

	public int getLargeur() {
		return this.largeur;
	}

	// LETTRE
	public char getLettre() {
		return this.lettre;
	}

	// COULEUR
	public Couleur getCouleur() {
		return this.couleur;
	}

	// CARREAU DE TAILLE N
	public boolean carreauTailleN(int n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		return n == this.getLargeur() || n == this.getHauteur();
	}

}