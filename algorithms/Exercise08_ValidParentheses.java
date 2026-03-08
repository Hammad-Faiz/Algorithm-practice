// Exercise 08 - Valid Parentheses
// Difficulty: Easy/Medium | Classic interview problem
// ----------------------------------------
// Given a string containing only '(', ')', '{', '}', '[', ']'
// determine if the input string is valid.
//
// A string is valid if:
// - Every open bracket has a corresponding closing bracket
// - Brackets close in the correct order
//
// Examples:
// "()"       → true
// "()[]{}"   → true
// "(]"       → false (wrong closing bracket)
// "([)]"     → false (closed in wrong order)
// "{[]}"     → true
//
// Hint: think about what happens as you read left to right.
//       when you see an open bracket you are "expecting" something later.
//       what data structure works like a "last in first out" expectation?

import java.util.Stack;

public class Exercise08_ValidParentheses {

    public static boolean isValid(String s) {
        // TODO: implement this


        // what are stack?
        // something like popping or something

        // I would need to see what the current character is and then expect the oppsite brackets of that character in a certain position

        // I can loop through the string and each for each character

        // -------------> how would stacks come in here to help ?

        // if you loop through and check whats in the stack the last thing you would expect to see a certain character

        // and if you don't see it then it vreak and you can return false.

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '['){
                    stack.pop();
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else return false;
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));      // true
        System.out.println(isValid("()[]{}"));  // true
        System.out.println(isValid("(]"));      // false
        System.out.println(isValid("([)]"));    // false
        System.out.println(isValid("{[]}"));    // true
    }
}
