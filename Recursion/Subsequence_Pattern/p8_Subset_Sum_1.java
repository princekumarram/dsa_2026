import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class p8_Subset_Sum_1 {

    static List<Integer> subsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        findSums(0, 0, arr, sums);
        Collections.sort(sums);
        return sums;
    }

    static void findSums(int index, int currentSum, int[] arr, List<Integer> sums) {

        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }

        findSums(index + 1, currentSum + arr[index], arr, sums);

        findSums(index + 1, currentSum, arr, sums);
    }

    public static void main(String[] args) {
        // Generate all subset sums
        // Input: [1,2,3]
        // Output: [0,1,2,3,3,4,5,6]

        int[] arr = { 5, 2, 1 };
        List<Integer> result = subsetSums(arr);

        for (int sum : result) {
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}
