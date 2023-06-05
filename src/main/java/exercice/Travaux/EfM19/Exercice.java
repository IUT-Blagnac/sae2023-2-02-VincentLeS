package exercice.Travaux.EfM19;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> words = textToArray(str);
        words = sortWordsByOrder(words, ordre);
        return words;
    }

    /**
     * Classe un tableau de mots selon un ordre donné
     * 
     * @param list  le tableau de mots à trier
     * @param order l'ordre à utiliser pour le tri
     * @return
     */
    public static List<String> sortWordsByOrder(List<String> mots, List<Character> ordre) {
        List<String> motsTries = new ArrayList<>();
        LinkedHashSet<String> motsInconnus = new LinkedHashSet<>();

        for (char c : ordre) {
            for (String mot : mots) {
                if (mot.length() > 0 && mot.charAt(0) == c) {
                    motsTries.add(mot);
                }
            }
        }

        for (String mot : mots) {
            if (mot.length() == 0 || !ordre.contains(mot.charAt(0))) {
                motsInconnus.add(mot);
            }
        }

        motsTries.addAll(motsInconnus);

        return motsTries;
    }

    /**
     * Converti un texte en tableau de mots (séparateur : espace)
     *
     * @param text le texte à convertir
     * @return Tableau des mots du texte
     */
    public static List<String> textToArray(String text) {


        // Supprimer les caractères spéciaux et les espaces inutiles
        text = text.replaceAll("[^a-zA-Z0-9]+", " ").trim();
        String word = "";
        List<String> mots = new ArrayList<>();

        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);

            if (character == ' ') {
                mots.add(word.trim());
                word = "";
            }

            word += character;
        }

        if (!word.isEmpty()) {
            mots.add(word.trim());
        }

        return mots;
    }

    

    /**
     * Affiche tous les éléments du tableau donné.
     *
     * @param list Tableau d'éléments à afficher
     */
    public static void printList(List<String> list) {
        String result = "(";

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
            if (i < list.size() - 1) {
                result += ", ";
            }
        }

        result += ")";
        System.out.println(result);
    }

}
