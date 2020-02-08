package fr.thetilerteam;

public class Mur {
	private int[][] mur;

	public Mur() {
		this.mur = new int[7][10];
		this.initialiserTableau();
	}

	public void initialiserTableau() {
		this.mur[5][0] = this.mur.length;
		this.mur[6][0] = this.mur[0].length;
	}

	public int getMur(int x, int y) {
		return this.mur[x][y];
	}

}
