import java.util.HashMap;

// Exercise 13: Longest Substring Without Repeating Characters
// Difficulty: Medium
// LeetCode #3
//
// Problem: Given a string s, find the length of the longest substring without repeating characters.
//
// Approach: Sliding window with HashMap
// - Store each character's last seen 1-based position in a HashMap
// - resetValue tracks where the current window started (old position of last duplicate)
// - If a character was seen inside the current window (hashMap.get(c) > resetValue), recalculate window length
// - If a character was seen before the current window, treat it as new and extend
//
// Time Complexity:  O(n) - single pass
// Space Complexity: O(n) - HashMap storing up to n characters

public class Exercise13_LongestSubstring {

    public int findLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        int highestLength = 1;
        int countLength = 0;
        int resetValue = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int l = i + 1;

            if (hashMap.containsKey(c) && hashMap.get(c) > resetValue) {
                countLength = l - hashMap.get(c);
                resetValue = hashMap.get(c);
                hashMap.put(c, l);
            } else {
                hashMap.put(c, l);
                countLength += 1;
            }

            if (countLength > highestLength) {
                highestLength = countLength;
            }
        }

        return highestLength;
    }

    public static void main(String[] args) {
        Exercise13_LongestSubstring sol = new Exercise13_LongestSubstring();

        System.out.println(sol.findLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.findLongestSubstring("bbbbb"));    // 1
        System.out.println(sol.findLongestSubstring("pwwkew"));   // 3
        System.out.println(sol.findLongestSubstring("dvdf"));     // 3
        System.out.println(sol.findLongestSubstring("abba"));     // 2
    }
}
