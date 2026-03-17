import java.util.HashMap;

public class Exercise12_StringAnagram {

    // Problem: Given two strings s and t, return true if t is an anagram of s.
    // An anagram uses all original letters exactly once, rearranged.
    //
    // Example: s = "anagram", t = "nagaram" → true
    // Example: s = "rat",     t = "car"     → false
    //
    // Approach: HashMap frequency count
    // Time: O(n) | Space: O(n)

    public boolean stringAnagram(String s, String t) {

        // lengths must match — quick early exit
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        // Loop 1: build frequency map from s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        // Loop 2: decrement/remove for each char in t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (hashMap.containsKey(c)) {
                int getValue = hashMap.get(c);
                if (getValue > 1) {
                    hashMap.put(c, getValue - 1);
                } else {
                    hashMap.remove(c);
                }
            } else {
                return false; // char in t not found in s
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Exercise12_StringAnagram sol = new Exercise12_StringAnagram();
        System.out.println(sol.stringAnagram("anagram", "nagaram")); // true
        System.out.println(sol.stringAnagram("rat", "car"));         // false
        System.out.println(sol.stringAnagram("hello", "world"));     // false
    }
}
