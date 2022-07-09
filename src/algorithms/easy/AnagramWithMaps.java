package algorithms.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramWithMaps {

    public static void main(String ... args) {
        System.out.println(areAnagram("onidi", "indio"));
        System.out.println(areAnagram("onidio", "indio"));
    }

    public static boolean areAnagram(String word1, String word2) {
        // Time Complexity: o(n)
        // Space Complexity o(n)

        // current + one is the merge BiFunction in the ToMap
        Map<String, Integer> numberOfLettersWord1 = getNumberOfLettersInWord(word1);
        Map<String, Integer> numberOfLettersWord2 = getNumberOfLettersInWord(word2);
        return numberOfLettersWord1.equals(numberOfLettersWord2);
    }

    private static Map<String, Integer> getNumberOfLettersInWord(String word1) {
        return Arrays.stream(word1.split(""))
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }
}