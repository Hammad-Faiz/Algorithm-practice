import java.util.HashMap;

public class Exercise12_LongestSubstringWithoutRepeatingChars {

    // Problem: Given a string s, find the length of the longest substring
    // without repeating characters.
    //
    // Approach: Sliding window with HashMap
    // - Store each character's last seen 1-based position in a HashMap
    // - resetValue tracks the left boundary of the current window
    // - If a duplicate is found INSIDE the current window (hashMap.get(c) > resetValue),
    //   recalculate countLength from that old position
    // - If the duplicate is OUTSIDE the current window, treat it as new
    //
    // Time Complexity:  O(n) — single pass through string
    // Space Complexity: O(n) — HashMap storing up to n characters

    public int findLongestSubstring(String s) {
        if (s.length() == 0) { return 0; }

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

            if (countLength > highestLength) { highestLength = countLength; }
        }

        return highestLength;
    }
}
