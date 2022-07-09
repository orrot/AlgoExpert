package algo.strings.easy;

public class Palindrome {

    public static void main(String[] args) {

        // Calculate if a String is a palindrome
        // Palindrome == String that can be read in the same way forward and backward
    }

    public static boolean isPalindrome(String word) {

        int i = 0, j = word.length() - 1;
        while (i <= j && word.charAt(i) == word.charAt(j)) {
            i++;
            j--;
        }
        return i > j;
    }
}
