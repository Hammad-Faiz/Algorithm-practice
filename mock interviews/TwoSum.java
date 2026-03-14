



public static int[] sumTarget(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[] {nums[i], nums[j]};
            }
        }
    }
    return new int[] {};
}


public static int[] sumTarget(int[] nums, int target) {

    HashSet<Integer> hashSet = new HashSet<>();

    // Make a hash list -- done
    // check target - nums[i] and then look for the value in the hash list --- done
    // if it exists then you found your 2 numbers --> return -- done
    // if not then add it to the hashList -- done

    for (int i = 0; 1 < nums.length; i++){
        int currentValue = nums[i];
        int lookUpValue = target - currentValue;
        if (hashSet.contains(lookUpValue)) {
            return new int[] {lookUpValue, currentValue};
        }
        hashSet.add(nums[i]);
    }
    return new int[] {};
}