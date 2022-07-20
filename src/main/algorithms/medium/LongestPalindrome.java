package main.algorithms.medium;

public class LongestPalindrome {

    public static void main(String ... args) {
        // abaxyzzyxf
        //              0123456789
        String input = "5abbbba5";

        System.out.println("Output::" + getLongestPalindromeInString(input));
    }

    private static String getLongestPalindromeInString(String str) {

        String longestPalindrome = str.substring(0, 1);
        for (int index = 1; index < str.length() - 1; index++) {
            String palindrome = getLongestPalindromeFromIndex(str, index);
            if (palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }
        }
        return longestPalindrome;
    }

    private static String getLongestPalindromeFromIndex(String str, int index) {

        String palCharCenter = getPalindromeCharCenter(str, index);
        String palNonCharCenter = getPalindromeNonCharCenter(str, index);
        return palCharCenter.length() > palNonCharCenter.length() ? palCharCenter : palNonCharCenter;
    }

    private static String getPalindromeCharCenter(String str, int index) {
        return getPalindromeFromIndexes(str, index - 1, index + 1);
    }

    private static String getPalindromeNonCharCenter(String str, int index) {
        return getPalindromeFromIndexes(str, index, index + 1);
    }

    private static String getPalindromeFromIndexes(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length()) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                return str.substring(leftIndex + 1, rightIndex);
            }
            leftIndex--;
            rightIndex++;
        }
        return str.substring(leftIndex + 1, rightIndex);
    }
}