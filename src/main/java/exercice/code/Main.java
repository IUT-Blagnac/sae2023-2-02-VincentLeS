package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texte = "exemple de texte a classer selon un ordre precis et important";
        // Le texte doit être en ASCII pour SobrietePire2.
        List<Character> ordre = List.of('c', 't', 'e', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd');

        System.out.println(EfficacitePire2.solution(texte, ordre));

        // output: [classer, texte, exemple, a, de]
    }
}
