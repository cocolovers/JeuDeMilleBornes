package testsFonctionnels;
import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Carte borne1 = new Borne(25);
		Carte borne2 = new Borne(25);
		Carte feuRouge1 = new Attaque(Type.FEU);
		Carte feuRouge2 = new Attaque(Type.FEU);
		Carte feuVert = new Parade(Type.FEU);
		
		System.out.println(borne1.equals(borne2));
		System.out.println(feuRouge1.equals(feuRouge2));
		System.out.println(feuRouge1.equals(feuVert));
	}

}
