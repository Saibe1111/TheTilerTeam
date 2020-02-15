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

	public int tailleXTableau() {
		return this.mur.get(0).length;
	}
	
	public int tailleYTableau() {
		return this.mur.size();
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

		for (int j = this.mur.size() - 1; -1 < j; --j) {

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

}
