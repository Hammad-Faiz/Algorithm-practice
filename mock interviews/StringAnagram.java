// Input:  s = "anagram", t = "nagaram"
// Output: true

// Input:  s = "rat", t = "car"
// Output: false

// Input:  s = "hello", t = "world"
// Output: false


// if the length() of the 2 string doesn't match then return false immedatley.

public boolean stringAnagram(String s, String t) {

    if (s.length() != t.length()){
        return false;
    }

    // Now loop through the first string and put it in the hash map as a key and the value as the amount of times seen.

    HashMap<Character, Integer> hashMap = new HashMap<>();

    // first loop
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
    }

    //check if the char value in the string exists in the hashMap if not then return false.
    //If so then check if its value in hashMap is greater than 1 is so then do -1 to the value or else if the value is 1 then remove it from hashMap.
    // second loop
    for (int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        if (hashMap.containsKey(c)){
            int getValue = hashMap.get(c);
            if (getValue > 1) {
                hashMap.put(c, getValue - 1);
            } else {
                hashMap.remove(c); // asssuming this .remove will work for now.
            }
        } else {
            return false;
        }
    }

    return true;

}