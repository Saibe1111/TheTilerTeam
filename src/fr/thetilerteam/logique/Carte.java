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
	private char typeCarte;

	// DEFAULT
	public Carte(String nom, char type) {
		this.nomCarte = nom;
		this.typeCarte = type;
	}

	public String getNomCarte() {
		return nomCarte;
	}

	public char getTypeCarte() {
		return typeCarte;
	}

}
