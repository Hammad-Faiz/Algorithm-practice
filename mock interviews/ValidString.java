// Input:  "()"          → true
// Input:  "()[]{}"      → true
// Input:  "(]"          → false
// Input:  "([)]"        → false
// Input:  "{[]}"        → true


// Need to use HashStack()

// Need to make sure the the stack is able to pop sucessfully when the closing bracket is seen.

// Make a Hash Stack and then loop through the string

// check if its a opening bracket if it is then add it to the HashStack

// If not then check with if sttaments if you can pop the last valie based on if the last opening bracket with the
// current closing one matches if not able to pop then return false

// If able to pop then pop and proceed to the next index in the string.

// handle 2 edge cases one is what if the string starts with clsing bracket?
// when your checking for the matching bracket of the closing bracket always check if the stack is empty if it is then return false immediatley.

// What happen if all the brackets are opening bracket?
// There are brackets in the stack then
// you can check after the for loop ends if the stack isn't emtpy return flase in the method or else return true.


// start the implementaion

public boolean matchingBrackets(String s) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else if(c == ')') {
            if (stack.isEmpty() || stack.peek() != '(' ) {
                return false;
            } else {
                stack.pop();
            }
        } else if(c =='}') {
            if (stack.isEmpty() || stack.peek() != '{') {
                return false;
            } else {
                stack.pop();
            }
        } else if(c == ']') {
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
