package exercice.Travaux.SiM54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> mots = new ArrayList<>(Arrays.asList(str.split("[^\\p{Alnum}]")));
        
        mots.removeIf(String::isEmpty);
        
        mots.sort((a, b) -> {
            int longueur_minimale = Math.min(a.length(), b.length());
            for (int i = 0; i < longueur_minimale; i++) {
                int indexA = ordre.indexOf(a.charAt(i));
                int indexB = ordre.indexOf(b.charAt(i));
                
                if (indexA != -1 && indexB != -1 && indexA != indexB) {
                    return Integer.compare(indexA, indexB);
                } else if (indexA != -1 && indexB != -1 && indexA == indexB && i + 1 < a.length() && i + 1 < b.length()) {
                    int indexA2 = ordre.indexOf(a.charAt(i + 1));
                    int indexB2 = ordre.indexOf(b.charAt(i + 1));
                    if (indexA2 != -1 && indexB2 != -1 && indexA2 != indexB2) {
                        return Integer.compare(indexA2, indexB2);
                    }
                } else if (indexA != -1 && indexB == -1) {
                    return -1;
                } else if (indexA == -1 && indexB != -1) {
                    return 1;
                }
            }
            
            return Integer.compare(a.length(), b.length());
        });
        
        return mots;
    }
}
