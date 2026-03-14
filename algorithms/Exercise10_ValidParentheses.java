import java.util.Stack;

public class Exercise10_ValidParentheses {

    // Problem: Given a string of brackets determine if it is valid.
    // Valid means every opening bracket has a correct matching closing bracket.
    //
    // Example: "()"      → true
    // Example: "()[]{}"  → true
    // Example: "(]"      → false
    // Example: "([)]"    → false
    // Example: "{[]}"    → true
    //
    // Approach: Stack — push opening brackets, pop and verify on closing brackets
    // Time: O(n) | Space: O(n)

    public static boolean matchingBrackets(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(matchingBrackets("()"));       // true
        System.out.println(matchingBrackets("()[]{}"));   // true
        System.out.println(matchingBrackets("(]"));       // false
        System.out.println(matchingBrackets("([)]"));     // false
        System.out.println(matchingBrackets("{[]}"));     // true
        System.out.println(matchingBrackets(")("));       // false — empty stack edge case
        System.out.println(matchingBrackets("((("));      // false — unclosed brackets edge case
    }
}
