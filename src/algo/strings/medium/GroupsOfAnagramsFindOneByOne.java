package algo.strings.medium;

import java.util.*;

public class GroupsOfAnagramsFindOneByOne {

    public static void main(String ... args) {

    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        // Write your code here.
        Set<String> calculated = new HashSet<>();
        List<List<String>> anagramGroups = new ArrayList<List<String>>();

        for (int i = 0; i < words.size(); i++) {
            if (!calculated.contains(words.get(i))) {
                String currentWord = words.get(i);
                calculated.add(currentWord);
                List<String> currentGroup = new ArrayList<>();
                currentGroup.add(currentWord);
                anagramGroups.add(currentGroup);
                for (int j = i + 1; j < words.size(); j++) {
                    if (isAnagram(currentWord, words.get(j))) {
                        calculated.add(words.get(j));
                        currentGroup.add(words.get(j));
                    }
                }
            }
        }

        return anagramGroups;
    }

    public static boolean isAnagram(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> lettersCount1 = generateMapLettersCount(word1);
        Map<Character, Integer> lettersCount2 = generateMapLettersCount(word2);
        return lettersCount1.equals(lettersCount2);
    }

    public static Map<Character, Integer> generateMapLettersCount(String word) {
        Map<Character, Integer> lettersCount = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            lettersCount.compute(word.charAt(i), (k,v) -> v == null ? 1 : v + 1);
        }
        return lettersCount;
    }

}