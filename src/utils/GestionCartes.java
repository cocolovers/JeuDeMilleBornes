package utils;

import java.util.Iterator;
import java.util.Random;

public class GestionCartes {

	public static <T> T extraire(T[] liste) {
		Random random = new Random();
		int index = random.nextInt();
		T elem = liste[index];
		for (int i = index; i < liste.length; i++) {
			
		}
		return elem;
	}
}
