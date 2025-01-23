public class Solution {
  public boolean isMatch(String text, String pattern) {
    // Base case: If pattern is empty, check if text is also empty
    if (pattern.isEmpty()) {
      return text.isEmpty();
    }

    // Check if the first character matches
    boolean firstMatch =
        (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

    // Recursively check the rest of the text and pattern
    return firstMatch && isMatch(text.substring(1), pattern.substring(1));
  }
}