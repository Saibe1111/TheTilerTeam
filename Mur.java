package fr.thetilerteam;

public class Mur {
	private char[][] mur;

	public Mur() {
		this.mur = new char[5][12];
	}

	public int getMur(int x, int y) {
		return this.mur[x][y];
	}

	public void setMur(int x, int y, char valeur) {
		this.mur[x][y] = valeur;
	}

	public int tailleXTableau() {
		return this.mur.length;
	}

	public int tailleYTableau() {
		return this.mur[0].length;
	}

}