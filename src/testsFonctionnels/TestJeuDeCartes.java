package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;

public class TestJeuDeCartes {

	public TestJeuDeCartes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		jeu.affichageJeuDeCartes();
		Carte[] c = jeu.donnerCartes();
//		for (int i = 0; i < c.length; i++) {
//			System.out.println(c.toString());
//		}
	}

}
