package fr.thetilerteam;

public class FonctionMur {
	public static void afficherMur(Mur mur) {
		for (int j = mur.tailleYTableau() - 1; -1 < j; --j) {
			if (j < 10)
				System.out.print(" " + j);
			else
				System.out.print(j);

			for (int i = 0; i < mur.tailleXTableau(); i++) {
				if (mur.getMur(i, j) != 0) {
					System.out.print(mur.getMur(i, j));
				} else
					System.out.print(" ");
			}
			System.out.println();
		}
		System.out.print("  ");
		for (int i = 1; i < mur.tailleXTableau() + 1; i++) {
			System.out.print(i);
		}

	}

}
