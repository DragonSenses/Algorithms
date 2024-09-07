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
