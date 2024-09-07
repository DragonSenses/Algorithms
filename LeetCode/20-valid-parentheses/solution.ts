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
