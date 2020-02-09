package fr.thetilerteam;

public class Mur {
	private char[][] mur;

	public Mur() {
		this.mur = new char[5][12];
	}

	public char getMur(int x, int y) {
		return this.mur[x][y];
	}

	public void setMur(int x, int y, String valeur) {
		this.mur[x][y] = valeur.charAt(0);
	}

	public int tailleXTableau() {
		return this.mur.length;
	}

	public int tailleYTableau() {
		return this.mur[0].length;
	}
	
	
	public String ToStringMur() {
		
		//utilisation StringBuilder https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
		
		StringBuilder sb = new StringBuilder();
		
		for (int j = this.tailleYTableau() - 1; -1 < j; --j) {
			
			if (j < 10)
				sb.append(" "+ j);
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
