/**
  * @file Score.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Score
 */

package fr.thetilerteam.logique;

public class Score {
	private int scores;

	public Score() {
		scores = 0;
	}

	public int getScore(ListeCarreaux listeRouge, ListeCarreaux listeBleu, Paquet p, Mur m) {
		this.calculerCarteEcartee(p);
		this.calculerPointCarreauxPasPoseListe(listeRouge);
		this.calculerPointCarreauxPasPoseListe(listeBleu);
		this.calculerPointNiveauComplet(m);
		return scores;
	}

	private void calculerPointNiveauComplet(Mur m) {
		this.scores += 5 * m.nombreNiveauComplet();
	}

	private void calculerPointCarreauxPasPoseListe(ListeCarreaux l) {
		this.scores -= l.nbCarreaux();

	}

	private void calculerCarteEcartee(Paquet p) {
		this.scores -= p.getCartesEcartees();
	}

}
