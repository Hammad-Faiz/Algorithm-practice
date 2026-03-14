import java.util.HashMap;

public class Exercise10_TwoSum {

    // Problem: Given an array of integers, return the indices of the
    // two numbers that add up to a target sum.
    //
    // Example: [2, 7, 11, 15], target = 9  → [0, 1]
    // Example: [3, 2, 4],      target = 6  → [1, 2]
    // Example: [3, 3],         target = 6  → [0, 1]
    //
    // Approach: HashMap — store value as key, index as value
    // For each element check if complement (target - current) exists in map
    // Time: O(n) | Space: O(n)

    public static int[] returnTwoSumIndices(int[] array, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];

            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            } else {
                hashMap.put(array[i], i);
            }
        }

        // never reached — problem guarantees exactly one solution
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(returnTwoSumIndices(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(java.util.Arrays.toString(returnTwoSumIndices(new int[]{3, 2, 4}, 6)));       // [1, 2]
        System.out.println(java.util.Arrays.toString(returnTwoSumIndices(new int[]{3, 3}, 6)));          // [0, 1]
    }
}
