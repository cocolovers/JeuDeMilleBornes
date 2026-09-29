package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = {new Configuration(10, new Borne(25)),
			new Configuration(10, new Borne(50)),
			new Configuration(10, new Borne(75)),
			new Configuration(12, new Borne(100)),
			new Configuration(4, new Borne(200)),
			new Configuration(14, new Parade(Type.FEU)),
			new Configuration(6, new FinLimite()),
			new Configuration(6, new Parade(Type.ESSENCE)),
			new Configuration(6, new Parade(Type.CREVAISON)),
			new Configuration(6, new Parade(Type.ACCIDENT)),
			new Configuration(5, new Attaque(Type.FEU)),
			new Configuration(4, new DebutLimite()),
			new Configuration(3, new Attaque(Type.ESSENCE)),
			new Configuration(3, new Attaque(Type.CREVAISON)),
			new Configuration(3, new Attaque(Type.ACCIDENT)),
			new Configuration(1, new Botte(Type.FEU)),
			new Configuration(1, new Botte(Type.ESSENCE)),
			new Configuration(1, new Botte(Type.CREVAISON)),
			new Configuration(1, new Botte(Type.ACCIDENT)),
	};
	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[106];
		int a = 0;
		for (int i=0; i<19; i++) {
			for (int j = 0; j < typesDeCartes[i].nbExemplaires; j++) {
				cartes[a+j] = typesDeCartes[i].carte;
			}
			a+=typesDeCartes[i].nbExemplaires;
		}
		return cartes;
	}

	public void affichageJeuDeCartes() {
		for (int i = 0; i < typesDeCartes.length; i++) {
			System.out.println(typesDeCartes[i].getNbExemplaires() + " "+
					typesDeCartes[i].getCarte().toString());
		}
	}

	private static class Configuration {
		private int nbExemplaires;
		private Carte carte;

		private Configuration(int nbExemplaires, Carte carte) {
			super();
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
