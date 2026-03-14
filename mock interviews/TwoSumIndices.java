
// Rules:
//  Each input has exactly one solution
//  You cannot use the same element twice
//  Return the indices, not the values


Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]   // nums[0] + nums[1] = 2 + 7 = 9

Input:  nums = [3, 2, 4], target = 6
Output: [1, 2]   // nums[1] + nums[2] = 2 + 4 = 6

Input:  nums = [3, 3], target = 6
Output: [0, 1]   // nums[0] + nums[1] = 3 + 3 = 6

public int[] returnTwoSumIndices(int[] array, int target) {



    HashMap<Integer, Integer> hashMap = new HashMap<>();
//    int[] returnIndexes = new int[2];

    for (int i = 0; i < array.length; i++) {
        int firstValue = target - array[i];
        // now we are gonna look if the second value exists int he hashMap
        if (hashMap.containsKey(firstValue)) {
            // then you found yourself the 2 indices that you need.
            return new int[] {hashMap.get(firstValue), i};
//            returnIndexes[0] = hashMap.get(firstValue);
//            returnIndexes[1] = i;
//            return returnIndexes;
        } else {
            hashMap.put(array[i], i);
        }
    }

    return new int[] {};

}

// o()


// Walking through this
// first approach is brute force
// ake 2 for loop checking if the 2 values add up to the target
// return the indexes when the target value is matched.

// HashMap:
// maybe first you find out the values that match the target and then you loop through the array again
// to find the indexes of those values and return them.


// how to you find the 2 values that add up to the target.
// You loop through the array and you do like target - index value then check if the result exist int he hashmap.

// once you get these values then store them in an array variable and then loop through

// When you save a values to hashMap store its index location.

// THis way when you find the first value you can know its location in the array and you already know the current index so you can just reutrn the 2 indices.

// ------------------------------
