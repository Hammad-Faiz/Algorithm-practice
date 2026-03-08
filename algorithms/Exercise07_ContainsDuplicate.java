// Exercise 07 - Contains Duplicate
// Difficulty: Easy | Very common in interviews
// ----------------------------------------
// Given an array of integers, return true if any value
// appears at least twice. Return false if every element is distinct.
//
// Examples:
// {1, 2, 3, 1}    → true  (1 appears twice)
// {1, 2, 3, 4}    → false (all distinct)
// {1, 1, 1, 3, 3} → true  (1 and 3 both appear twice)
//
// Hint: think about what data structure tells you instantly
//       whether you've seen something before


// HashMap stores keys with the value being the number of times this key was seen if I ever get more than 1
// immediatley return true


// Hashlist you can loop through the array and each value you see you can store it in the HashList and as you keep looping
// keep cehcking if that value exist in the Hashlist if it ever does immediatley return true

import java.util.HashSet;

public class Exercise07_ContainsDuplicate {


    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        // TODO: implement this

        boolean returnValue = false;

        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);
            }

        }

        return returnValue;


    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));    // true
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));    // false
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3})); // true
    }
}
