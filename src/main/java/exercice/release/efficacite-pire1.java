package exercice;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = new ArrayList<String>(Arrays.asList(str.split(" ")));

        List<String> answer = verification(str, ordre);

        int i = 0;

        long start = System.currentTimeMillis();
        while (!result.equals(answer)) {
            Collections.shuffle(result);
            i++;

            // Activer ou désactiver l'affichage des itérations

            // ! \\ Activer ceci ralentit CONSIDERABLEMENT l'exécution du programme // ! \\

            if (false) {
                System.out.println("Itrération " + i + " : " + result.toString());
            }
        }

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        System.out.println("[EfficacitePire1] - Résolu en " + elapsedTime + "ms, " + i + " itérations.");

        return result;
    }

    public static List<String> verification(String str, List<Character> ordre) {
        List<String> result = new ArrayList<String>(Arrays.asList(str.split(" ")));

        for (int i = ordre.size() - 1; i >= 0; i--) {
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).charAt(0) == ordre.get(i)) {
                    String elt = result.get(j);
                    result.remove(j);
                    result.add(0, elt);
                }
            }

            for (int j = result.size() - 1; j >= 0; j--) {
                if (result.get(j).charAt(0) == ordre.get(i)) {
                    String elt = result.get(j);
                    result.remove(j);
                    result.add(0, elt);
                }
            }
        }
        return result;
    }
}
