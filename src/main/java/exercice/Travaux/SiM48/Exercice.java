package exercice.Travaux.SiM48;

import java.util.*;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        String[] mots = texte.split(" '");
        List<String> motsClassés = new ArrayList<>();
        List<String> motsNonClassés = new ArrayList<>();

        for (String mot : mots) {
            char premiereLettre = Character.toLowerCase(mot.charAt(0));

            if (ordre.contains(premiereLettre)) {
                motsClassés.add(mot);
            } else {
                motsNonClassés.add(mot);
            }
        }

        motsClassés.addAll(motsNonClassés);

        return motsClassés;
    }

}