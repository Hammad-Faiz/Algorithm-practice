# Valid Parentheses

## Problem
Given a string containing only '(', ')', '{', '}', '[', ']'
determine if the string is valid.

Valid means:
- Every opening bracket has a matching closing bracket
- Brackets are closed in the correct order

```
"()"      → true
"()[]{}"  → true
"(]"      → false
"([)]"    → false
"{[]}"    → true
```

---

## Approach — Stack

Use a Stack:
- Opening bracket → push onto stack
- Closing bracket → check if top of stack matches, pop if yes, return false if no
- After loop → stack must be empty, otherwise unmatched opening brackets remain

---

## Two edge cases to handle

1. Closing bracket but stack is empty (e.g. ")(")
   → check stack.isEmpty() BEFORE calling peek()
   → if empty, return false immediately

2. All opening brackets, nothing closed (e.g. "(((" )
   → after loop, check if stack is NOT empty
   → if !stack.isEmpty() → return false

---

## Solution

```java
public boolean matchingBrackets(String s) {

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
```

---

## Key Stack methods

| Method | What it does | Throws exception? |
|--------|-------------|-------------------|
| push(x) | adds to top | no |
| pop() | removes and returns top | EmptyStackException if empty |
| peek() | returns top without removing | EmptyStackException if empty |
| isEmpty() | checks if stack has no elements | never — safe to call always |

---

## Critical rules

Always check isEmpty() BEFORE calling peek() or pop()
peek() and pop() throw EmptyStackException on empty stack — they do not return null

char comparison:
- Use == with single quotes → c == '('     ✅
- Never use .equals() on char — it's a primitive
- Never use double quotes → c == "("      ❌ compile error (char vs String)
