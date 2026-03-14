public class Exercise11_MaximumSubarray {

    // Problem: Given an array of integers, find the maximum sum
    // of any contiguous subarray.
    //
    // Example: [-2, 1, -3, 4, -1, 2, 1, -5, 4] → 6  ([4, -1, 2, 1])
    // Example: [1]                               → 1
    // Example: [-1, -2, -3]                      → -1 (single element)
    //
    // Brute Force: O(n²) time | O(1) space
    // Optimal (Kadane's): O(n) time | O(1) space

    // Brute Force
    public int largestSum(int[] array) {
        int highestSum = array[0];

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            if (currentValue > highestSum) highestSum = currentValue;

            for (int j = i + 1; j < array.length; j++) {
                currentValue = currentValue + array[j];
                if (currentValue > highestSum) highestSum = currentValue;
            }
        }

        return highestSum;
    }

    // Optimal — Kadane's Algorithm
    public int optimalLargestSum(int[] array) {
        int highestSum = array[0];
        int currentSum = array[0];

        for (int i = 0; i < array.length; i++) {

            // start fresh or extend?
            if (array[i] > currentSum + array[i]) {
                currentSum = array[i];
            } else {
                currentSum = currentSum + array[i];
            }

            // update highest if current is better
            if (currentSum > highestSum) {
                highestSum = currentSum;
            }
        }

        return highestSum;
    }

    public static void main(String[] args) {
        Exercise11_MaximumSubarray sol = new Exercise11_MaximumSubarray();

        // Brute force
        System.out.println(sol.largestSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(sol.largestSum(new int[]{1}));                               // 1
        System.out.println(sol.largestSum(new int[]{-1, -2, -3}));                      // -1

        // Optimal
        System.out.println(sol.optimalLargestSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(sol.optimalLargestSum(new int[]{1}));                               // 1
        System.out.println(sol.optimalLargestSum(new int[]{-1, -2, -3}));                      // -1
    }
}
