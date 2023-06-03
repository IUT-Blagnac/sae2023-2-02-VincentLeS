package exercice;

import java.util.List;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class EfficacitePire2 {
    public static List<String> solution(String str, List<Character> ordre) {
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

        hunger_games(new ArrayList<>(result));

        return result;
    }

    public static void hunger_games(List<String> players) {
        Scanner s = new Scanner(System.in);

        System.out.println("[EfficacitePire2] - Appuyez sur Entrée à chaque fois pour continuer.");
        s.nextLine();

        System.out.println("[Président Snow] - Bienvenue, bienvenue, bienvenue...");
        s.nextLine();

        System.out.println("[Président Snow] - Tribus de Panem, je vous souhaite la bienvenue aux 74e Hunger Games !");
        s.nextLine();

        System.out.println(
                "[Président Snow] - Nous saluons votre courage et votre sacrifice, " +
                        "et nous espérons que la chance vous sourira.");
        s.nextLine();

        System.out.println("[Président Snow] - Puisse le sort vous être favorable !");
        s.nextLine();

        System.out.println("[Président Snow] - Que les 74e Hunger Games commencent !");
        s.nextLine();

        ArrayList<String> messages = new ArrayList<String>();

        for (int i = 0; i < players.size(); i++) {
            messages.add("0'?' est mort(e) de faim. Il finit !ème.");
            messages.add("0'?' est décédé. Il finit !ème.");
            messages.add("0'?' s'est fait assassiner. Il finit !ème.");
            messages.add("0'?' se fait piquer par une guêpe mutante et décède. Il finit !ème.");

            messages.add("1'?' se promène.");
            messages.add("1'?' discute avec ses alliés.");
            messages.add("1'?' cherche de la nourriture à manger.");
            messages.add("1'?' cherche des baies magiques.");
            messages.add("1'?' se balade.");
            messages.add("1'?' trouve un bel étant.");

        }

        int day = 1;

        while (players.size() > 1) {
            System.out.println("Jour " + day + "\n");
            for (int i = 0; i < players.size(); i++) {

                s.nextLine();

                String message = messages.get((int) (Math.random() * messages.size()));
                char action = message.charAt(0);
                message = message.substring(1);

                if (action == '0') {
                    message = message.replace("!", "" + players.size());
                    message = message.replace("?", players.get(players.size() - 1));
                    System.out.println(message);
                    players.remove(players.size() - 1);
                    i--;
                } else if (action == '1') {
                    System.out.println(message.replace("?", players.get(i)));
                }

                if (players.size() == 1) {
                    System.out.println("\n" + players.get(0) + " rempote les 74èmes Hunger Games !");
                    break;
                }
            }
            day++;
        }
    }
}
