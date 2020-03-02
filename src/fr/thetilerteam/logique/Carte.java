/**
 * @file Carte.java
 * @author Iris CHAIX
 * @author Sébastien CUVELLIER
 * @version version 1 - 20/02/2020
 * @brief Classe Carte
 */

package fr.thetilerteam.logique;

public class Carte {
    private Couleur couleur;
    private int taille;

    // DEFAULT
    public Carte(Couleur couleur) {
    	this.couleur = couleur;
	}

    public Carte(int taille) {
    	this.taille = taille;
	}


    public boolean correspondA(Carreau c) {

    	if(this.couleur == Couleur.BLEU)
			return c.getCouleur() == Couleur.BLEU;
    	else if (this.couleur == Couleur.ROUGE)
			return c.getCouleur() == Couleur.ROUGE;
    	else
			return c.carreauTailleN(taille);
    }

	public String toString() {
		if(this.couleur == Couleur.BLEU || this.couleur == Couleur.ROUGE)
			return "Carte piochée: " + this.couleur + "\nVoici la liste des carreaux utilisable:";
		else
			return "Carte piochée: Taille " + this.taille + "\nVoici la liste des carreaux utilisable:";
    }

}
