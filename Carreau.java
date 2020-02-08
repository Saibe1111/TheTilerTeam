package fr.thetilerteam;

public class Carreau {

	private int hauteur;
	private int largeur;
	private char lettre;

	// DEFAULT

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

	// TEMPORAIRE POUR TEST

	public String AfficherCarreau() {
		return this.getLargeur() + " " + this.getHauteur() + " " + this.getLettre();
	}

	// CARREAU DE TAILLE N

	public boolean CarreauTailleN(int n) {
		return n == this.getLargeur() || n == this.getHauteur();
	}

	// METTRE EN MAJUSCULE LES LETTRE (POUR LES CARREAUX ROUGE

	public void MettreLettreEnMaj() {
		this.lettre = Character.toUpperCase(this.lettre);
	}

}
