package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texte = "exemple de texte a classer";
        List<Character> ordre = List.of('c', 't', 'e', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd');
        System.out.println(SimpliciteMeilleur.solution(texte, ordre));
        System.out.println(EfficaciteMeilleur.solution(texte, ordre));
        System.out.println(SobrieteMeilleur.solution(texte, ordre));
        // output: [classer, texte, exemple, a, de]
    }
}
