package current;

import java.util.*;

class Program {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        // Write your code here.
        ArrayList<Integer[]> results = new ArrayList<>();
        for (int index = 0; index < array.length; index++) {
            ArrayList<Integer[]> tripletsByIndex = 	findIntegerTripletsIndex(array, targetSum, index);
            results.addAll(tripletsByIndex);
        }
        Comparator<Integer[]> comparatorNumber1 = Comparator.comparing(x -> x[0]);
        Comparator<Integer[]> comparatorNumber2 = Comparator.comparing(x -> x[1]);
        Comparator<Integer[]> comparatorNumber3 = Comparator.comparing(x -> x[2]);
        Collections.sort(results, comparatorNumber1
                .thenComparing(comparatorNumber2)
                .thenComparing(comparatorNumber3));
        return results;
    }

    public static ArrayList<Integer[]> findIntegerTripletsIndex(int[] array, int targetSum, int index) {

        int i = 0;
        ArrayList<Integer[]> tripletsByIndex = new ArrayList<>();
        while (i < array.length && i != index) {
            int j = 0;
            while (j < array.length && j != i) {
                System.out.print(array[index] + " ");
                System.out.print(array[i] + " ");
                System.out.print(array[j] + " ");
                System.out.println("Result: " + (array[index] + array[i] + array[j]) + " - " + targetSum);
                if (array[index] + array[i] + array[j] == targetSum) {
                    Integer[] triplet = new Integer[] {array[index], array[i], array[j]};
                    // Optimize this
                    Arrays.sort(triplet);
                    tripletsByIndex.add(triplet);
                }
                j++;
            }
            i++;
        }
        return tripletsByIndex;
    }
}
