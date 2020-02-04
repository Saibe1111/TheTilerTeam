package fr.thetilerteam;

public class Carreau {

	// HAUTEUR

	private int hauteur;

	private int getHauteur() {
		return this.hauteur;
	}

	private void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	// LONGUEUR

	private int longueur;

	private int getLongueur() {
		return this.longueur;
	}

	private void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	// LETTRE

	private char lettre;

	private char getLettre() {
		return this.lettre;
	}

	private void setLettre(char lettre) {
		this.lettre = lettre;
	}

	private void EnregistrerCarreau(int longueur, int hauteur, char lettre) {
		this.setLongueur(longueur);
		this.setHauteur(hauteur);
		this.setLettre(lettre);
	}

}
