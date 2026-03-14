import java.util.HashMap;

public class Exercise09_FirstNonRepeatingChar {

    // Problem: Given a string, find the first non-repeating character
    // and return its index. If none exists return -1.
    //
    // Example: "leetcode"    → 0  ('l' appears once)
    // Example: "aabb"        → -1 (every character repeats)
    // Example: "loveleetcode" → 2  ('v' appears once)
    //
    // Approach: HashMap frequency count + two loops
    // Time: O(n) | Space: O(n)

    public static int uniqueCharacter(String s) {

        // Loop 1: build frequency map
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        // Loop 2: find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(uniqueCharacter("leetcode"));    // 0
        System.out.println(uniqueCharacter("aabb"));        // -1
        System.out.println(uniqueCharacter("loveleetcode")); // 2
    }
}
