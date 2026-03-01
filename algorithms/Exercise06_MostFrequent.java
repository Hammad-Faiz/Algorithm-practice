import java.util.HashMap;

public class Exercise06_MostFrequent {

    // I can make a hash map and store the numbers as a key and a value as how many times I have seen that numbers.
    // And as I am looping i can store the highest value I have seen
    // I need to store 2 things one is whats the biggest value for seen integer and second is
    // which integer that is that has the biggest value

    // make 2 variables one for storing the key which is the actual number and another for storing higehst value seen.



    // problem?
    // I have to get the key and then also check the value but what happens if the key is not there yet?
    // check with boolean and handle it different and if there then handle it another way.

    public static int highestSeenNumber(int[] array) {

        // This is o(n) storage
        HashMap<Integer, Integer> numberOfOccurrences = new HashMap<>();

        // o(1) storage
        int highestOccurrence = 1;
        int highestSeenInteger = array[0];

        // o(n) speed
        for (int i = 0; i < array.length; i++) {

            numberOfOccurrences.put(array[i], numberOfOccurrences.getOrDefault(array[i], 0) + 1); // so far the hashmap has been updated with + 1 for the value of current index key
            int currentKeyValue = numberOfOccurrences.get(array[i]);
            if (currentKeyValue > highestOccurrence) { // check if the current value of the index key is greater than the largest seen yet
                highestOccurrence = currentKeyValue; // if so then make the highest seen this new value
                highestSeenInteger = array[i]; // and update the value of the highest Integer in the array
            }

        }
        return highestSeenInteger;
    }


    public static void main(String[] args) {
        int[] listOfNumbers = {1, 3, 2, 3, 1, 3, 2};

        System.out.println(highestSeenNumber(listOfNumbers));
    }

}