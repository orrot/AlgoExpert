package easy.arrays;

import java.util.Arrays;

public class SumOfTwoIntegers {

    public static void main(String ... args) {
        int[] array = new int[] {3, 5, -4, 8, 11, 1, -1, 6};
        int[] result = twoNumberSum(array, 10);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        for (int i = 0; i < array.length ;i++) {
            for (int j = 0; j < array.length ;j++) {
                int currentSum = array[i] + array[j];
                if (array[i] != array[j] && currentSum == targetSum) {
                    return new int[] { array[i], array[j] };
                }
            }
        }
        return new int[0];
    }
}