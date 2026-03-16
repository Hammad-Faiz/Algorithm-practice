public class Exercise12_SlidingWindowMaxK {

    // Problem: Given an array of integers and k, find the maximum sum
    // of any contiguous subarray of size k.
    //
    // Example: [2, 1, 5, 1, 3, 2], k=3 → 9  ([5, 1, 3])
    // Example: [2, 3, 4, 1, 5],    k=2 → 7  ([3, 4])
    //
    // Approach: Sliding Window
    // Time: O(n) | Space: O(1)

    public int returnSubarrayOfK(int[] array, int k) {

        // Loop 1: calculate first window sum
        int getSum = 0;
        for (int i = 0; i < k; i++) {
            getSum += array[i];
        }

        int highestSum = getSum;

        // Loop 2: slide the window
        for (int i = k; i < array.length; i++) {
            getSum = getSum - array[i - k] + array[i];
            if (getSum > highestSum) {
                highestSum = getSum;
            }
        }

        return highestSum;
    }

    public static void main(String[] args) {
        Exercise12_SlidingWindowMaxK sol = new Exercise12_SlidingWindowMaxK();
        System.out.println(sol.returnSubarrayOfK(new int[]{2, 1, 5, 1, 3, 2}, 3)); // 9
        System.out.println(sol.returnSubarrayOfK(new int[]{2, 3, 4, 1, 5}, 2));    // 7
    }
}
