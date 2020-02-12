package fr.thetilerteam;

import java.util.ArrayList;
import java.util.Random;

public class Jeux {
	private Paquet paquet;
	private ListeCarreaux carreauxRouge;
	private ListeCarreaux carreauxBleu;
	private Mur mur;

	public Jeux() {
		paquet = new Paquet();
		carreauxRouge = new ListeCarreaux();
		carreauxRouge.MettreLettreEnMaj();
		carreauxBleu = new ListeCarreaux();
		mur = new Mur();
		Random r = new Random();
		int valeur = r.nextInt(4);
		switch (valeur) {
		case 0:
			Carreau carreauVert = new Carreau(1, 3, 'x');
			mur.placerCarreauSurMur(0, 0, carreauVert);
			break;

		case 1:
			Carreau carreauVert1 = new Carreau(3, 1, 'x');
			mur.placerCarreauSurMur(0, 0, carreauVert1);
			break;
		case 2:
			Carreau carreauVert2 = new Carreau(1, 3, 'x');
			mur.placerCarreauSurMur(4, 0, carreauVert2);
			break;
		case 3:
			Carreau carreauVert3 = new Carreau(3, 1, 'x');
			mur.placerCarreauSurMur(2, 0, carreauVert3);
			break;
		}
	}

	public Mur getMur() {
		return mur;
	}

	public ArrayList<Carreau> carreauJouable(Carte carte) {
		ArrayList<Carreau> listeCarreauJouable = new ArrayList<Carreau>();
		for (int i = 0; i < carreauxBleu.nbCarreaux(); ++i) {
			if (carreauxBleu.getCarreau(i).testCareau(carte.TypeCarte)) {
				listeCarreauJouable.add(this.carreauxBleu.getCarreau(i));
			}
		}
		for (int i = 0; i < carreauxRouge.nbCarreaux(); ++i) {
			if (carreauxRouge.getCarreau(i).testCareau(carte.TypeCarte)) {
				listeCarreauJouable.add(this.carreauxRouge.getCarreau(i));
			}
		}
		return listeCarreauJouable;

	}

	public String toStringCarreauJouable(ArrayList<Carreau> listeCarreauJouable) {
		StringBuilder sb = new StringBuilder();
		ArrayList<char[]> tab;
		tab = new ArrayList<char[]>();
		int r = 0;
		for (int i = 0; i < listeCarreauJouable.size(); ++i) {
			for (int k = 0; listeCarreauJouable.get(i).getLargeur() > k; ++k) {
				tab.add(new char[3]);
				for (int j = 0; listeCarreauJouable.get(i).getHauteur() > j; ++j) {
					tab.get(r)[j] = listeCarreauJouable.get(i).getLettre();
				}
				r++;
			}
			r++;
			tab.add(new char[3]);
		}

		// STRING BUILDER

		for (int i = tab.get(0).length - 1; i >= 0; --i) {
			for (int j = 0; j < tab.size(); ++j) {
				sb.append(tab.get(j)[i]);
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	public void retirerCarreaux(int index, char couleur) {
		switch (couleur) {
		case 'R':
			carreauxRouge.retirerCareauListe(index);
			break;

		case 'B':
			carreauxBleu.retirerCareauListe(index);
			break;
		}

	}

	public void placerCarreau(char Lettre, int positionX, int positionY, ArrayList<Carreau> listeCarreauJouable) {
		for (int i = 0; i < listeCarreauJouable.size(); i++)
			if (listeCarreauJouable.get(i).getLettre() == Lettre)
				mur.placerCarreauSurMur(positionX, positionY, listeCarreauJouable.get(i));
	}
}
