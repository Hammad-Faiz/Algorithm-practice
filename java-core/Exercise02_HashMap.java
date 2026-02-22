// Exercise 02 - HashMap
// ----------------------------------------
// TODO 1: Create a HashMap that stores a person's name (String) as the key
//         and their age (Integer) as the value. Add 3 people to it.
//
// TODO 2: Print out all the names and ages using a for-each loop
//
// TODO 3: Check if the name "Alice" exists in the map and print a message
//
// TODO 4: Remove one person from the map, then print the size of the map

import java.util.HashMap;

public class Exercise02_HashMap {

    public static void main(String[] args) {

        // --- TODO 1: create and populate the HashMap ---
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Faiz", 21);
        hashMap.put("Alice", 25);
        hashMap.put("Nile", 29);
        hashMap.put("Any", 43);

        // --- TODO 2: loop and print all names and ages ---
        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " is " + entry.getValue());
        }

        // --- TODO 3: check if "Alice" exists ---
        boolean aliceInHashMap = hashMap.containsKey("Alice");
        if (!aliceInHashMap) {
            System.out.println("Alice doesn't exist");
        } else {
            System.out.println("Alice exists");
        }

        // --- TODO 4: remove someone, print size ---
        hashMap.remove("Alice");
        System.out.println(hashMap.size());

    }
}
