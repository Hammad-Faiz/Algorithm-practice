// Exercise 03 - String Manipulation
// ----------------------------------------
// TODO 1: Given the string below, print:
//         - its length
//         - the character at index 4
//         - the string in all uppercase
//         - the first 5 characters only (substring)

// TODO 2: Reverse the string "hello" manually using a loop
//         (don't use any built-in reverse method, think about it)

// TODO 3: Check if "racecar" is a palindrome
//         A palindrome reads the same forwards and backwards
//         Print "is a palindrome" or "is not a palindrome"

// TODO 4: Count how many times the letter 'l' appears in "hello world"

public class Exercise03_Strings {

    public static void main(String[] args) {

        // --- TODO 1 ---
        String word = "interview";
        System.out.println(word.length());
        System.out.println(word.charAt(4));
        System.out.println(word.toUpperCase());
        System.out.println(word.substring(0, 5));


        // --- TODO 2 ---
        String toReverse = "hello";
        StringBuilder reverseString = new StringBuilder();
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            reverseString.append(toReverse.charAt(i));
        }
        System.out.println(reverseString.toString());


        // --- TODO 3 ---
        String palindrome = "racecar";
        StringBuilder reversePalindrome = new StringBuilder();
        for (int i = palindrome.length() - 1; i >= 0; i--) {
            reversePalindrome.append(palindrome.charAt(i));
        }
        if (palindrome.equals(reversePalindrome.toString())) {
            System.out.println(palindrome + " is a palindrome");
        } else {
            System.out.println(palindrome + " is not a palindrome");
        }


        // --- TODO 4 ---
        String sentence = "hello world";
        int countLInSentence = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == 'l') {
             countLInSentence ++;
            }
        }
        System.out.println(countLInSentence);


    }
}
