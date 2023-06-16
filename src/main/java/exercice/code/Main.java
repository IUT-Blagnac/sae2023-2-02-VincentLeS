package exercice.code;

import java.util.*;

//import exercice.Travaux.EfM19.Exercice;

//import exercice.Travaux.EfP20.Exercice;

//import exercice.Travaux.EfP36.Exercice;

//import exercice.Travaux.SiM5.Exercice;
//import exercice.Travaux.SiM48.Exercice;
//import exercice.Travaux.SiM54.Exercice;

//import exercice.Travaux.SiP37.Exercice;
//import exercice.Travaux.SiP56.Exercice;

//import exercice.Travaux.SoM10.Exercice;
//import exercice.Travaux.SoM52.Exercice;

//import exercice.Travaux.SoP36.Exercice;
import exercice.Travaux.SoP49.Exercice;



public class Main {
    public static void main(String[] args) {
        String texte = "exemple de texte a classer selon un ordre precis et important";
        // Le texte doit être en ASCII pour SobrietePire2.
        List<Character> ordre = List.of('c', 't', 'e', 'x', 'a', 'm', 'p', 'l', 's', 'r', 'd');

        List<String> solution = List.of("classer", "texte", "exemple", "et", "a", "precis", "selon", "de", "un",
                "ordre", "important");

        test(texte, ordre, solution);

        // Tests de base
        test("666 the number of the beast",
                List.of('6', 't', 'n', 'o', 'b'),
                List.of("666", "the", "the", "number", "of", "beast"));

        test("OK",
                List.of('6', 't', 'n', 'o', 'b'),
                List.of("OK"));

        test("",
                List.of('6', 't', 'n', 'o', 'b'),
                List.of(""));

        test("Il fait beau aujourd'hui comme en aout",
                List.of('f', 'I', 'z', 'u', 'k', 'a', 'b', 'o'),
                List.of("fait", "Il", "aujourd", "aout", "beau", "hui", "comme", "en"));

        // Mes tests

        test("Vive le pride-month",
                List.of('p', 'V', 'd', 'l'),
                List.of("pride", "Vive", "le", "month"));

        // Test UTF 8

        test("é à è ç ù â ê î ô û ä ë ï ö ü",
                List.of('à', 'é', 'è', 'ç', 'ù', 'â', 'ê', 'î', 'ô', 'û', 'ä', 'ë', 'ï', 'ö', 'ü'),
                List.of("à", "é", "è", "ç", "ù", "â", "ê", "î", "ô", "û", "ä", "ë", "ï", "ö", "ü"));

        // Test très long
        test("Bonjour je fais une phrase tres longue pour voir si les algorithmes avec une mauvaise complexite petent un plomb avec ce test",
                List.of('B'),
                List.of("Bonjour", "je", "fais", "une", "phrase", "tres", "longue", "pour", "voir", "si", "les",
                        "algorithmes", "avec", "une", "mauvaise", "complexite", "petent", "un", "plomb", "avec", "ce",
                        "test"));

        // Plusieurs fois le même mot
        test("vendredi vendredi vendredi Vendredi Vendredi Vendredi ",
                List.of('V'),
                List.of("Vendredi", "Vendredi", "Vendredi", "vendredi", "vendredi", "vendredi")

        );
    }

    /**
     * 
     */
    public static void test(String str, List<Character> ordre, List<String> expectedSolution) {
        System.out.println("=====================================");
        System.out.println("Test: " + str + " " + ordre);
        try {
            long startTime = System.nanoTime();
            List<String> solution = Exercice.solution(str, ordre);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000; // mcs

            if (solution.equals(expectedSolution)) {
                System.out.println("Test passed");
            } else {
                System.out.println("Test failed");
                System.out.println("Expected: " + expectedSolution);
                System.out.println("Got: " + solution);
            }
            System.out.println("Took " + duration + " microseconds");

        } catch (Exception e) {
            System.out.println("Test failed");
            System.out.println("Exception: " + e);
            return;
        }

    }
}
