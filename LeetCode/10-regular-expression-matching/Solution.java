/**
 * Recursively matches text with a given pattern using regex.
 *
 * `.` Matches any single character.
 * `*` Matches zero or more of the preceding element.
 *
 * @param text The text to be matched.
 * @param pattern The pattern to match against.
 * @return Returns true if the text matches the pattern, false otherwise.
 */
public class Solution {
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
