package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Sabot sabot = new Sabot(jeu.donnerCartes());
		System.out.println(jeu.checkCount(jeu.donnerCartes()));

//		sabot.piocher();
		for (Iterator<Carte> iter = sabot.iterator(); iter.hasNext();) {
			Carte carte = sabot.piocher();
//			System.out.println("Je pioche " + carte.toString());
//			sabot.ajouterCarte(new Botte(Type.ACCIDENT));
//			Carte carte = iter.next();
			System.out.println("Je pioche " + carte.toString());
			sabot.piocher();
//			iter.remove();
		}
	}

}
