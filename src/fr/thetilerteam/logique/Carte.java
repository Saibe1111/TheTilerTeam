/**
  * @file Carte.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Carte
 */

package fr.thetilerteam.logique;

public class Carte {
	private String nomCarte;
	private char TypeCarte;

	// DEFAULT
	public Carte(String nom, char type) {
		this.nomCarte = nom;
		this.TypeCarte = type;
	}

	public String getNomCarte() {
		return nomCarte;
	}

	public char getTypeCarte() {
		return TypeCarte;
	}

}
