// Exercise 06 - Streams & Lambdas
// ----------------------------------------
// TODO 1: Given the list of numbers below, use a stream to
//         filter out only the even numbers and print them

// TODO 2: Given the list of names below, use a stream to
//         convert all names to uppercase and print them

// TODO 3: Given the list of numbers below, use a stream to
//         filter numbers greater than 5, then multiply each by 2, then print them
//         (this chains filter + map together)

// TODO 4: Given the list of numbers below, use a stream to
//         get the sum of all numbers using reduce()

import java.util.List;
import java.util.stream.Collectors;

public class Exercise06_Streams {

    public static void main(String[] args) {

        // --- TODO 1: filter even numbers ---
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNums = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        evenNums.forEach(System.out::println);

        System.out.println("------------------------");


        // --- TODO 2: convert names to uppercase ---
        List<String> names = List.of("alice", "bob", "sara", "john");
        List<String> upperCaseNames = names.stream()
                .map(n -> n.toUpperCase())
                .collect(Collectors.toList());

        upperCaseNames.forEach(System.out::println);



        System.out.println("-------------------------");

        // --- TODO 3: filter > 5 then multiply by 2 ---
        List<Integer> numbers2 = List.of(3, 6, 8, 1, 9, 2, 7);
        List<Integer> sumNum = numbers2.stream()
                .filter(n -> n > 5)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        sumNum.forEach(System.out::println);


        System.out.println("-------------------------");

        // --- TODO 4: sum all numbers using reduce ---
        List<Integer> numbers3 = List.of(1, 2, 3, 4, 5);
        int sum = numbers3.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);



    }
}
