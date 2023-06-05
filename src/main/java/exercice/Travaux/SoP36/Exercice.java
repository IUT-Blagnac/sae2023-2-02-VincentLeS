package exercice.Travaux.SoP36;

import java.util.ArrayList;
import java.util.List;

public class Exercice {

	public static List<String> solution(String str, List<Character> order) {
        if (str.isEmpty() || str.isBlank()) {
            return List.of();
        }

        String modifiedStr = replaceSpecialCharacters(str);

        String[] words = splitIntoWords(modifiedStr);

        List<String> wordList = convertArrayToList(words);

        List<String> nonSortableWords = new ArrayList<>();
        List<Integer> indexesToRemove = new ArrayList<>();

        boolean hasChanged = true;
        for (int i = 0; hasChanged; i = (i + 1) % (words.length)) {
            hasChanged = false;
            for (int j = 0; j < wordList.size() - 1; j++) {
                int comparisonResult = compareWords(wordList.get(j), wordList.get(j + 1), order);

                switch (comparisonResult) {
                    case 1000:
                        addNonSortableWords(nonSortableWords, wordList.get(j), wordList.get(j + 1));
                        addIndexesToRemove(indexesToRemove, j, j + 1);
                        j++;
                        hasChanged = true;
                        break;

                    case 999:
                        addNonSortableWords(nonSortableWords, wordList.get(j));
                        addIndexesToRemove(indexesToRemove, j);
                        hasChanged = true;
                        break;

                    case 1001:
                        addNonSortableWords(nonSortableWords, wordList.get(j + 1));
                        addIndexesToRemove(indexesToRemove, j + 1);
                        hasChanged = true;
                        break;

                    case 1:
                        swapWords(wordList, j, j + 1);
                        hasChanged = true;
                        break;
                }

                removeWordsByIndexes(wordList, indexesToRemove);
                indexesToRemove.clear();
            }
        }

        removeBlankWords(wordList);

        wordList.addAll(nonSortableWords);

        return wordList;
    }

    private static String replaceSpecialCharacters(String str) {
        char[] specialChars = {'\'', '-', ',', ';', '?', '!', '\"'};

        String modifiedStr = str;
        for (char c : specialChars) {
            modifiedStr = modifiedStr.replace(c, ' ');
        }
        return modifiedStr;
    }

    private static String[] splitIntoWords(String str) {
        return str.split(" ");
    }

    private static List<String> convertArrayToList(String[] arr) {
        List<String> list = new ArrayList<>();
        for (String word : arr) {
            list.add(word);
        }
        return list;
    }

    private static void addNonSortableWords(List<String> nonSortableWords, String... words) {
        for (String word : words) {
            nonSortableWords.add(word);
        }
    }

    private static void addIndexesToRemove(List<Integer> indexes, int... indices) {
        for (int index : indices) {
            indexes.add(index);
        }
    }

    private static void swapWords(List<String> words, int index1, int index2) {
        String temp = words.get(index1);
        words.set(index1, words.get(index2));
        words.set(index2, temp);
    }

    private static void removeWordsByIndexes(List<String> words, List<Integer> indexes) {
        for (int i = indexes.size() - 1; i >= 0; i--) {
            words.remove((int) indexes.get(i));
        }
    }

    private static void removeBlankWords(List<String> words) {
        for (int i = words.size() - 1; i >= 0; i--) {
            if (words.get(i).isBlank()) {
                words.remove(i);
            }
        }
    }

    private static int compareWords(String word1, String word2, List<Character> order) {
        if (word1.isEmpty() && word2.isEmpty()) {
            return 0;
        }

        int rankWord1 = Integer.MAX_VALUE;
        if (!word1.isEmpty()) {
            char firstCharWord1 = word1.charAt(0);
            if (order.contains(firstCharWord1)) {
                rankWord1 = order.indexOf(firstCharWord1);
            }
        } else {
            return 1;
        }

        int rankWord2 = Integer.MAX_VALUE;
        if (!word2.isEmpty()) {
            char firstCharWord2 = word2.charAt(0);
            if (order.contains(firstCharWord2)) {
                rankWord2 = order.indexOf(firstCharWord2);
            }
        } else {
            return -1;
        }

        if (rankWord1 == Integer.MAX_VALUE && rankWord2 == Integer.MAX_VALUE) {
            return 1000;
        }
        if (rankWord1 == Integer.MAX_VALUE) {
            return 999;
        }
        if (rankWord2 == Integer.MAX_VALUE) {
            return 1001;
        }

        if (rankWord1 < rankWord2) {
            return -1;
        }
        if (rankWord2 < rankWord1) {
            return 1;
        }
        if (compareWords(word1.substring(1), word2.substring(1), order) > 2) {
            return 0;
        } else {
            return compareWords(word1.substring(1), word2.substring(1), order);
        }
    }
}
