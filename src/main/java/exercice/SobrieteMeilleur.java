package exercice;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SobrieteMeilleur {
    public static List<String> solution(String str, List<Character> ordre) {
        // La version du code trie de façon plus sobre les mots.
        // En effet, une seule liste est utilisée, et les mots sont déplacés au début de
        // la liste au fur et à mesure qu'ils sont trouvés.

        List<String> result = new ArrayList<String>(Arrays.asList(str.split(" ")));

        // On parcourt l'ordre de tri à l'envers
        for (int i = ordre.size() - 1; i >= 0; i--) {
            // On recherche les mots commençant par la lettre courante
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).charAt(0) == ordre.get(i)) {
                    // ... on les déplace au début de la liste ...
                    String elt = result.get(j);
                    result.remove(j);
                    result.add(0, elt);
                }
            }
        }
        return result;
    }
}
