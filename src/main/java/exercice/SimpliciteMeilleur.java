package exercice;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpliciteMeilleur {

    /**
     * La fonction résout le problème de l'exercice.
     * La chaîne de caractère, prise en paramètres, est découpée en mots et triée
     * selon l'ordre donné.
     * Les mots non présents dans l'ordre sont placés à la fin de la chaîne.
     * 
     * @param str   chaîne de caractère à trier (String)
     * @param ordre ordre de tri (List<Character>)
     * @return la chaîne de caractère triée (List<String>)
     */
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<String>();

        // On découpe la chaîne de caractère en mots.
        ArrayList<String> listeMots = new ArrayList<String>(Arrays.asList(str.split(" ")));

        // On parcourt l'ordre de tri
        for (int i = 0; i < ordre.size(); i++) {
            // On recherche le mot commençant par la lettre courante
            for (int j = 0; j < listeMots.size(); j++) {
                if (listeMots.get(j).charAt(0) == ordre.get(i)) {
                    // ... on l'ajoute au résultat ...
                    result.add(listeMots.get(j));

                    // ... et on le supprime de la liste des mots.
                    listeMots.remove(j);

                    // Il est important de supprimer ce mot pour ne pas le traiter plusieurs fois.
                }
            }
        }

        // On ajoute les mots restants à la fin du résultat.
        for (int i = 0; i < listeMots.size(); i++) {
            // On vérifie que le mot n'a pas déjà été ajouté.
            if (listeMots.get(i) != null) {
                // Si ce n'est pas le cas, on l'ajoute.
                result.add(listeMots.get(i));
            }
        }
        // On retourne le résultat.
        return result;
    }
}
