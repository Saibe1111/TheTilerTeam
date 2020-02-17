package fr.thetilerteam;

import java.util.ArrayList;

public class Mur {
	private ArrayList<char[]> mur;

	public Mur() {
		this.mur = new ArrayList<char[]>();
	}

	public void ajoutLigne() {
		this.mur.add(new char[5]);
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
	
	
	public boolean appartientAuMur(int x, int y) {
		return (x > 0 && x < this.tailleXTableau() + 1 && y > 0 && y < this.tailleYTableau() + 1 );
	}

	public void placerCarreauSurMur(int x, int y, Carreau c) {
		for (int i = 0; i < c.getLargeur(); ++i) {
			for (int j = 0; j < c.getHauteur(); ++j) {
				this.setMur(x + i, y + j, c.getLettre());
			}
		}
	}

	// STRING QUI PERMET D'AFFICHER LE TABLEAU OU ON VEUT

	public String toStringMur() {

		// utilisation StringBuilder
		// https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html

		StringBuilder sb = new StringBuilder();

		for (int j = this.tailleYTableau() - 1; -1 < j; --j) {

			if (j < 9)
				sb.append(" " + (j + 1));
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

	public int nombreNiveauComplet() {
		int nbNiveauComplet = 0;
		for(int y = 0; y < this.tailleYTableau(); ++y) {
			boolean Complet = true;
			for(int x = 0; x < this.tailleXTableau(); ++x) {
				if (mur.get(y)[x] == 0) 
					Complet = false;
			}
			if (Complet)
				nbNiveauComplet++;
		}
		return nbNiveauComplet;
	}

	public boolean caseVide(int x, int y, Carreau c) {
		if (y < this.tailleYTableau()) {
			for (int i = x; i < x + c.getLargeur(); ++i) {
				for (int j = y; j < this.tailleYTableau(); ++j) {
					if (this.getMur(i, j) != 0) {
						return false;
					}
				}
			}
		} else {
			for (int i = x; i < x + c.getLargeur(); ++i) {
				for (int j = y; j < y + c.getHauteur(); ++j) {
					if (this.getMur(i, j) != 0) {
						return false;
					}
					}
				}
		}
		return true;
	}

	// Permet de savoir si le carreau est entouré d'un autre carreau
	public boolean carreauAdjacent(int x, int y, Carreau c) {
		// ON VERIFIE PAS LA GAUCHE DU TABLEAU SINON ON EN SORTIRAI
		if (x != 0) {
			// ON REGARDE SI ON A UN CARREAU SUR LA GAUCHE
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x - 1, j) != 0)
						return true;
			} else {
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(x - 1, j) != 0)
						return true;

			}
		}
		// ON VERIFIE PAS LA DROITE DU TABLEAU SINON ON EN SORTIRAI
		if (x + c.getLargeur() != this.tailleXTableau()) {
			System.out.println("entree");
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x + c.getLargeur(), j) != 0)
						return true;
			} else {
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(x + c.getLargeur(), j) != 0)
						return true;

			}
		}
		// ON VERIFIE PAS LE BAS DU TABLEAU SINON ON EN SORTIRAI
		if (y != 0) {
			for (int j = x; j < x + c.getLargeur(); ++j)
				if (this.getMur(j, y - 1) != 0)
					return true;
			// ON REGARDE SI ON A UN CARREAU EN DESSOUS
		}
		
		// IMPOSSIBLE D'AVOIR UN CARREAU AU DESSOUS SINON PROBLEME REGLE Figure 8
		return false;
	}

	public boolean carreauReposeSurBase(int x, int y, Carreau c) {
		// ON REGARDE SI ON A UN CARREAU EN DESSOUS
		if (y != 0) {
			for (int j = x; j < x + c.getLargeur(); ++j)
				if (this.getMur(j, y - 1) == 0)
					return false;

		}
		return true;

	}

	public boolean carreauClone(int x, int y, Carreau c) {
		boolean test = true;
		int h1 = 0;
		int h2 = 0;
		int l = 0;
		// ON VERIFIE PAS LA GAUCHE DU TABLEAU SINON ON EN SORTIRAI

		if (x != 0) {
			// ON REGARDE SI ON A UN CARREAU SUR LA GAUCHE
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x - 1, j) != this.getMur(x - 1, y))
						h1++;
			} else {
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(x - 1, j) != this.getMur(x - 1, y))
						h1++;

			}
		}
		// ON VERIFIE PAS LA DROITE DU TABLEAU SINON ON EN SORTIRAI
		if (x + c.getLargeur() != this.tailleYTableau()) {
			if (y + c.getHauteur() < this.tailleYTableau()) {
				for (int j = y; j < y + c.getHauteur(); ++j)
					if (this.getMur(x + c.getLargeur() - 1, j) != this.getMur(x + c.getLargeur() - 1, y))
						h2++;
			} else {
				for (int j = y; j < this.tailleYTableau(); ++j)
					if (this.getMur(x + c.getLargeur() - 1, j) != this.getMur(x + c.getLargeur() - 1, y))
						h2++;

			}
		}
		// ON VERIFIE PAS LE BAS DU TABLEAU SINON ON EN SORTIRAI
		if (y != 0) {
			for (int j = x; j < x + c.getLargeur(); ++j)
				if (this.getMur(j, y - 1) != this.getMur(x, y - 1))
					l++;
			// ON REGARDE SI ON A UN CARREAU EN DESSOUS
		}
		System.out.println();
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(l);
		System.out.println();
		System.out.println();

		// this.getMur(x + c.getLargeur() - 1, y);
		// this.getMur(x - 1, y);
		// IMPOSSIBLE D'AVOIR UN CARREAU AU DESSOUS SINON PROBLEME REGLE Figure 8
		return test;
	}

}
