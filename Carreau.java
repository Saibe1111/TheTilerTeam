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

	private int largeur;

	private int getLargeur() {
		return this.largeur;
	}

	private void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	// LETTRE

	private char lettre;

	private char getLettre() {
		return this.lettre;
	}

	private void setLettre(char lettre) {
		this.lettre = lettre;
	}

	public void EnregistrerCarreau(int largeur, int hauteur, char lettre) {
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setLettre(lettre);
	}

	public String AfficherCarreau() {
		return this.getLargeur() + " " + this.getHauteur() + " " + this.getLettre();
	}

}
