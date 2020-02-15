package fr.thetilerteam;

import java.util.ArrayList;

public class ListeCarreaux {
	private ArrayList<Carreau> listeCarreaux;

	public ListeCarreaux() {
		// ON SPECIFIE LA LETTRE DU PREMIER CARREAU, LES AUTRES SERONT INCREMENTEE
		char c = 'a';
		// ON SPSPECIFIE LA TAILLE DE CHAQUE CARREAU
		// ON PEUT EN AJOUTER, EN SUPPRIMER, CHANGER L'ORDRE ET DONC LA LETTRE ET
		// CHANGER LES TAILLES (HAUTEUR MAX 3, SINON
		// PROBLEME AVEC L'AFFICHAGE DES CARREAUX JOUABLE CAR TABLEAU DE CHAR DE
		// HAUTEUR) --FIXABLE PAR DOUBLE ARRAYLIST, SI ON A LE TEMPS
		int[][] tailles = { { 1, 1 }, { 1, 2 }, { 2, 1 }, { 2, 2 }, { 1, 3 }, { 3, 1 }, { 2, 3 }, { 3, 2 }, { 3, 3 } };
		// ON CONSTRUIT LA LISTE DES DES CARREAUX
		listeCarreaux = new ArrayList<>();
		for (int[] taille : tailles)
			// ON STOCK CHAQUE CARREAU DANS LA LISTE AVEC CES PARAMETRES
			this.listeCarreaux.add(new Carreau(taille[0], taille[1], c++));

	}

	// METTRE EN MAJUSCULE LES LETTRE (POUR LES CARREAUX ROUGE)

	public ArrayList<Carreau> MettreLettreEnMaj() {
		// ON PARCOUR LA LISTE ET ON MET CHAQUE LETTRE EN MAJUSCULE
		for (Carreau car : this.listeCarreaux)
			car.mettreLettreEnMaj();
		return this.listeCarreaux;
	}

	// RECUPERER UN CARREAU

	public Carreau getCarreau(int numero) {
		return this.listeCarreaux.get(numero);
	}

	// RECUPERER LE NOMBRE DE CARREAU DANS LA LISTE

	public int nbCarreaux() {
		return this.listeCarreaux.size();
	}

	// PERMET DE RETIRER UN CARREAU DE LA LISTE

	public void retirerCareauListe(char lettre) {
		// ON CHERCHE LE CARREAU CORRESPONDANT A LA LETTRE QUI EST ENTREE
		for (int i = 0; i < this.nbCarreaux(); ++i) {
			if (this.getCarreau(i).getLettre() == lettre) {
				// ON SUPPRIME LE CARREAU
				this.listeCarreaux.remove(i);
			}
		}
	}

}
