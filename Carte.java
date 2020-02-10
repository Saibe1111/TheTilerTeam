package fr.thetilerteam;

public class Carte {
	String nomCarte;
	char TypeCarte;

	// DEFAULT

	public Carte(String nom, char type) {
		this.nomCarte = nom;
		this.TypeCarte = type;
	}

	// TEMPORAIRE POUR TEST

	public String AfficherCarte() {
		return this.nomCarte + " " + this.TypeCarte;
	}

}
