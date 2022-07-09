package algorithms.easy;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        // Should find if the "target" number is in the "array" using the Binary Search Algorithm
        // array is already sorted

    }

    public static int binarySearch(int[] array, int target) {

        // The idea behind this algo, is to calculate the index based on the start and the end of the array
        // Why? because in the binary search, we can search in portions of the array...if the number is greater than the middle, the number should be in the right side of the array,
        //  otherwise in the left side (the number could be exactly in the middle too)
        // These indexes should be recalculated. The first iteration is easier...however, in the others iteration we need to accumulate the result because:
        // Ex: If the array is a ten length array, and the target number is on the 7 position,  the middle should be 3 after the division...however the number is greater, so it is the position 3 BUT considering the right side!!
        // Very tricky algorithm

        int middle = array.length / 2;
        int leftIndexArray = 0;
        int rightIndexArray = array.length;
        int realIndex = 0;

        while (middle != 0) {

            realIndex = leftIndexArray + middle;
            if (array[realIndex] == target) {
                return realIndex;
            }

            if (target < array[realIndex]) {
                rightIndexArray -= middle;
            } else {
                leftIndexArray += middle;
                rightIndexArray = array.length;
            }
            middle = (rightIndexArray - leftIndexArray) / 2;
        }
        return array[realIndex] == target ? middle : -1;
    }

}
