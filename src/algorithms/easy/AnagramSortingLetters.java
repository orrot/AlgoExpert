package algorithms.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramSortingLetters {

    public static void main(String ... args) {
        // Returns if the string1 and string2 are anagram

        System.out.println(areAnagram("onidi", "indio"));
        System.out.println(areAnagram("onidio", "indio"));
    }

    public static boolean areAnagram(String word1, String word2) {
        // Time Complexity: o(nlogn)
        // Space Complexity o(1)

        // current + one is the merge BiFunction in the ToMap
        char[] letters1 = word1.toCharArray();
        char[] letters2 = word2.toCharArray();

        Arrays.sort(letters1);
        Arrays.sort(letters2);
        return Arrays.equals(letters1, letters2);
    }

    private static Map<String, Integer> getNumberOfLettersInWord(String word1) {
        return Arrays.stream(word1.split(""))
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }
}