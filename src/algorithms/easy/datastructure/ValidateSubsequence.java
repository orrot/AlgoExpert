package algorithms.easy.datastructure;

import java.util.List;

public class ValidateSubsequence {

    public static void main(String[] args) {
        // given two non.empty arrays
        // Determine if the second one is a subsequence of the first one
        // Valid subsequence: Numbers in the same order (not necessarily adjacent)

        // Ex: {1,3,4} is a subsequent of {1,2,3,4}
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        // validate the size (subsequence should be smaller than array)

        for (int i = 0, j = 0; i < array.size(); i++) {

            if (array.get(i).equals(sequence.get(j))) {
                j++;
            }
            if (j >= sequence.size()) {
                return true;
            }
        }
        return false;
    }
}
