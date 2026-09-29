package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {

	private int nbCartes;
	private Carte[] cartes;
	private int nbOperations = 0;

	public Sabot(Carte[] cartes) {
		super();
		this.cartes = cartes;
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return (cartes.length == 0);
	}

	public void ajouterCarte(Carte carte) {
		if (nbCartes == 106)
			throw new IllegalArgumentException();
		cartes[nbCartes] = carte;
		nbOperations++;
	}

	public Carte piocher() {
		Iterator<Carte>iter = iterator();
		if (iter.hasNext()) {
			Carte c = iter.next();
			iter.remove();
			return c;
		} 
		return null;
	}
	

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsReference = nbOperations;

		private void verificationConcurrence() {
			if (nbOperations != nbOperationsReference)
				throw new ConcurrentModificationException();
		}
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i =indiceIterateur-1; i < nbCartes-1; i++) {
				cartes[i] = cartes[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperations++; nbOperationsReference++;
		}
	}
}
