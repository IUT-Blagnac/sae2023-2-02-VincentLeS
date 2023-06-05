package exercice.Travaux.SoM10;

import java.util.List;
import java.util.ArrayList;

public class Exercice {
	public static List<String> solution(String texte, List<Character> ordre) {

		String[] mots = (texte.trim()).split("[^a-zA-Z]+");// Pour éviter l'exception relevé si le texte commence par un vide

		List<String> motsEnOrdre = new ArrayList<>();
		List<String> motsRestants = new ArrayList<>();

		for (String mot : mots) {
            motsRestants.add(mot);
        }

		for (char c : ordre) {
			for (String mot : mots) {
				
				if (!motsRestants.contains(mot)) {
					continue;
				}
				
				if (Character.toLowerCase(mot.charAt(0)) == Character.toLowerCase(c)) {
					motsEnOrdre.add(mot);
					motsRestants.remove(mot);
				}
			}
		}
		
		motsEnOrdre.addAll(motsRestants);
		return motsEnOrdre;
		
	}
}