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

	public Carreau(int largeur, int hauteur, char lettre,Couleur couleur) {
		assert hauteur > 0;
		assert largeur >0;
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
		assert n > 0 : "Impossible que n soit null ou négatif";
		return n == this.getLargeur() || n == this.getHauteur();
	}

}