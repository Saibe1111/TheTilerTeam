package fr.thetilerteam;

import java.util.ArrayList;

public class Mur {
	private ArrayList<char[]> mur;

	public Mur() {
		this.mur = new ArrayList();
	}

	public void ajoutLigne() {
		this.mur.add(new char[5]);
	}

	public char getMur(int x, int y) {
		return mur.get(y)[x];
	}

	public void setMur(int x, int y, String valeur) {
		while (y > mur.size() - 2) {
			this.ajoutLigne();
		}
		char test[] = mur.get(y);
		test[x] = valeur.charAt(0);
		mur.set(y, test);
	}

	public int tailleXTableau() {
		return this.mur.get(0).length;
	}

	// STRING QUI PERMET D'AFFICHER LE TABLEAU OU ON VEUT

	public String ToStringMur() {

		// utilisation StringBuilder
		// https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html

		StringBuilder sb = new StringBuilder();

		for (int j = this.mur.size() - 1; -1 < j; --j) {

			if (j < 10)
				sb.append(" " + j);
			else
				sb.append(j);
			for (int i = 0; i < this.tailleXTableau(); i++) {

				if (this.getMur(i, j) != 0) {
					sb.append(this.getMur(i, j));
				} else
					sb.append(" ");
			}

			sb.append("\n");
		}
		sb.append("  ");
		for (int i = 1; i < this.tailleXTableau() + 1; i++)
			sb.append(i);

		return sb.toString();
	}

}
