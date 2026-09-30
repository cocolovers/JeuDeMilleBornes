package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = { new Configuration(10, new Borne(25)),
			new Configuration(10, new Borne(50)), new Configuration(10, new Borne(75)),
			new Configuration(12, new Borne(100)), new Configuration(4, new Borne(200)),
			new Configuration(14, new Parade(Type.FEU)), new Configuration(6, new FinLimite()),
			new Configuration(6, new Parade(Type.ESSENCE)), new Configuration(6, new Parade(Type.CREVAISON)),
			new Configuration(6, new Parade(Type.ACCIDENT)), new Configuration(5, new Attaque(Type.FEU)),
			new Configuration(4, new DebutLimite()), new Configuration(3, new Attaque(Type.ESSENCE)),
			new Configuration(3, new Attaque(Type.CREVAISON)), new Configuration(3, new Attaque(Type.ACCIDENT)),
			new Configuration(1, new Botte(Type.FEU)), new Configuration(1, new Botte(Type.ESSENCE)),
			new Configuration(1, new Botte(Type.CREVAISON)), new Configuration(1, new Botte(Type.ACCIDENT)), };

	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			nbCartes += typesDeCartes[i].getNbExemplaires();
		}
		Carte[] cartes = new Carte[nbCartes];
		int a = 0;
		for (int i = 0; i < typesDeCartes.length; i++) {
			for (int j = 0; j < typesDeCartes[i].nbExemplaires; j++) {
				cartes[a + j] = typesDeCartes[i].carte;
			}
			a += typesDeCartes[i].nbExemplaires;
		}
		return cartes;
	}

	public boolean checkCount(Carte[] cartes) {
//		int countBorne50, countBorne75, countBorne100, countBorne200 = 0;
//		int countFeuVert, countFinLim, countBidon, countRoueSecours, countReparation = 0;
//		int countFeuRouge, countLim, countPanneEssence, countCrevaison, countAccident = 0;
//		int countPrioritaire, countCiterne, countIncrevable, countAsVolant = 0;
//		
		for (int i = 0; i < typesDeCartes.length; i++) {
			for (int j = 0; j < typesDeCartes[i].nbExemplaires; j++) {
				Carte carte = cartes[i];
				if (!carte.equals(typesDeCartes[i].getCarte()))
					return false;
			}
		}
		return true;
		
	}
	
	public void affichageJeuDeCartes() {
		for (int i = 0; i < typesDeCartes.length; i++) {
			System.out.println(typesDeCartes[i].getNbExemplaires() + " " + typesDeCartes[i].getCarte().toString());
		}
	}

	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(int nbExemplaires, Carte carte) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		};

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}

}
