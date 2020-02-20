/**
  * @file Carte.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Carte
 */

package fr.thetilerteam;

public class Carte {
	private String nomCarte;
	private char TypeCarte;

	// DEFAULT

	public String getNomCarte() {
		return nomCarte;
	}

	public char getTypeCarte() {
		return TypeCarte;
	}

	public Carte(String nom, char type) {
		this.nomCarte = nom;
		this.TypeCarte = type;
	}

}
