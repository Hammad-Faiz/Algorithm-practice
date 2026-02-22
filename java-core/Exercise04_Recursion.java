// Exercise 04 - Recursion
// ----------------------------------------
// TODO 1: Write a recursive method called factorial(int n)
//         that returns n! (n factorial)
//         factorial(5) should return 120
//         Remember: base case is n == 1, return 1

// TODO 2: Write a recursive method called sumDownTo(int n)
//         that adds all numbers from n down to 1
//         sumDownTo(5) should return 15 (5+4+3+2+1)

// TODO 3: Write a recursive method called countDown(int n)
//         that prints each number from n down to 1, then prints "Go!"

public class Exercise04_Recursion {

    // --- TODO 1 ---
    public static int factorial(int n) {
        if (n == 1) return 1;

        return n * factorial(n - 1);
    }

    // --- TODO 2 ---
    public static int sumDownTo(int n) {
        if (n ==  1) return 1;

        return n + sumDownTo(n - 1);
    }

    // --- TODO 3 ---
    public static void countDown(int n) {
        if (n == 0) {
            System.out.println("Go!");
            return;
        }

        System.out.println(n);
        countDown(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));   // should print 120
        System.out.println(sumDownTo(5));   // should print 15
        countDown(5);                       // should print 5 4 3 2 1 Go!
    }
}



//Person 4: "I need factorial(4), gimme factorial(3) first" → waits
//Person 3: "I need factorial(3), gimme factorial(2) first" → waits
//Person 2: "I need factorial(2), gimme factorial(1) first" → waits
//Person 1: "factorial(1)? that's just 1, here" → done, goes home
//
//Person 2 gets 1 back: "2 * 1 = 2, here you go" → done, goes home
//Person 3 gets 2 back: "3 * 2 = 6, here you go" → done, goes home
//Person 4 gets 6 back: "4 * 6 = 24, here you go" → done, goes home


