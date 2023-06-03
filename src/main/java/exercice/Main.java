package exercice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String texte = "exemple de texte a classer selon un ordre précis et important";
        List<Character> ordre = List.of('c', 't', 'e', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd');
        System.out.println(SimplicitePire1.solution(texte, ordre));
        System.out.println(SimplicitePire2.solution(texte, ordre));
        System.out.println(SimplicitePire3.solution(texte, ordre));
        System.out.println(EfficacitePire1.solution(texte, ordre));
        // output: [classer, texte, exemple, a, de]
    }
}
