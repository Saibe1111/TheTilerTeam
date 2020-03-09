/**
 * @file Carreau.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Carreau
 */

package fr.thetilerteam.logique;

public class Carreau {
	// ON DEFINIT LES ATTRIBUT DE LA CLASSE CARREAU
	private Couleur couleur;
	private int hauteur;
	private int largeur;
	private char lettre;

	/**
	 * CONSTRUCTEUR
	 * 
	 * @param largeur, largeur du carreau
	 * @param hauteur, hauteur du carreau
	 * @param lettre,  lettre du carreau
	 * @param couleur, couleur du carreau
	 */

	public Carreau(int largeur, int hauteur, char lettre, Couleur couleur) {
		// ON GERE LES POSSIBLES EXEPTIONS
		if (largeur <= 0)
			throw new IllegalArgumentException();
		if (hauteur <= 0)
			throw new IllegalArgumentException();
		// ON INTEGRE LES DIFFERENTES VALEURS DU NOUVEAU CARREAU
		this.couleur = couleur;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.lettre = lettre;
	}

	/**
	 * HAUTEUR GETTER
	 * 
	 * @return hauteur, hauteur du carreau
	 */
	public int getHauteur() {
		return this.hauteur;
	}

	/**
	 * LONGUEUR GETTER
	 * 
	 * @return largeur, largeur du carreau
	 */
	public int getLargeur() {
		return this.largeur;
	}

	/**
	 * LETTRE GETTER
	 * 
	 * @return lettre, lettre du carreau
	 */
	public char getLettre() {
		return this.lettre;
	}

	/**
	 * COULEUR GETTER
	 * 
	 * @return couleur, couleur du carreau
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}

	/**
	 * CARREAU DE TAILLE N
	 * 
	 * @param n, taille a comparer au carreau
	 * @return boolean, return true si le carreau a la hauteur ou la largeur égale à
	 *         n
	 */
	public boolean carreauTailleN(int n) {
		// ON GERE LES POSSIBLES EXEPTIONS
		if (n <= 0)
			throw new IllegalArgumentException();
		// ON RETURN TRUE SI LE CARREAU EST DE TAILLE N
		return n == this.getLargeur() || n == this.getHauteur();
	}

}