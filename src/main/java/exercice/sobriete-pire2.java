package exercice;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        /*
         * Pour créer ce programme, je me suis demandé :
         * "Quelle pourrait être la pire ressource
         * qu'un ordinateur pourrait utiliser pour répondre à un problème ?"
         * 
         * Est-ce que ce serait la mémoire ? Non, on peut toujours en rajouter.
         * Est-ce que ce serait le CPU ? Non, aujourd'hui les CPU sont très puissants.
         * 
         * Non. La pire ressource qu'un ordinateur pourrait utiliser pour répondre à un
         * problème, c'est l'utilisateur, lui-même.
         * 
         * C'est pour cela que j'ai créé ce programme, qui demande à l'utilisateur de
         * rentrer la phrase dans l'ordre.
         * 
         * C'est un programme qui ne peut pas être plus lent, car il dépend de la
         * vitesse de l'utilisateur. Et autant dire que l'utilisateur est très lent.
         * 
         * Ce programme est donc le pire programme possible. Que ce soit pour la
         * personne qui l'utilise, ou pour le programme lui-même, qui souffrira de votre
         * lenteur, et verra chaque petite fraction de miliseconde s'écouler
         * inéluctablement, comme une éternité.
         */

        List<String> result = new ArrayList<String>();

        List<String> answer = verification(str, ordre);
        Scanner scanner = new Scanner(System.in, "UTF-8");

        long start = System.currentTimeMillis();

        while (!result.equals(answer)) {
            for (int i = 1; i <= answer.size(); i++) {
                System.out.println("Merci de rentrer la phrase ('" + str +
                        "') dans l'ordre suivant selon le protocole : " +
                        ordre.toString() + "[n°" + i + "] : ");

                String input = scanner.nextLine();
                result.add(input);
            }

            if (!result.equals(answer)) {
                System.out.println("C'est incorrect, veuillez réessayer.");
                System.out.println("Vous avez entré : " + result.toString());
                System.out.println("Etait attendu :   " + answer.toString());
                result.clear();
            }
        }

        long stop = System.currentTimeMillis();

        long elapsedTime = stop - start;

        System.out.println("[SobrietePire2] - L'utilisateur a résolu ce problème en en " + elapsedTime + "ms.");

        return result;
    }

    public static List<String> verification(String str, List<Character> ordre) {
        // La version du code trie de façon plus sobre les mots.
        // En effet, une seule liste est utilisée, et les mots sont déplacés au début de
        // la liste au fur et à mesure qu'ils sont trouvés.

        List<String> result = new ArrayList<String>(Arrays.asList(str.split(" ")));

        // On parcourt l'ordre de tri à l'envers
        for (int i = ordre.size() - 1; i >= 0; i--) {
            // On recherche les mots commençant par la lettre courante
            // System.out.println("Recherche des mots commençant par " + ordre.get(i) +
            // "...");
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).charAt(0) == ordre.get(i)) {
                    // ... on les déplace au début de la liste ...
                    String elt = result.get(j);
                    result.remove(j);
                    result.add(0, elt);
                }
            }

            for (int j = result.size() - 1; j >= 0; j--) {
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
