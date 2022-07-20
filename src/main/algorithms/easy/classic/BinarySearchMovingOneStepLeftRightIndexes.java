package main.algorithms.easy.classic;

public class BinarySearchMovingOneStepLeftRightIndexes {

    public static void main(String[] args) {
        // Should find if the "target" number is in the "array" using the Binary Search Algorithm
        // array is already sorted

    }

    public static int binarySearch(int[] array, int target) {

        // The idea behind this algo, is to calculate the index based on the start and the end of the array
        // We are going to move left and right indexes 1 step to discard the middle if the middle is not the same
        // For this example, middle will be calculated by summing left and right indexes divided by 2

        int leftIndex = 0, rightIndex = array.length - 1;
        while (leftIndex <= rightIndex) {

            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == target) {
                return middleIndex;
            } else if (target < array[middleIndex]) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }

}
