// Exercise 05 - Algorithm Problems: Arrays
// ----------------------------------------
// These are real interview questions. Try each one yourself before running.
//
// TODO 1: FizzBuzz
//         Loop from 1 to 20.
//         - If the number is divisible by 3, print "Fizz"
//         - If divisible by 5, print "Buzz"
//         - If divisible by both 3 AND 5, print "FizzBuzz"
//         - Otherwise print the number
//         Hint: use the % (modulo) operator — 10 % 3 gives the remainder

// TODO 2: Find the largest number in an array
//         Given the array below, find and print the largest number WITHOUT
//         using any built-in sort or max methods. Use a loop.

// TODO 3: Two Sum
//         Given an array of numbers and a target, find TWO numbers in the
//         array that add up to the target and print them.
//         array = {2, 7, 11, 15}, target = 9 → should print 2 and 7
//         Hint: you already know HashMap — there's a clean way to solve this with one


import java.util.HashMap;

import java.util.HashSet;

public class Exercise05_ArrayProblems {

    // --- TODO 1: FizzBuzz ---
    public static void fizzBuzz() {
        for (int i = 1; i <= 20; i++){
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    // --- TODO 2: Find largest number ---
    public static int findLargest(int[] numbers) {
        // I can make a variable and check as I am looping through the array if its bigger than current value of the variable, if so then swap the varibale
        // value with it. THis way it will be o(n) operation. And o(1) for space complexity because we have declared one integer variable.

        int highestValue = numbers[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > highestValue) {
                highestValue = numbers[i];
            }
        }
        return highestValue;
    }

    // --- TODO 3: Two Sum ---
    public static void twoSum(int[] numbers, int target) {
        // 1 you grab the value of your index in the array and then from that index check the rest of the array to see target value
        // this will be 2 loops o(n)^2

        // i is at the last number
        // jay reaches the last number


//        HashMap<Integer, Integer> hashedNums = new HashMap<>();


        // --- TODO:  How to use Hash Set to optimize this solution ---
        // Make a Hash Set and put the numbers in it, then loop through it and see
        // if target - the current index value has been seen before in the hash set
        // if so then end the loop and print the 2 numbers.

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int lookUpNumber = target - numbers[i];
            boolean sumNumber = seen.contains(lookUpNumber);
            if (sumNumber) {
                System.out.println(lookUpNumber + " " + numbers[i]);
                return;
            }
            seen.add(numbers[i]);
        }

//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                        System.out.println(numbers[i] + " " + numbers[j]);
//                        return;
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println("--- FizzBuzz ---");
        fizzBuzz();

        System.out.println("--- Largest Number ---");
        int[] nums = {3, 7, 1, 15, 9, 2};
        System.out.println(findLargest(nums)); // should print 15

        System.out.println("--- Two Sum ---");
        int[] twoSumNums = {2, 7, 11, 15};
        twoSum(twoSumNums, 9); // should print 2 and 7
    }
}
