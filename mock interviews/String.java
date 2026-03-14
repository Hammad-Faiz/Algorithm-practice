

// find the first non repeating character and return its index, return -1 if none exist


// 2 for loops but thats problamatic because as you keep adding to the index you will not have track if the last character matched.


// 2 for loops. You start with index 0 and inside you check if the value of current index and current index + 1 values are the same
// return index of the current if they are not the same
// if so then proceed
// then proceed to current index + 1 but here check the current value is squal to index + 1 and check if its index plus




// loop throught the array, and store the value of the index and if it alaready exist in the hash map then do + 1 to its value
// if not then you add the key which would be the value of tje array index and the value in the hashmap would be 1
// and as you iterate you will check if it exist then do + 1 of not then save it with the value of 1.


// I don't need to loop through the third loop why is that?
// you have a hashmap with key as a value form th array and a value which twll how many times the key was seen
// you loop through it, get the value of this index value from the hashmap and check is its equal to 1 if so then return the index and if not then proceed if
// put a if statament chekcing if the i is on the last iteration after checking in the hasmap if value is not equal to 1 then using if statament (i == string.length() - 1, if so then return -1)

// first loop through the string and fill up the hashMap

public int uniqueCharacter(String s) {

    HashMap<Character, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        // int value = hashMap.get(c); // I am getting the integer value and then checking if the key in the hashmap exists which is the c. I am perhaps getting the
        // value before I know it exists. So I moved it down in the if statment.
//        hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        if (hashMap.containsKey(c)) {
            int value = hashMap.get(c);
            hashMap.put(c, value + 1);
        } else { // because if it hasn't been seen then its first time and value should be 1;
            hashMap.put(c, 1);
        }
    }

    // now I need a second loop because I need to find the first value in the hashMap thats a 1
    // If nothing is 1 then I will return -1


    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (hashMap.get(c) == 1) {
            return i;
        }
    }

    return -1;

}


// this is o(n) speed and o(n) space because hashMap in worst case scenario if all numbers in string are unique it would store n keys and values in the hashMap.