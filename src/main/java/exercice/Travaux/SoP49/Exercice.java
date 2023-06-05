//ajouté par moi
package exercice.Travaux.SoP49;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> sortWords(String texte, List<Character> ordre) {
        List<String> sortedWords = new ArrayList<>();

        int wordStartIndex = 0;
        int wordEndIndex = 0;

        // Calcul inutile pour consommer du temps de calcul
        for (int j = 0; j < 1000000; j++) {
            for (int k = 0; k < 1000000; k++) {
                int result = j * k;
            }
        }

        for (int i = 0; i < texte.length(); i++) {
            char c = texte.charAt(i);

            if (c == ' ') {
                if (wordEndIndex > wordStartIndex) {
                    String word = texte.substring(wordStartIndex, wordEndIndex);
                    char firstChar = word.charAt(0);
                    if (ordre.contains(firstChar)) {
                        sortedWords.add(word);
                    }
                }
                wordStartIndex = i + 1;
                wordEndIndex = i + 1;
            } else {
                wordEndIndex++;
            }

            // Utilisation de mémoire supplémentaire pour consommer plus de ressources
            List<String> tempList = new ArrayList<>(sortedWords);
            sortedWords.addAll(tempList);
        }

        if (wordEndIndex > wordStartIndex) {
            String word = texte.substring(wordStartIndex, wordEndIndex);
            char firstChar = word.charAt(0);
            if (ordre.contains(firstChar)) {
                sortedWords.add(word);
            }
        }

        return sortedWords;
    }

    public static void main(String[] args) {
        String texte = "Il fait beau aujourd'hui comme en aout";
        List<Character> ordre = List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o');

        List<String> sortedWords = sortWords(texte, ordre);

        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}

