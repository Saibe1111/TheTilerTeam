/**
  * @file Mur.java
  * @author Iris CHAIX
  * @author Sébastien CUVELLIER
  * @version version 1 - 20/02/2020
  * @brief 	Classe Mur
 */

package fr.thetilerteam.logique;

import java.util.ArrayList;
import java.util.Arrays;

public class Mur {
	private ArrayList<char[]> mur;

	public Mur() {
		this.mur = new ArrayList<>();
	}

	public void ajoutLigne() {
		final int TAILLE_LARGEUR = 5;
		this.mur.add(new char[TAILLE_LARGEUR]);
		Arrays.fill(mur.get(tailleYTableau() - 1), ' ');
	}

	public char getMur(int x, int y) {
		return mur.get(y)[x];
	}

	public void setMur(int x, int y, char valeur) {
		while (y > mur.size() - 2) {
			this.ajoutLigne();
		}
		mur.get(y)[x] = valeur;
	}

	private int tailleXTableau() {
		return this.mur.get(0).length;
	}

	private int tailleYTableau() {
		return this.mur.size();
	}

	private boolean appartientAuMur(int x, int y) {
		return (x > 0 && x < this.tailleXTableau() + 1 && y > 0 && y < this.tailleYTableau() + 1);
	}

	public void placerCarreauSurMur(int x, int y, Carreau c) {
		for (int i = 0; i < c.getLargeur(); ++i) {
			for (int j = 0; j < c.getHauteur(); ++j) {
				this.setMur(x + i, y + j, c.getLettre());
			}
		}
	}

	// STRING QUI PERMET D'AFFICHER LE TABLEAU OU ON VEUT

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int j = this.tailleYTableau() - 1; -1 < j; --j) {

			if (j < 9)
				sb.append(" ").append(j + 1);
			else
				sb.append((j + 1));
			for (int i = 0; i < this.tailleXTableau(); i++) {

				sb.append(this.getMur(i, j));
			}

			sb.append("\n");
		}
		sb.append("  ");
		for (int i = 1; i < this.tailleXTableau() + 1; i++)
			sb.append(i);

		return sb.toString();
	}

	// PERMET DE CALCULER LE NOMBRE DE NIVEAU CALCULER POUR POUVOIR EN DEDUIR LE
	// SCORE POUR L'AFFICHAGE FINAL

	public int nombreNiveauComplet() {
		int nbNiveauComplet = 0;
		for (int y = 0; y < this.tailleYTableau(); ++y) {
			boolean Complet = true;
			for (int x = 0; x < this.tailleXTableau(); ++x) {
				if (mur.get(y)[x] == 0) {
					Complet = false;
					break;
				}
			}
			if (Complet)
				nbNiveauComplet++;
		}
		return nbNiveauComplet;
	}

	public boolean peutRecevoir(int X, int Y, Carreau carreau) throws Exception {
		if (!appartientAuMur(X, Y))
			throw new Exception("La position n'appartient pas au mur !");
		if (!caseVide(X - 1, Y - 1, carreau))
			throw new Exception("La case n'est pas vide !");
		if (!carreauAdjacent(X - 1, Y - 1, carreau))
			throw new Exception("Pas de carreau adajcent !");
		if (!carreauReposeSurBase(X - 1, Y - 1, carreau))
			throw new Exception(
					"Toute la base du carreau repose soit sur le bas de la zone à carreler, soit sur d’autres cartons.");
		if (!carreauClone(X - 1, Y - 1, carreau))
			throw new Exception("Le carreau ne doit pas cloner un autre carreau");
		return true;
	}

	// PERMET DE SAVOIR SI UNE CASE EST DEJA OCCUPEE PAR UN CARREAU
	// UTILE LORSQUE LE JOUEUR POSE UN CARREAU

	private boolean caseVide(int x, int y, Carreau c) {
		if (y < this.tailleYTableau()) {
			for (int i = x; i < x + c.getLargeur(); ++i)
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(i, j) != ' ')
						return false;
		} else {
			for (int i = x; i < x + c.getLargeur(); ++i)
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(i, j) != ' ')
						return false;
		}
		return true;
	}

	// Permet de savoir si le carreau est entouré d'un autre carreau
	private boolean carreauAdjacent(int x, int y, Carreau c) {
		// ON VERIFIE PAS LA GAUCHE DU TABLEAU SINON ON EN SORTIRAI
		if (x != 0) {
			// ON REGARDE SI ON A UN CARREAU SUR LA GAUCHE
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x - 1, j) != ' ')
						return true;
			} else {
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(x - 1, j) != ' ')
						return true;

			}
		}
		// ON VERIFIE PAS LA DROITE DU TABLEAU SINON ON EN SORTIRAI
		if (x + c.getLargeur() != this.tailleXTableau()) {
			// System.out.println("entree");
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x + c.getLargeur(), j) != ' ')
						return true;
			} else {
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(x + c.getLargeur(), j) != ' ')
						return true;

			}
		}
		// ON VERIFIE PAS LE BAS DU TABLEAU SINON ON EN SORTIRAI
		if (y != 0) {
			for (int j = x; j < x + c.getLargeur(); ++j)
				if (this.getMur(j, y - 1) != ' ')
					return true;
			// ON REGARDE SI ON A UN CARREAU EN DESSOUS
		}

		// IMPOSSIBLE D'AVOIR UN CARREAU AU DESSOUS SINON PROBLEME REGLE Figure 8
		return false;
	}

	private boolean carreauReposeSurBase(int x, int y, Carreau c) {
		// ON REGARDE SI ON A UN CARREAU EN DESSOUS
		if (y != 0) {
			for (int j = x; j < x + c.getLargeur(); ++j)
				if (this.getMur(j, y - 1) == ' ')
					return false;

		}
		return true;

	}

	private int cloneH1(int y, int x, Carreau c) {
		int h1 = 0;
		if (y + c.getHauteur() < this.tailleYTableau()) {
			for (int j = y; j < y + c.getHauteur(); ++j)
				if (this.getMur(x - 1, j) == this.getMur(x - 1, y))
					h1++;
		}
		return h1;
	}

	private int cloneH2(int y, int x, Carreau c) {
		int h2 = 0;
		if (x + c.getLargeur() != this.tailleXTableau())
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x + c.getLargeur(), j) == this.getMur(x + c.getLargeur(), y))
						h2++;
			}
		return h2;
	}

	private boolean carreauClone(int x, int y, Carreau c) {
		int h1 = 0;
		int h2 = 0;
		int l = 0;
		// System.out.println();
		if (y == 0) {
			if (x != 0) {
				h1 = this.cloneH1(y, x, c);
				System.out.println(h1);
				if (h1 == c.getHauteur())
					if (this.getMur(x - 1, y + h1) != this.getMur(x - 1, y))
						return false;
			}
			if (x + c.getLargeur() != this.tailleXTableau()) {
				h2 = this.cloneH2(y, x, c);

				if (h2 == c.getHauteur())
					if (this.getMur(x + c.getLargeur(), y + h2) != this.getMur(x + c.getLargeur(), y))
						return false;
			}

		} else {
			if (x == 0) {
				l = this.coloneL(y, x, c);
				if (l == c.getLargeur())
					if (this.getMur(x + c.getLargeur() - 1, y - 1) != this.getMur(x + c.getLargeur(), y - 1))
						return false;
			} else if (x + c.getLargeur() == tailleXTableau()) {
				l = this.coloneL(y, x, c);
				if (l == c.getLargeur())
					if (this.getMur(x, y - 1) != this.getMur(x - 1, y - 1))
						return false;
			} else {
				l = this.coloneL(y, x, c);
				if (l == c.getLargeur())
					if (this.getMur(x, y - 1) != this.getMur(x - 1, y - 1)
							&& this.getMur(x + c.getLargeur() - 1, y - 1) != this.getMur(x + c.getLargeur(), y - 1))
						return false;
			}
		}
		return true;
	}

	private int coloneL(int y, int x, Carreau c) {
		int l = 0;
		for (int j = x; j < x + c.getLargeur(); ++j)
			if (this.getMur(j, y - 1) == this.getMur(x, y - 1))
				l++;
		return l;
	}

}
