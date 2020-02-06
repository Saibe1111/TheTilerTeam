package fr.thetilerteam;

public class Carte {
	String nomCarte;
	char TypeCarte;

	public Carte(String nom, char type) {
		this.nomCarte = nom;
		this.TypeCarte = type;
	}

	public String getNomCarte() {
		return this.nomCarte;
	}

	public String AfficherCarte() {
		return this.nomCarte + " " + this.TypeCarte;
	}

}
