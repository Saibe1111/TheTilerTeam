/**
 * @file Carte.java
 * @author Iris CHAIX
 * @author Sébastien CUVELLIER
 * @version version 1 - 20/02/2020
 * @brief Classe Carte
 */

package fr.thetilerteam.logique;

public class Carte {

	// ON DEFINIT LES ATTRIBUT DE LA CLASSE CARTE
    private Couleur couleur;
    private int taille;

	/**
	 * CONSTRUCTEUR CARTE COULEUR
	 * 
	 * @param couleur, couleur de la carte
	 */
    public Carte(Couleur couleur) {
    	this.couleur = couleur;
	}

	/**
	 * CONSTRUCTEUR CARTE TAILLE
	 * 
	 * @param taille, taille de la carte
	 */
    public Carte(int taille) {
    	this.taille = taille;
	}

	/**
	 * PERMET DE SAVOIR SI UN CARREAU CORRESPOND A UNE CARTE
	 * 
	 * @param c, carreau qu'on veut tester
	 * @return boolean, si le carreau correspond a la carte
	 */
    public boolean correspondA(Carreau c) {

    	if(this.couleur == Couleur.BLEU)
			return c.getCouleur() == Couleur.BLEU;
    	else if (this.couleur == Couleur.ROUGE)
			return c.getCouleur() == Couleur.ROUGE;
    	else
			return c.carreauTailleN(taille);
    }

	/**
	 * TO STRING CARTE PIOCHEE
	 * 
	 * @return une string avec dedans la carte piochée
	 */
	public String toString() {
		if(this.couleur == Couleur.BLEU || this.couleur == Couleur.ROUGE)
			return "Carte piochée: " + this.couleur + "\nVoici la liste des carreaux utilisable:";
		else
			return "Carte piochée: Taille " + this.taille + "\nVoici la liste des carreaux utilisable:";
    }

}
