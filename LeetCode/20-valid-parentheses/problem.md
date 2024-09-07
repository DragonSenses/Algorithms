# Valid Parentheses

Given a string s containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

#### Example 1:

Input: s = "()"

Output: true

#### Example 2:

Input: s = "()[]{}"

Output: true

#### Example 3:

Input: s = "(]"

Output: false

#### Example 4:

Input: s = "([])"

Output: true

#### Constraints:

  - `1 <= s.length <= 10^4`
  - `s` consists of parentheses only `'()[]{}'`.

# Solution

- [**Stacks**](#stacks)
  - Time complexity: `O(n)`

### **Intuition**

Let's carefully read the problem statement to understand what makes an input string **valid**:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket must have a corresponding open bracket of the same type.

We also know that the input string only contains these characters: `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`.

To simplify the problem, let's consider a model where the string only consists of one type of parenthesis `()` and check whether it is valid or not:

```sh
# Valid cases
()          # Valid
()()        # Valid
(())        # Valid
(()())      # Valid
(((())))    # Valid

# Invalid cases
((          # Invalid
())         # Invalid
(()         # Invalid
)()(        # Invalid
(()))       # Invalid
```

#### Counter-based approach

Let's form a simple algorithm to match this problem.

1. **Process the expression one bracket at a time starting from the left.**
2. **Encountering an opening bracket** `(` may or may not indicate an invalid expression because there can be a matching ending bracket somewhere in the remaining part of the expression.
   - **Increment the counter** keeping track of left parenthesis: `left += 1`
3. **If we encounter a closing bracket**, this has two meanings:
   - There was no matching opening bracket for this closing bracket, and in that case, we have an invalid expression. This is the case when `left == 0`, i.e., when there are no unmatched left brackets available.
   - We had some **unmatched** opening bracket available to match this closing bracket. This is the case when `left > 0`, i.e., we have unmatched left brackets available.
4. **If we encounter a closing bracket** `)` when `left == 0`, then we have an invalid expression. Otherwise, **we decrement `left`**, thus reducing the number of unmatched left parenthesis available.
5. **Continue processing the string** until all parentheses have been processed.
6. **In the end, if we still have unmatched left parenthesis available**, this implies an invalid expression.

##### **Limitations: Why counter-based approach won't work for the complex problem**

Returning to the complex problem, the simple algorithm won't work because a counter-based approach only works when all the parentheses are of the same type. When we encounter a closing bracket, we simply assume a corresponding opening matching bracket is available if `left > 0`.

**How about maintaining a separate counter for different types of parentheses?**

This also won't work because the relative placement of the parentheses matters. Consider this example:

```sh
[{]
```

If we keep counters, then as soon as we encounter the closing square bracket, we would know there is an unmatched opening square bracket available. However, the **closest unmatched opening bracket available is a curly bracket, not a square bracket**. Therefore, the counting approach fails in this scenario.

## Stacks

**Recursive property:** notice that a sub-expression of a valid expression should also be a valid expression. This means that if an entire expression is valid then the sub portions of it are also valid inthemslves. This lends a sort of recursive structure to the problem.

e.g., Consider this example:

```sh
{[[]{}]}()()

# Valid Sub-Expressions:
{[[]{}]}
[[]{}]
()()
()
```

We can leverage this recursive property by removing matching pairs of parentheses from the expression whenever we encounter them. The stack data structure is excellent for representing this recursive structure of the problem.

We cannot process the problem from the inside out because we don't have a clear idea about the overall structure. However, the stack can help us process this recursively, i.e., from the outside inwards.

### **Algorithm**

1. **Initialize a stack** `S`.
2. **Process each bracket** of the expression one at a time.
3. **If an opening bracket** is encountered, push it onto the stack. This means we will process it later and move on to the **sub-expression** ahead.
4. **If a closing bracket** is encountered, check the element on top of the stack:
   - If the top element is an opening bracket *of the same type*, pop it off the stack and continue processing.
   - Otherwise, this implies an invalid expression.
5. **At the end**, if the stack still contains elements, this implies an invalid expression.

### **Complexity Analysis**

Let `n` be the length of the input string.

**Time complexity**: `O(n)`

  - **Single Pass:** We traverse the given string one character at a time and perform push/pop operations on a stack, which take `O(1)` time.

**Space complexity**: `O(n)`

  - We push all opening brackets onto the stack, and in the worst case, we will end up pushing all the brackets onto the stack, e.g., `(((((((`.

### **Implementation**

#### Java

```java
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    // Initialize a stack to keep track of opening brackets
    Stack<Character> stack = new Stack<>();
    
    // Iterate through each character in the string
    for (char c : s.toCharArray()) {
      // If the character is an opening bracket, push it onto the stack
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      }
      // If the character is a closing bracket, check for matching opening bracket
      else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
        stack.pop(); // Pop the matching opening bracket from the stack
      } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
        stack.pop(); // Pop the matching opening bracket from the stack
      } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
        stack.pop(); // Pop the matching opening bracket from the stack
      }
      // If no matching opening bracket is found, return false
      else {
        return false;
      }
    }
    
    // If the stack is empty, all brackets were matched correctly
    return stack.isEmpty();
  }
}
```

**Improvement:** Store all valid characters in `HashMap`, the primary benefit is improved code readability and maintainability. Use of a HashMap for mapping the brackets improves code clarity and makes it easier to handle different types of brackets.

```java
import java.util.Stack;
import java.util.HashMap;

class Solution {
  // Hash table that stores mappings
  private HashMap<Character, Character> mappings;
  
  // Initialize hash map with mappings for improved code readability
  public Solution() {
    this.mappings = new HashMap<>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {
    // Initialize a stack to keep track of opening brackets
    Stack<Character> stack = new Stack<>();
    
    // Iterate through each character in the string
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket
      if (this.mappings.containsKey(c)) {
        // Get the top element of the stack. If the stack is empty, set a dummy value of '@'
        char topElement = stack.empty() ? '@' : stack.pop();

        // If the mapping for this closing bracket doesn't match the stack's top element, return false
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        // If it's an opening bracket, push it onto the stack
        stack.push(c);
      }
    }
    
    // If the stack is empty, all brackets were matched correctly
    return stack.isEmpty();
  }
}
```

Explanation:

1. **Initialization**: The `mappings` HashMap is initialized to store the corresponding opening brackets for each closing bracket.
2. **Iteration**: The method iterates through each character in the string.
3. **Closing Bracket Handling**: If a closing bracket is encountered, it checks the top element of the stack:
   - If the stack is empty, a dummy value `@` is used.
   - If the top element does not match the expected opening bracket from the `mappings`, the method returns `false`.
4. **Opening Bracket Handling**: If an opening bracket is encountered, it is pushed onto the stack.
5. **Final Check**: After processing all characters, if the stack is empty, it means all brackets were matched correctly, and the method returns `true`.

#### TypeScript

```typescript
// Hash map that stores valid parentheses mappings
const mappings: { [key: string]: string } = {
  ")": "(",
  "}": "{",
  "]": "[",
};

function isValid(s: string): boolean {
  // Initialize a stack to keep track of opening brackets
  const stack: string[] = [];

  // Iterate through each character in the string
  for (let i = 0; i < s.length; i++) {
    const c = s.charAt(i);

    // If the current character is a closing bracket
    if (mappings[c]) {
      // Get the top element of the stack.
      // If the stack is empty, set topChar to non-matching value (null character)
      const topChar = stack.length === 0 ? "\0" : stack.pop();

      // If the mapping for this closing bracket doesn't match the stack's top element, return false
      if (topChar !== mappings[c]) {
        return false;
      }
    } else {
      // If it's an opening bracket, push it onto the stack
      stack.push(c);
    }
  }

  // If the stack is empty, all brackets were matched correctly
  return stack.length === 0;
}
```
