Input:  "abcabcbb"   → Output: 3   // "abc"
Input:  "bbbbb"      → Output: 1   // "b"
Input:  "pwwkew"     → Output: 3   // "wke"
Input:  ""           → Output: 0


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
        if(hashMap.containsKey(c) && hashMap.get(c) > resetValue) {
            countLength = l - hashMap.get(c);
            resetValue = hashMap.get(c);
            hashMap.put(c, l);
        } else {
            hashMap.put(c, l);
            countLength += 1;
        }
        if(countLength > highestLength) {highestLength = countLength};

    }

    return highestLength;


}