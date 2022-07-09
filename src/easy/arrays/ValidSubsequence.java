package easy.arrays;

import java.util.List;

public class ValidSubsequence {

    public static void main(String ... args) {
        List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, 10);
        System.out.println(isValidSubsequenceSolution1(array, sequence));
        System.out.println(isValidSubsequenceSolution2(array, sequence));
    }

    // Solution 1
    public static boolean isValidSubsequenceSolution1(List<Integer> array, List<Integer> sequence) {

        int i = 0, j = 0;
        Integer valueArray;
        while (i < sequence.size()) {
            if (j == array.size()) {
                return false;
            }
            Integer valueSequence = sequence.get(i);
            while (j < array.size()) {
                valueArray = array.get(j);
                if (valueSequence.equals(valueArray)) {
                    i++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }
        return true;
    }

    // Solution 2
    public static boolean isValidSubsequenceSolution2(List<Integer> array, List<Integer> sequence) {
        int i = 0, j = 0;
        while (i < sequence.size() && j < array.size()) {
            Integer valueSequence = sequence.get(i);
            Integer valueArray = array.get(j);
            if (valueSequence.equals(valueArray)) {
                i++;
            }
            j++;
        }
        return i == sequence.size();
    }
}