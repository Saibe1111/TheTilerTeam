package fr.thetilerteam;

public class Carte {
	private String nomCarte;
	private char TypeCarte;

	// DEFAULT

	public String getNomCarte() {
		return nomCarte;
	}

	public char getTypeCarte() {
		return TypeCarte;
	}

	public Carte(String nom, char type) {
		this.nomCarte = nom;
		this.TypeCarte = type;
	}

}
