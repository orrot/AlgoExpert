package main.algorithms.medium;

import java.util.*;

public class GroupsOfAnagramsBySortingLetters {

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.

        Map<String, List<String>> wordsByAnagramLetters = new HashMap<>();

        for (String word : words) {
            String wordWithSortedLetters = getWordWithSortedLetters(word);
            wordsByAnagramLetters
                    .compute(wordWithSortedLetters,
                            (k, v) -> generateListWithWordOrAddWord(v, word));
        }

        return new ArrayList<>(wordsByAnagramLetters.values());
    }

    private static List<String> generateListWithWordOrAddWord(List<String> currentAnagrams, String word) {

        if (currentAnagrams == null) {
            List<String> anagrams = new ArrayList<>();
            anagrams.add(word);
            return anagrams;
        }
        currentAnagrams.add(word);
        return currentAnagrams;
    }

    private static String getWordWithSortedLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }
}