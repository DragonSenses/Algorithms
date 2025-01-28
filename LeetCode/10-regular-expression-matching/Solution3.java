public class Solution3 {
  public boolean isMatch(String text, String pattern) {
    // Base case: If pattern is empty, check if text is also empty
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }

    // Check if the first character matches
    boolean firstMatch =
        (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    // Check if the second character of the pattern is '*'
    if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
      // Ignore the '*' and its preceding character or use the '*' to match one or more occurrences
      return (isMatch(text, pattern.substring(2))
          || (firstMatch && isMatch(text.substring(1), pattern)));
    } else {
      // No '*', recursively check the rest of the text and pattern
      return firstMatch && isMatch(text.substring(1), pattern.substring(1));
    }
  }
}
